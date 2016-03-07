package com.dnst.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
public class Order implements Serializable {

    private List<CommerceItem> commerceItems = new ArrayList<>();
    private OrderPriceInfo orderPriceInfo;



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
     * @return the orderPriceInfo
     */
    public OrderPriceInfo getOrderPriceInfo() {
        return orderPriceInfo;
    }



    /**
     * @param orderPriceInfo the orderPriceInfo
     */
    public void setOrderPriceInfo(OrderPriceInfo orderPriceInfo) {
        this.orderPriceInfo = orderPriceInfo;
    }
}
