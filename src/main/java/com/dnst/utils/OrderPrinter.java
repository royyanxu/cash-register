package com.dnst.utils;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.ItemPriceInfo;
import com.dnst.beans.Order;
import com.dnst.beans.OrderPriceInfo;
import com.dnst.beans.Product;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

/**
 * @author Finley
 */
public class OrderPrinter {
    private static VelocityEngine velocityEngine = new VelocityEngine();
    private static Template orderTemplate;

    static {
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        orderTemplate = velocityEngine.getTemplate("orderTemplate.vm", "utf-8");
    }

    public static void printOrder(Order order) {
        final VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("order", order);
        final StringWriter writer = new StringWriter();
        orderTemplate.merge(velocityContext, writer);
        System.out.println(writer.toString());
    }



    public static void main(String[] args) {
        Order order = new Order();
        Product product = new Product();
        product.setName("test");
        product.setListPrice(10.00d);
        CommerceItem commerceItem = new CommerceItem();
        commerceItem.setProduct(product);
        commerceItem.setQuantity(10);
        ItemPriceInfo itemPriceInfo = new ItemPriceInfo();
        itemPriceInfo.setListPrice(10);
        itemPriceInfo.setRawTotalPrice(100);
        itemPriceInfo.setAmount(100);
        itemPriceInfo.setDiscountAmount(90);
        itemPriceInfo.setDiscounted(true);
        commerceItem.setItemPriceInfo(itemPriceInfo);
        order.getCommerceItems().add(commerceItem);
        OrderPriceInfo orderPriceInfo = new OrderPriceInfo();
        orderPriceInfo.setAmount(90);
        order.setOrderPriceInfo(orderPriceInfo);
        printOrder(order);
    }

}
