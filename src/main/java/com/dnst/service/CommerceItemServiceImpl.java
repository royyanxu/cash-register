package com.dnst.service;

import com.dnst.beans.CommerceItem;
import com.dnst.beans.ItemPriceInfo;
import com.dnst.beans.Product;
import com.dnst.repository.ProductRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Finley
 */
@Service
public class CommerceItemServiceImpl implements CommerceItemService {

    @Autowired
    private ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(CommerceItemServiceImpl.class);



    @Override
    public CommerceItem createCommerceItem(String barCode, int quantity) {
        if (StringUtils.isBlank(barCode) || quantity < 1) {
            logger.error("The arguments barCode is {} ,quantity is {} is illegal when create commerce item.", barCode,
                    quantity);
            throw new IllegalArgumentException("The arguments is illegal when create commerce item.");
        }
        final Product product = productRepository.getProductByBarCode(barCode);
        if (product == null) {
            logger.error("cannot find product by bar code {}", barCode);
            throw new IllegalArgumentException("Cannot find product by barCode");
        }
        final CommerceItem commerceItem = new CommerceItem();
        final ItemPriceInfo itemPriceInfo = new ItemPriceInfo();
        commerceItem.setQuantity(quantity);
        commerceItem.setProduct(product);
        itemPriceInfo.setListPrice(product.getListPrice());
        commerceItem.setItemPriceInfo(itemPriceInfo);
        return commerceItem;
    }



    /**
     * @return the productRepository
     */
    public ProductRepository getProductRepository() {
        return productRepository;
    }



    /**
     * @param pProductRepository the productRepository
     */
    public void setProductRepository(ProductRepository pProductRepository) {
        productRepository = pProductRepository;
    }
}
