package com.webkype.happiroo.controller.network.responses.booking;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingsResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("bookinglist")
@Expose
private List<Bookinglist> bookinglist = null;

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

public List<Bookinglist> getBookinglist() {
return bookinglist;
}

public void setBookinglist(List<Bookinglist> bookinglist) {
this.bookinglist = bookinglist;
}

}
