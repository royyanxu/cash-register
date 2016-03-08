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
    @Autowired
    private PricingService      pricingService;

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);



    @Override
    public Order createOrder() {
        final Order order = new Order();
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
            CommerceItem commerceItem = getCommerceItemService()
                    .createCommerceItem(productInfo.getKey(), productInfo.getValue());
            addCommerceItemToOrder(order, commerceItem);
        }
        getPricingService().calculateOrderPriceInfo(order);
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



    /**
     * @return the commerceItemService
     */
    public CommerceItemService getCommerceItemService() {
        return commerceItemService;
    }



    /**
     * @param pCommerceItemService the commerceItemService
     */
    public void setCommerceItemService(CommerceItemService pCommerceItemService) {
        commerceItemService = pCommerceItemService;
    }



    /**
     * @return the pricingService
     */
    public PricingService getPricingService() {
        return pricingService;
    }



    /**
     * @param pPricingService the pricingService
     */
    public void setPricingService(PricingService pPricingService) {
        pricingService = pPricingService;
    }
}
