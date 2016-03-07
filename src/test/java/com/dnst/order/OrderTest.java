package com.dnst.order;

import com.dnst.beans.Order;
import com.dnst.beans.OrderPriceInfo;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Finley
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderTest {

    private Order order;



    @Before
    public void constructOrder() {
        order = new Order();
        OrderPriceInfo orderPriceInfo = new OrderPriceInfo();
        orderPriceInfo.setAmount(100.0d);
        orderPriceInfo.setRawSubTotalPrice(110.0d);
        order.setOrderPriceInfo(orderPriceInfo);
        order.getOrderPriceInfo().setDiscountAmount(
                order.getOrderPriceInfo().getRawSubTotalPrice() - order.getOrderPriceInfo().getAmount());
    }



    @Test
    public void testOrder() {
        Assert.assertEquals("Discount amount should same as pre define value.", 10.0d,
                order.getOrderPriceInfo().getDiscountAmount());
    }
}
