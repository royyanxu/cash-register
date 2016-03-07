package com.dnst.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Finley
 */
public class PriceInfo implements Serializable {
    /**
     * The amount is represent the total price include the discount.
     */
    private double  amount;
    /**
     * The discountAmount is represent the discount amount.
     */
    private double  discountAmount;
    /**
     * The discounted indicated the price is discount.
     */
    private boolean discounted;



    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }



    /**
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }



    /**
     * @return the discountAmount
     */
    public double getDiscountAmount() {
        return discountAmount;
    }



    /**
     * @param discountAmount the discountAmount
     */
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }



    /**
     * @return the discounted
     */
    public boolean isDiscounted() {
        return discounted;
    }



    /**
     * @param discounted the discounted
     */
    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
