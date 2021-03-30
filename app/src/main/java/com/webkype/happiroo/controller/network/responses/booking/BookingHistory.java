package com.webkype.happiroo.controller.network.responses.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingHistory {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("totalcost")
    @Expose
    private String totalcost;
    @SerializedName("discountcost")
    @Expose
    private String discountcost;
    @SerializedName("sellingamount")
    @Expose
    private String sellingamount;

    @SerializedName("servicename")
    @Expose
    private String servicename;
    @SerializedName("categoryname")
    @Expose
    private String categoryname;
    @SerializedName("quantity")
    @Expose
    private String quantity;

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
    @SerializedName("timeslot")
    @Expose
    private String timeslot;
    @SerializedName("vendoridid")
    @Expose
    private String vendoridid;
    @SerializedName("vendorname")
    @Expose
    private String vendorname;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("noofrating")
    @Expose
    private String noofrating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getVendoridid() {
        return vendoridid;
    }

    public void setVendoridid(String vendoridid) {
        this.vendoridid = vendoridid;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNoofrating() {
        return noofrating;
    }

    public void setNoofrating(String noofrating) {
        this.noofrating = noofrating;
    }
}