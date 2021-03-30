package com.webkype.happiroo.controller.network.responses.cart;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDetailResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("bid")
@Expose
private String bid;
@SerializedName("userwallet")
@Expose
private String userwallet;
@SerializedName("totalqty")
@Expose
private int totalqty;
@SerializedName("finalamount")
@Expose
private int finalamount;
@SerializedName("usewalletamount")
@Expose
private String usewalletamount;
@SerializedName("totalcost")
@Expose
private double totalcost;
@SerializedName("discountvalue")
@Expose
private double discountvalue;
@SerializedName("productdetails")
@Expose
private List<Productdetail> productdetails = null;

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

public String getUserwallet() {
return userwallet;
}

public void setUserwallet(String userwallet) {
this.userwallet = userwallet;
}

public int getTotalqty() {
return totalqty;
}

public void setTotalqty(int totalqty) {
this.totalqty = totalqty;
}

public int getFinalamount() {
return finalamount;
}

public void setFinalamount(int finalamount) {
this.finalamount = finalamount;
}

public double getTotalcost() {
return totalcost;
}

public void setTotalcost(double totalcost) {
this.totalcost = totalcost;
}

public double getDiscountvalue() {
return discountvalue;
}

public void setDiscountvalue(double discountvalue) {
this.discountvalue = discountvalue;
}

public List<Productdetail> getProductdetails() {
return productdetails;
}

public void setProductdetails(List<Productdetail> productdetails) {
this.productdetails = productdetails;
}

    public String getUsewalletamount() {
        return usewalletamount;
    }

    public void setUsewalletamount(String usewalletamount) {
        this.usewalletamount = usewalletamount;
    }
}