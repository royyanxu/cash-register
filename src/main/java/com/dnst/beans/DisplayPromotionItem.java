package com.dnst.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Finely
 */
public class DisplayPromotionItem implements Serializable {

    private CommerceItem commerceItem;
    private Promotion    promotion;



    /**
     * @return the commerceItem
     */
    public CommerceItem getCommerceItem() {
        return commerceItem;
    }



    /**
     * @param pCommerceItem the commerceItem
     */
    public void setCommerceItem(CommerceItem pCommerceItem) {
        commerceItem = pCommerceItem;
    }



    /**
     * @return the promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }



    /**
     * @param pPromotion the promotion
     */
    public void setPromotion(Promotion pPromotion) {
        promotion = pPromotion;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
