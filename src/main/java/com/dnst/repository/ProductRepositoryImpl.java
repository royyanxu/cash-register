package com.dnst.repository;

import com.dnst.beans.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Finley
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Logger               logger       = LoggerFactory.getLogger(ProductRepositoryImpl.class);
    private final Map<String, Product> productStore = new HashMap<>();

    private static final String PRODUCT_MOCK_FILE_PATH = "classpath:mockProduct.json";



    @PostConstruct
    private void loadProducts() {
        final Gson gson = new Gson();
        final List<Product> products = gson.fromJson(getProductMockData(), new TypeToken<List<Product>>() {
        }.getType());
        if (CollectionUtils.isNotEmpty(products)) {
            for (Product product : products) {
                productStore.put(product.getBarCode(), product);
            }
        }
        logger.debug("The initial products is {}", productStore);
    }



    private String getProductMockData() {
        String result = "";
        final ResourceLoader resourceLoader = new DefaultResourceLoader();
        final Resource mockProductResource = resourceLoader.getResource(PRODUCT_MOCK_FILE_PATH);
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(mockProductResource.getInputStream
                    ()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            logger.error("When execute get product data error occur.", e);
        }
        logger.debug("The product mock data result is {}", result);
        return result;
    }



    public Product getProductByBarCode(String barCode) {
        return productStore.get(barCode);
    }
}
