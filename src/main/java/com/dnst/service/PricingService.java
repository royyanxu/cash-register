package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;

/**
 * @author Finley
 */
public interface PricingService {
    /**
     * Calculate the item price info for the commerce item.
     *
     * @param commerceItem commerce item object.
     */
    void calculateItemPriceInfo(CommerceItem commerceItem);



    /**
     * Calculate the order price info for the order.
     *
     * @param order order object.
     */
    void calculateOrderPriceInfo(Order order);
}
