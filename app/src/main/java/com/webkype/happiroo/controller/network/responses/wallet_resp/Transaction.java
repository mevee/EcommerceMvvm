package com.webkype.happiroo.controller.network.responses.wallet_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("orderid")
    @Expose
    private String orderid;

    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("credit")
    @Expose
    private String credit;
    @SerializedName("debit")
    @Expose
    private String debit;
    @SerializedName("adddate")
    @Expose
    private String adddate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }
}