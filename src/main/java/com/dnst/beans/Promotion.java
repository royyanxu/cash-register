package com.dnst.beans;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
public class Promotion implements Serializable {

    @Expose
    private String          promotionId;
    @Expose
    private PromotionalType promotionalType;
    @Expose
    private int[]           buyXSubY;
    @Expose
    private PromotionalType mutexType;
    @Expose
    private double          discountRate;
    @Expose
    private List<String> applyTo = new ArrayList<>();



    /**
     * @return the promotionId
     */
    public String getPromotionId() {
        return promotionId;
    }



    /**
     * @param pPromotionId the promotionId
     */
    public void setPromotionId(String pPromotionId) {
        promotionId = pPromotionId;
    }



    /**
     * @return the promotionalType
     */
    public PromotionalType getPromotionalType() {
        return promotionalType;
    }



    /**
     * @param pPromotionalType the promotionalType
     */
    public void setPromotionalType(PromotionalType pPromotionalType) {
        promotionalType = pPromotionalType;
    }



    /**
     * @return the mutexType
     */
    public PromotionalType getMutexType() {
        return mutexType;
    }



    /**
     * @param pMutexType the mutexType
     */
    public void setMutexType(PromotionalType pMutexType) {
        mutexType = pMutexType;
    }



    /**
     * @return the buyXSubY
     */
    public int[] getBuyXSubY() {
        return buyXSubY;
    }



    /**
     * @param pBuyXSubY the buyXSubY
     */
    public void setBuyXSubY(int[] pBuyXSubY) {
        buyXSubY = pBuyXSubY;
    }



    /**
     * @return the discountRate
     */
    public double getDiscountRate() {
        return discountRate;
    }



    /**
     * @param pDiscountRate the discountRate
     */
    public void setDiscountRate(double pDiscountRate) {
        discountRate = pDiscountRate;
    }



    /**
     * @return the applyTo
     */
    public List<String> getApplyTo() {
        return applyTo;
    }



    /**
     * @param pApplyTo the applyTo
     */
    public void setApplyTo(List<String> pApplyTo) {
        applyTo = pApplyTo;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
