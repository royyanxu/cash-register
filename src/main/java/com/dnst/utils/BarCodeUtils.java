package com.dnst.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Finley
 */
public class BarCodeUtils {

    public static String getBarCode(String inputBarCode) {
        if (!StringUtils.contains(inputBarCode, "-")) {
            return inputBarCode;
        }
        final String[] splitBarCode = inputBarCode.split("-");
        return splitBarCode[0];
    }



    public static int getQuantity(String inputBarCode) {
        if (!StringUtils.contains(inputBarCode, "-")) {
            return 1;
        }
        final String[] splitBarCode = inputBarCode.split("-");
        return Integer.valueOf(splitBarCode[1]);
    }

}
