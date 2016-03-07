package com.dnst.service;

import com.dnst.beans.CommerceItem;

/**
 * @author Finley
 */
public interface CommerceItemService {

    CommerceItem createCommerceItem(String barCode, int quantity);

}
