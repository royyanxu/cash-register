package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;
import com.dnst.beans.OrderPriceInfo;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;



    @Test
    public void testCreateOrder() {
        final Order order = orderService.createOrder();
        final OrderPriceInfo orderPriceInfo = order.getOrderPriceInfo();
        Assert.assertNotNull("The created order should not null.", order);
        Assert.assertNotNull("The created order's price info should not null.", orderPriceInfo);
    }



    @Test
    public void testCreateOrderByProductInfos() {
        final List<String> productInfos = new ArrayList<>();
        productInfos.add("ITEM000005");
        productInfos.add("ITEM000005");
        productInfos.add("ITEM000005");
        productInfos.add("ITEM000001-2");
        productInfos.add("ITEM000001-2");
        final Order order = orderService.createOrderByProductInfos(productInfos);
        Assert.assertNotNull("The created order should not null.", order);
        Assert.assertEquals("The commerce item quantity should as 2", 2, order.getCommerceItems().size());
        for (CommerceItem commerceItem : order.getCommerceItems()) {
            if (commerceItem.getProduct().getBarCode().equals("ITEM000005")) {
                Assert.assertEquals("ITEM000005 quantity should as 3", 3, commerceItem.getQuantity());
            } else if (commerceItem.getProduct().getBarCode().equals("ITEM000001")) {
                Assert.assertEquals("ITEM000001 quantity should as 4", 4, commerceItem.getQuantity());
            }
        }
    }

}
