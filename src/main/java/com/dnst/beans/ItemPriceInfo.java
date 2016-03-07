package com.dnst.beans;

/**
 * @author Finley
 */
public class ItemPriceInfo extends PriceInfo {
    /**
     * The listPrice represent the product's original price.
     */
    private double listPrice;
    /**
     * The rawTotalPrice represent the item's listPrice * quantity.
     */
    private double rawTotalPrice;



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
}
