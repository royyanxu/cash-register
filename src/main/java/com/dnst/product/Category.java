package com.dnst.product;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * @author Finley
 */
public class Category implements Serializable {
    @Expose
    private String        categoryId;
    @Expose
    private String        categoryName;
    @Expose
    private List<Product> products;



    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }



    /**
     * @param categoryId the categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }



    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }



    /**
     * @param categoryName the categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }



    /**
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
