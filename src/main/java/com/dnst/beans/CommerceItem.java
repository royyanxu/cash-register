package com.dnst.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Finley
 */
public class CommerceItem implements Serializable {

    private Product product;
    private int     quantity;
    private double  rawTotalPrice;
    private double  totalPrice;



    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }



    /**
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }



    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }



    /**
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    /**
     * @return the rawTotalPrice
     */
    public double getRawTotalPrice() {
        return rawTotalPrice;
    }



    /**
     * @param rawTotalPrice the rawTotalPrice
     */
    public void setRawTotalPrice(double rawTotalPrice) {
        this.rawTotalPrice = rawTotalPrice;
    }



    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }



    /**
     * @param totalPrice the totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public double getDiscountAmount() {
        double discount = getRawTotalPrice() - getTotalPrice();
        return discount < 0d ? 0d : discount;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
