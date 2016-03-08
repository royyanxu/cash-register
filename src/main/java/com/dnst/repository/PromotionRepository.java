package com.dnst.repository;

import com.dnst.beans.Promotion;

import java.util.List;

/**
 * @author Finley
 */
public interface PromotionRepository {

    List<Promotion> getPromotionByBarCode(String barCode);



    Promotion getPromotionById(String promotionId);
    
}
