package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Order;
import com.dnst.beans.OrderPriceInfo;
import com.dnst.utils.BarCodeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Finley
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CommerceItemService commerceItemService;

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);



    @Override
    public Order createOrder() {
        final Order order = new Order();
        final OrderPriceInfo orderPriceInfo = new OrderPriceInfo();
        order.setOrderPriceInfo(orderPriceInfo);
        logger.debug("Execute the create order method, the create order info is {}", order);
        return order;
    }



    @Override
    public Order createOrderByProductInfos(List<String> productInfos) {
        if (CollectionUtils.isEmpty(productInfos)) {
            logger.error("The product info cannot be empty.");
            throw new IllegalArgumentException("The product info cannot be empty.");
        }
        final Order order = createOrder();
        final Map<String, Integer> productInfoMap = new HashMap<>();
        for (String productInfo : productInfos) {
            constructProductInfoMap(productInfoMap, BarCodeUtils.getBarCode(productInfo),
                    BarCodeUtils.getQuantity(productInfo));
        }
        logger.debug("Constructed product info map value is {}", productInfoMap);
        for (Map.Entry<String, Integer> productInfo : productInfoMap.entrySet()) {
            CommerceItem commerceItem = commerceItemService
                    .createCommerceItem(productInfo.getKey(), productInfo.getValue());
            addCommerceItemToOrder(order, commerceItem);
        }
        logger.debug("The created order is {}", order);
        return order;
    }



    @Override
    public void addCommerceItemToOrder(Order order, CommerceItem commerceItem) {
        if (order == null || commerceItem == null) {
            throw new IllegalArgumentException("The arguments cannot be null.");
        }
        order.getCommerceItems().add(commerceItem);
    }



    /**
     * Construct product info map, the key is product barCode, the value is product's quantity.
     *
     * @param productInfoMap product info map holder.
     * @param barCode        bar code.
     * @param quantity       quantity.
     */
    private void constructProductInfoMap(Map<String, Integer> productInfoMap, String barCode, Integer quantity) {
        Integer originalQuantity = productInfoMap.get(barCode);
        if (originalQuantity == null) {
            productInfoMap.put(barCode, quantity);
        } else {
            productInfoMap.put(barCode, originalQuantity + quantity);
        }
    }
}
