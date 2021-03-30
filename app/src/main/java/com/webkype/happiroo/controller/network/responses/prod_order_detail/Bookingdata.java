package com.webkype.happiroo.controller.network.responses.prod_order_detail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookingdata {

@SerializedName("id")
@Expose
private String id;
@SerializedName("categoryname")
@Expose
private String categoryname;
@SerializedName("bookingstatus")
@Expose
private String bookingstatus;
@SerializedName("otp")
@Expose
private String otp;
@SerializedName("totalcost")
@Expose
private String totalcost;
@SerializedName("discountcost")
@Expose
private String discountcost;
@SerializedName("sellingamount")
@Expose
private String sellingamount;
@SerializedName("walletused")
@Expose
private String walletused;
@SerializedName("remainingamnt")
@Expose
private String remainingamnt;
@SerializedName("paymentmode")
@Expose
private String paymentmode;
@SerializedName("servicedate")
@Expose
private String servicedate;
@SerializedName("timeslot")
@Expose
private String timeslot;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("mobileno")
@Expose
private String mobileno;
@SerializedName("locationtype")
@Expose
private String locationtype;
@SerializedName("location")
@Expose
private String location;
@SerializedName("address")
@Expose
private String address;
@SerializedName("country")
@Expose
private String country;
@SerializedName("state")
@Expose
private String state;
@SerializedName("city")
@Expose
private String city;

@SerializedName("productdeta")
@Expose
private List<Servicedetum> servicedeta = null;

@SerializedName("vendordeta")
@Expose
private Vendordeta vendordeta;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getCategoryname() {
return categoryname;
}

public void setCategoryname(String categoryname) {
this.categoryname = categoryname;
}

public String getBookingstatus() {
return bookingstatus;
}

public void setBookingstatus(String bookingstatus) {
this.bookingstatus = bookingstatus;
}

public String getOtp() {
return otp;
}

public void setOtp(String otp) {
this.otp = otp;
}

public String getTotalcost() {
return totalcost;
}

public void setTotalcost(String totalcost) {
this.totalcost = totalcost;
}

public String getDiscountcost() {
return discountcost;
}

public void setDiscountcost(String discountcost) {
this.discountcost = discountcost;
}

public String getSellingamount() {
return sellingamount;
}

public void setSellingamount(String sellingamount) {
this.sellingamount = sellingamount;
}

public String getWalletused() {
return walletused;
}

public void setWalletused(String walletused) {
this.walletused = walletused;
}

public String getRemainingamnt() {
return remainingamnt;
}

public void setRemainingamnt(String remainingamnt) {
this.remainingamnt = remainingamnt;
}

public String getPaymentmode() {
return paymentmode;
}

public void setPaymentmode(String paymentmode) {
this.paymentmode = paymentmode;
}

public String getServicedate() {
return servicedate;
}

public void setServicedate(String servicedate) {
this.servicedate = servicedate;
}

public String getTimeslot() {
return timeslot;
}

public void setTimeslot(String timeslot) {
this.timeslot = timeslot;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

public String getMobileno() {
return mobileno;
}

public void setMobileno(String mobileno) {
this.mobileno = mobileno;
}

public String getLocationtype() {
return locationtype;
}

public void setLocationtype(String locationtype) {
this.locationtype = locationtype;
}

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public List<Servicedetum> getServicedeta() {
return servicedeta;
}

public void setServicedeta(List<Servicedetum> servicedeta) {
this.servicedeta = servicedeta;
}

public Vendordeta getVendordeta() {
return vendordeta;
}

public void setVendordeta(Vendordeta vendordeta) {
this.vendordeta = vendordeta;
}

}