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
import org.apache.velocity.tools.generic.NumberTool;

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
        velocityContext.put("numberTool", new NumberTool());
        velocityContext.put("newline", "\n");
        final StringWriter writer = new StringWriter();
        orderTemplate.merge(velocityContext, writer);
        System.out.println(writer.toString());
    }



    public static void main(String[] args) {
        Order order = new Order();
        Product product = new Product();
        product.setName("test");
        product.setListPrice(10.00d);
        product.setUnit("bang");
        CommerceItem commerceItem = new CommerceItem();
        commerceItem.setProduct(product);
        commerceItem.setQuantity(10);
        ItemPriceInfo itemPriceInfo = new ItemPriceInfo();
        itemPriceInfo.setListPrice(10);
        itemPriceInfo.setRawTotalPrice(100);
        itemPriceInfo.setAmount(90);
        itemPriceInfo.setDiscountAmount(10);
        itemPriceInfo.setDiscounted(true);
        commerceItem.setItemPriceInfo(itemPriceInfo);
        order.getCommerceItems().add(commerceItem);
        OrderPriceInfo orderPriceInfo = new OrderPriceInfo();
        orderPriceInfo.setAmount(90);
        orderPriceInfo.setDiscounted(true);
        orderPriceInfo.setDiscountAmount(10);
        order.setOrderPriceInfo(orderPriceInfo);
        printOrder(order);
    }

}
