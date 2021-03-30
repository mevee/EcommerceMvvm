package com.webkype.happiroo.controller.network.responses.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartQuantityResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("totalrecords")
    @Expose
    private String totalrecords;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(String totalrecords) {
        this.totalrecords = totalrecords;
    }
}
