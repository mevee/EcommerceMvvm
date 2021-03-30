package com.webkype.happiroo.controller.network.responses.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddToCartResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

   @SerializedName("bid")
    @Expose
    private String bid;

   @SerializedName("totalcartqty")
    @Expose
    private String totalcartqty;

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

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTotalcartqty() {
        return totalcartqty;
    }

    public void setTotalcartqty(String totalcartqty) {
        this.totalcartqty = totalcartqty;
    }
}
