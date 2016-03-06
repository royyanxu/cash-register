package com.dnst.repository;

import com.dnst.product.Product;

/**
 * @author Finley
 */
public interface ProductRepository {
    Product getProductByBarCode(String barCode);
}
