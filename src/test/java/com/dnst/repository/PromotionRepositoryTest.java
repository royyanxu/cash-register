package com.dnst.repository;

import com.dnst.beans.Promotion;
import com.dnst.beans.PromotionalType;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Finley
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PromotionRepositoryTest {

    @Autowired
    private PromotionRepository promotionRepository;



    @Test
    public void testGetPromotionByBarCode() {
        List<Promotion> promotions = promotionRepository.getPromotionByBarCode("ITEM000005");
        Assert.assertNotNull("Should get promotions by mock data", promotions);
        Assert.assertEquals("Should get two promotions", 2, promotions.size());
    }



    @Test
    public void testGetPromotionById() {
        Promotion promotion = promotionRepository.getPromotionById("prom001");
        Assert.assertNotNull("Should get promotion by mock data", promotion);
        Assert.assertEquals("Should get suitable data from promotion", PromotionalType.BUY_X_SUB_Y,
                promotion.getPromotionalType());
    }

}
