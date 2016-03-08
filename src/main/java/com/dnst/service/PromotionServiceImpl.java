package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.Promotion;
import com.dnst.beans.PromotionalType;
import com.dnst.repository.PromotionRepository;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Finley
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    private final Logger logger = LoggerFactory.getLogger(PromotionServiceImpl.class);



    @Override
    public void calculateItemPromotionalPriceInfo(CommerceItem commerceItem) {
        if (commerceItem == null) {
            logger.error("The input commerce item should not null.");
            throw new IllegalArgumentException("The input commerce item should not null.");
        }
        final String barCode = commerceItem.getProduct().getBarCode();
        List<Promotion> promotions = getPromotionRepository().getPromotionByBarCode(barCode);
        if (CollectionUtils.isEmpty(promotions)) {
            logger.debug("No promotion apply to {} not execute promotion price calculate", barCode);
            return;
        }
        List<Promotion> applicablePromotions = getApplicablePromotions(promotions);
        logger.debug("Get applicable promotions for {}", barCode);
        for (Promotion promotion : applicablePromotions) {
            applyPromotion(commerceItem, promotion);
        }
    }



    private void applyPromotion(CommerceItem commerceItem, Promotion promotion) {
        double amount = commerceItem.getItemPriceInfo().getRawTotalPrice();
        if (promotion.getPromotionalType() == PromotionalType.BUY_X_SUB_Y) {
            int[] buyXSubY = promotion.getBuyXSubY();
            int buyCount = buyXSubY[0];
            int subCount = buyXSubY[1];
            if (subCount > buyCount) {
                logger.error("The sub count is larger buy count");
                return;
            }
            if (commerceItem.getQuantity() > buyCount) {
                subCount = commerceItem.getQuantity() / buyCount;
                commerceItem.setDiscountQuantity(subCount);
                amount = commerceItem.getItemPriceInfo().getRawTotalPrice() - subCount * commerceItem.getItemPriceInfo()
                        .getListPrice();
            }
        } else if (promotion.getPromotionalType() == PromotionalType.DISCOUNT) {
            double discountRate = promotion.getDiscountRate();
            commerceItem.setDiscountQuantity(commerceItem.getQuantity());
            amount = commerceItem.getItemPriceInfo().getRawTotalPrice() * discountRate;
            commerceItem.getItemPriceInfo().setDiscounted(true);
        }
        commerceItem.getItemPriceInfo().setAmount(amount);
        commerceItem.getItemPriceInfo()
                .setDiscountAmount(commerceItem.getItemPriceInfo().getRawTotalPrice() - amount);
        commerceItem.getAppliedPromotions().add(promotion);
    }



    private List<Promotion> getApplicablePromotions(List<Promotion> promotions) {
        final List<Promotion> result = new ArrayList<>();
        final List<PromotionalType> mutexTypes = new ArrayList<>();
        for (Promotion promotion : promotions) {
            if (promotion.getMutexType() != null) {
                mutexTypes.add(promotion.getMutexType());
            }
        }
        for (Promotion promotion : promotions) {
            if (!mutexTypes.contains(promotion.getPromotionalType())) {
                result.add(promotion);
            }
        }
        return result;
    }



    /**
     * @return the promotionRepository
     */
    public PromotionRepository getPromotionRepository() {
        return promotionRepository;
    }



    /**
     * @param pPromotionRepository the promotionRepository
     */
    public void setPromotionRepository(PromotionRepository pPromotionRepository) {
        promotionRepository = pPromotionRepository;
    }
}
