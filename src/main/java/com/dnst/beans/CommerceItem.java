package com.dnst.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Finley
 */
public class CommerceItem implements Serializable {

    private Product       product;
    private int           quantity;
    private ItemPriceInfo itemPriceInfo;



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
     * @return the itemPriceInfo
     */
    public ItemPriceInfo getItemPriceInfo() {
        return itemPriceInfo;
    }



    /**
     * @param itemPriceInfo the itemPriceInfo
     */
    public void setItemPriceInfo(ItemPriceInfo itemPriceInfo) {
        this.itemPriceInfo = itemPriceInfo;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
