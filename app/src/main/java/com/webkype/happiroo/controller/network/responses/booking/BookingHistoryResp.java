package com.webkype.happiroo.controller.network.responses.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookingHistoryResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("bookinglist")
@Expose
private List<BookingHistory> bookinglist = null;

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

public List<BookingHistory> getBookinglist() {
return bookinglist;
}

public void setBookinglist(List<BookingHistory> bookinglist) {
this.bookinglist = bookinglist;
}

}
