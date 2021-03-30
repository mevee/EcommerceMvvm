package com.webkype.happiroo.controller.network.responses.wallet_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WalletResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("totalbal")
    @Expose
    private String totalbal;

    @SerializedName("wallet")
    @Expose
    private List<Transaction> productList;

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

    public List<Transaction> getProductList() {
        return productList;
    }

    public void setProductList(List<Transaction> productList) {
        this.productList = productList;
    }

    public String getTotalbal() {
        return totalbal;
    }

    public void setTotalbal(String totalbal) {
        this.totalbal = totalbal;
    }
}