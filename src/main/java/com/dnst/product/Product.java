package com.dnst.product;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * The product info class is for hold the
 *
 * @author Finley
 */
public class Product implements Serializable {

    @Expose
    private String   name;
    @Expose
    private double   listPrice;
    @Expose
    private Category category;
    @Expose
    private String   barCode;



    /**
     * @return the name
     */
    public String getName() {
        return name;
    }



    /**
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }



    /**
     * @return the listPrice
     */
    public double getListPrice() {
        return listPrice;
    }



    /**
     * @param listPrice the listPrice
     */
    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }



    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }



    /**
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }



    /**
     * @return the barCode
     */
    public String getBarCode() {
        return barCode;
    }



    /**
     * @param barCode the barCode
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
