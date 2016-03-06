package com.dnst.repository;

import com.dnst.beans.Product;
import junit.framework.Assert;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;



    @Test
    public void getProductByIdTest() {
        final Product product = productRepository.getProductByBarCode("ITEM000005");
        Assert.assertNotNull("The loaded product should not null.", product);
        Assert.assertEquals("The product should same as test data.", "可口可乐", product.getName());
    }

}
