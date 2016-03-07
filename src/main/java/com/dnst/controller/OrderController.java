package com.dnst.controller;

import com.dnst.beans.Order;
import com.dnst.service.OrderService;
import com.dnst.utils.OrderPrinter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Finley
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);



    public void generateAndPrintOrder(String productDetails) {
        if (StringUtils.isBlank(productDetails)) {
            logger.error("The input product details should not empty.");
            throw new IllegalArgumentException("The input product details should not empty.");
        }
        final Gson gson = new Gson();
        final List<String> productDetailLi = gson.fromJson(productDetails, new TypeToken<List<String>>() {
        }.getType());
        final Order order = getOrderService().createOrderByProductInfos(productDetailLi);
        OrderPrinter.printOrder(order);
    }



    /**
     * @return the orderService
     */
    public OrderService getOrderService() {
        return orderService;
    }



    /**
     * @param orderService the orderService
     */
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
