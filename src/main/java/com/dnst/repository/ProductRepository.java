package com.dnst.repository;

import com.dnst.beans.Product;

/**
 * @author Finley
 */
public interface ProductRepository {
    Product getProductByBarCode(String barCode);
}
