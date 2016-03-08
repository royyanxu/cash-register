package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;
import com.dnst.beans.Product;
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
public class PricingServiceTest {

    @Autowired
    private PricingService pricingService;

    private CommerceItem commerceItem = new CommerceItem();



    @Before
    public void constructTestCommerceItem() {
        Product product = new Product();
        product.setListPrice(5);
        commerceItem.setProduct(product);
        commerceItem.setQuantity(10);
    }



    @Test
    public void testCalculateItemPriceInfo() {
        pricingService.calculateItemPriceInfo(commerceItem);
        Assert.assertNotNull("The price info object should be created.", commerceItem.getItemPriceInfo());
        Assert.assertEquals("The raw total price should same as quantity * listPrice", 50.0d,
                commerceItem.getItemPriceInfo().getRawTotalPrice());
        commerceItem.setItemPriceInfo(null);
    }



    @Test
    public void testCalculateOrderPriceInfo() {
        Order order = new Order();
        order.getCommerceItems().add(commerceItem);
        pricingService.calculateOrderPriceInfo(order);
        Assert.assertNotNull("The price object should be created.", order.getOrderPriceInfo());
        Assert.assertEquals("The raw sub total price should same as the sum of all commerce item's rawTotalPrice",
                50.0d, order.getOrderPriceInfo().getRawSubTotalPrice());
    }

}
