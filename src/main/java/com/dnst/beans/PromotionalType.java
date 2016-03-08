package com.dnst.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public enum PromotionalType {
    @Expose
    @SerializedName("buyXSubY")
    BUY_X_SUB_Y,
    @Expose
    @SerializedName("discount")
    DISCOUNT
}
