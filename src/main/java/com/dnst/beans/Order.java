package com.dnst.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
public class Order implements Serializable {

    private List<CommerceItem> commerceItems = new ArrayList<>();
    private double rawSubTotalPrice;
    private double totalPrice;



    /**
     * @return the commerceItems
     */
    public List<CommerceItem> getCommerceItems() {
        return commerceItems;
    }



    /**
     * @param commerceItems the commerceItems
     */
    public void setCommerceItems(List<CommerceItem> commerceItems) {
        this.commerceItems = commerceItems;
    }



    /**
     * @return the rawSubTotalPrice
     */
    public double getRawSubTotalPrice() {
        return rawSubTotalPrice;
    }



    /**
     * @param rawSubTotalPrice the rawSubTotalPrice
     */
    public void setRawSubTotalPrice(double rawSubTotalPrice) {
        this.rawSubTotalPrice = rawSubTotalPrice;
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
        double discount = getRawSubTotalPrice() - getTotalPrice();
        return discount < 0d ? 0d : discount;
    }
}
