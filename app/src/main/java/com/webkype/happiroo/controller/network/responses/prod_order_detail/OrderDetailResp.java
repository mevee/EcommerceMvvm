package com.webkype.happiroo.controller.network.responses.prod_order_detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetailResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("bookingdata")
@Expose
private Bookingdata bookingdata;

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

public Bookingdata getBookingdata() {
return bookingdata;
}

public void setBookingdata(Bookingdata bookingdata) {
this.bookingdata = bookingdata;
}

}