package com.dnst.beans;

/**
 * @author Finley
 */
public class OrderPriceInfo extends PriceInfo {
    /**
     * The rawSubTotalPrice represent the order's total price not apply the discount.
     */
    private double rawSubTotalPrice;



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

}
