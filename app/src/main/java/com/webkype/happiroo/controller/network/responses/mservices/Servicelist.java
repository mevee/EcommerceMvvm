package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Servicelist {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("servicename")
    @Expose
    private String servicename;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("costprice")
    @Expose
    private String costprice;
    @SerializedName("discount_percent")
    @Expose
    private String discountPercent;
    @SerializedName("discount_value")
    @Expose
    private String discountValue;
    @SerializedName("sellingprice")
    @Expose
    private String sellingprice;
    @SerializedName("servicepic")
    @Expose
    private String servicepic;

    @SerializedName("serviceduration")
    @Expose
    private String serviceduration;

    @SerializedName("description")
    @Expose
    private String description;
 @SerializedName("cartQnt")
    @Expose
    private String cartQnt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCostprice() {
        return costprice;
    }

    public void setCostprice(String costprice) {
        this.costprice = costprice;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getServicepic() {
        return servicepic;
    }

    public void setServicepic(String servicepic) {
        this.servicepic = servicepic;
    }

    public String getServiceduration() {
        return serviceduration;
    }

    public void setServiceduration(String serviceduration) {
        this.serviceduration = serviceduration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCartQnt() {
        return cartQnt;
    }

    public void setCartQnt(String cartQnt) {
        this.cartQnt = cartQnt;
    }
}