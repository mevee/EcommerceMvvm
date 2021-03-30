package com.webkype.happiroo.controller.network.responses.prod_orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.webkype.happiroo.controller.network.responses.product_list.Product;

import java.util.List;

public class OrderListResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("bookinglist")
    @Expose
    private List<Order> bookinglist;

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

    public List<Order> getBookinglist() {
        return bookinglist;
    }

    public void setBookinglist(List<Order> bookinglist) {
        this.bookinglist = bookinglist;
    }
}