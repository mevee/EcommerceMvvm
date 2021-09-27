package com.webkype.happiroo.controller.network.responses.book_serive_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.webkype.happiroo.controller.network.responses.booking.Bookinglist;

import java.util.List;

public class BookServiceResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("booking_id")
    @Expose
    private String booking_id;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("orderamount")
    @Expose
    private String orderamount;

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

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount;
    }
}
