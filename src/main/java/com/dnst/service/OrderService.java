package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;

import java.util.List;

/**
 * @author Finley
 */
public interface OrderService {

    /**
     * Create the order object.
     *
     * @return order.
     */
    Order createOrder();



    /**
     * Create the order by the product information.
     * The format of the input parameter is like this,
     * ITEM00001, ITEM00001-2.
     * The input will includes list the parameter.
     *
     * @return created Order object.
     * @see Order
     */
    Order createOrderByProductInfos(List<String> productInfos);



    /**
     * Add the commerce item to the param order.
     *
     * @param order        order.
     * @param commerceItem commerce item.
     */
    void addCommerceItemToOrder(Order order, CommerceItem commerceItem);
}
