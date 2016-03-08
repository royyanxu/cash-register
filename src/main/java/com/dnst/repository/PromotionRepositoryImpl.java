package com.dnst.repository;

import com.dnst.beans.Promotion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Finley
 */
@Repository
public class PromotionRepositoryImpl implements PromotionRepository {

    private List<Promotion>              promotions          = new ArrayList<>();
    private Map<String, List<Promotion>> barCodePromotionMap = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(PromotionRepositoryImpl.class);

    private static final String PROMOTION_MOCK_FILE_PATH = "classpath:mockPromotion.json";



    @PostConstruct
    private void loadPromotionItems() {
        final Gson gson = new Gson();
        promotions = gson.fromJson(getPromotionMockData(), new TypeToken<List<Promotion>>() {
        }.getType());
        if (CollectionUtils.isNotEmpty(promotions)) {
            for (Promotion promotion : promotions) {
                for (String barCode : promotion.getApplyTo()) {
                    List<Promotion> promotionLi = barCodePromotionMap.get(barCode);
                    if (promotionLi == null) {
                        promotionLi = new ArrayList<>();
                        barCodePromotionMap.put(barCode, promotionLi);
                    }
                    promotionLi.add(promotion);
                }
            }
        }
        logger.debug("The initial promotions is {}", barCodePromotionMap);
    }



    private String getPromotionMockData() {
        String result = "";
        final ResourceLoader resourceLoader = new DefaultResourceLoader();
        final Resource mockPromotionResource = resourceLoader.getResource(PROMOTION_MOCK_FILE_PATH);
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(mockPromotionResource.getInputStream
                    ()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            logger.error("When execute get promotion data error occur.", e);
        }
        logger.debug("The promotion mock data result is {}", result);
        return result;
    }



    @Override
    public List<Promotion> getPromotionByBarCode(String barCode) {
        final List<Promotion> promotionLi = barCodePromotionMap.get(barCode);
        if (CollectionUtils.isEmpty(promotionLi)) {
            return Collections.emptyList();
        }
        logger.debug("Get promotions {} by bar code {}", promotionLi, barCode);
        return promotionLi;
    }



    @Override
    public Promotion getPromotionById(String promotionId) {
        if (StringUtils.isBlank(promotionId)) {
            logger.error("The input parameter promotionId cannot be empty.");
            return null;
        }
        for (Promotion promotion : promotions) {
            if (promotionId.equals(promotion.getPromotionId())) {
                return promotion;
            }
        }
        return null;
    }
}
