package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.ItemPriceInfo;
import com.dnst.beans.Order;
import com.dnst.beans.OrderPriceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Finley
 */
@Service
public class PricingServiceImpl implements PricingService {

    private final Logger logger = LoggerFactory.getLogger(PricingServiceImpl.class);



    @Override
    public void calculateItemPriceInfo(CommerceItem commerceItem) {
        if (commerceItem == null) {
            logger.error("The input commerceItem should not null.");
            throw new IllegalArgumentException("The input commerceItem should not null.");
        }
        final ItemPriceInfo itemPriceInfo = new ItemPriceInfo();
        commerceItem.setItemPriceInfo(itemPriceInfo);
        itemPriceInfo.setListPrice(commerceItem.getProduct().getListPrice());
        final double rawTotalPrice = commerceItem.getQuantity() * itemPriceInfo.getListPrice();
        final double amount = rawTotalPrice;
        final double discountAmount = rawTotalPrice - amount;
        if (discountAmount > 0) {
            itemPriceInfo.setDiscounted(true);
        }
        itemPriceInfo.setRawTotalPrice(rawTotalPrice);
        itemPriceInfo.setAmount(amount);
        itemPriceInfo.setDiscountAmount(discountAmount);
        logger.debug("Calculate the item price info {} for product {}", itemPriceInfo, commerceItem.getProduct());
    }



    @Override
    public void calculateOrderPriceInfo(Order order) {
        if (order == null) {
            logger.error("The input parameter order should not null.");
            throw new IllegalArgumentException("The input parameter order should not null.");
        }
        final OrderPriceInfo orderPriceInfo = new OrderPriceInfo();
        for (CommerceItem commerceItem : order.getCommerceItems()) {
            if (commerceItem.getItemPriceInfo() == null) {
                calculateItemPriceInfo(commerceItem);
            }
        }
        double rawSubTotal = 0d;
        double amount = 0d;
        for (CommerceItem commerceItem : order.getCommerceItems()) {
            rawSubTotal += commerceItem.getItemPriceInfo().getRawTotalPrice();
            amount += commerceItem.getItemPriceInfo().getAmount();
        }
        double discountAmount = orderPriceInfo.getRawSubTotalPrice() - orderPriceInfo.getAmount();
        if (discountAmount > 0) {
            orderPriceInfo.setDiscounted(true);
        }
        orderPriceInfo.setRawSubTotalPrice(rawSubTotal);
        orderPriceInfo.setAmount(amount);
        orderPriceInfo.setDiscountAmount(discountAmount);
        order.setOrderPriceInfo(orderPriceInfo);
        logger.debug("Calculate the order price info {}", orderPriceInfo);
    }
}
