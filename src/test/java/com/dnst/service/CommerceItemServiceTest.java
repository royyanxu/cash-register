package com.dnst.service;

import com.dnst.beans.CommerceItem;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author finleyfeng
 * @version 1.0, 3/7/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CommerceItemServiceTest {
    @Autowired
    private CommerceItemService commerceItemService;



    @Test
    public void testCreateCommerceItem() {
        CommerceItem commerceItem = commerceItemService.createCommerceItem("ITEM000005", 5);
        Assert.assertNotNull("Created commerce item should not null", commerceItem);
        Assert.assertEquals("Quantity should same as assigned", 5, commerceItem.getQuantity());
        Assert.assertEquals("Related product's bar code should same as assigned", "ITEM000005",
                commerceItem.getProduct().getBarCode());
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommerceItemIllegalArgumentsQuantity() {
        commerceItemService.createCommerceItem("ITEM000005", -1);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommerceItemIllegalArgumentsBarCode() {
        commerceItemService.createCommerceItem("", 10);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommerceItemIllegalArgumentsBarCodeNotExists() {
        commerceItemService.createCommerceItem("ITEM000005111", 10);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommerceItemIllegalArgumentsBoth() {
        commerceItemService.createCommerceItem("", -1);
    }
}
