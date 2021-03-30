package com.webkype.happiroo.controller.network.responses.prod_orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("categoryname")
    @Expose
    private String categoryname;

    @SerializedName("productname")
    @Expose
    private String productname;
    @SerializedName("quantity")
    @Expose
    private String quantity;
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

    @SerializedName("bookingstatus")
    @Expose
    private String bookingstatus;

    @SerializedName("servicedate")
    @Expose
    private String servicedate;

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("city")
    @Expose
    private String city;

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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public String getBookingstatus() {
        return bookingstatus;
    }

    public void setBookingstatus(String bookingstatus) {
        this.bookingstatus = bookingstatus;
    }

    public String getServicedate() {
        return servicedate;
    }

    public void setServicedate(String servicedate) {
        this.servicedate = servicedate;
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
}