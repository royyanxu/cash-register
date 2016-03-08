package com.dnst.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
public class CommerceItem implements Serializable {

    private Product       product;
    private int           quantity;
    private int           discountQuantity;
    private ItemPriceInfo itemPriceInfo;
    private List<Promotion> appliedPromotions = new ArrayList<>();



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
     * @return the discountQuantity
     */
    public int getDiscountQuantity() {
        return discountQuantity;
    }



    /**
     * @param pDiscountQuantity the discountQuantity
     */
    public void setDiscountQuantity(int pDiscountQuantity) {
        discountQuantity = pDiscountQuantity;
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



    /**
     * @return the appliedPromotions
     */
    public List<Promotion> getAppliedPromotions() {
        return appliedPromotions;
    }



    /**
     * @param pAppliedPromotions the appliedPromotions
     */
    public void setAppliedPromotions(List<Promotion> pAppliedPromotions) {
        appliedPromotions = pAppliedPromotions;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
