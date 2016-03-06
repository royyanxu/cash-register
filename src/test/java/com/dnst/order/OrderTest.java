package com.dnst.order;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;
import com.dnst.beans.Product;
import com.dnst.repository.ProductRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Finley
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderTest {

    @Autowired
    private ProductRepository productRepository;

    private Order order;



    @Before
    public void constructOrder() {
        order = new Order();
        CommerceItem commerceItem = new CommerceItem();
        order.getCommerceItems().add(commerceItem);
        Product product = productRepository.getProductByBarCode("ITEM000005");
        commerceItem.setProduct(product);
        commerceItem.setQuantity(10);
        // pricing
        commerceItem.setRawTotalPrice(commerceItem.getProduct().getListPrice() * commerceItem.getQuantity());
        commerceItem.setTotalPrice(commerceItem.getRawTotalPrice() - 10.0d);
        double rawSubTotal = 0d;
        double totalPrice = 0d;
        for (CommerceItem orderCommerceItem : order.getCommerceItems()) {
            rawSubTotal += orderCommerceItem.getRawTotalPrice();
            totalPrice += orderCommerceItem.getTotalPrice();
        }
        order.setRawSubTotalPrice(rawSubTotal);
        order.setTotalPrice(totalPrice);
    }



    @Test
    public void testOrder() {
        Assert.assertEquals("Discount amount should same as pre define value.", 10.0d, order.getDiscountAmount());
    }
}
