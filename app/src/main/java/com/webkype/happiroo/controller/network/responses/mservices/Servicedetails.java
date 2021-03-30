package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Servicedetails {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("servicename")
    @Expose
    private String servicename;
    @SerializedName("servicetype")
    @Expose
    private String servicetype;
    @SerializedName("colortrayauusrance")
    @Expose
    private String colortrayauusrance;
    @SerializedName("longdescription")
    @Expose
    private String longdescription;
    @SerializedName("equipmentused")
    @Expose
    private String equipmentused;
    @SerializedName("serviceduration")
    @Expose
    private String serviceduration;
    @SerializedName("additionaldetails")
    @Expose
    private String additionaldetails;

    @SerializedName("inclusion")
    @Expose
    private String inclusion;
    @SerializedName("exculusion")
    @Expose
    private String exculusion;
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

    @SerializedName("isfavorite")
    @Expose
    private String isfavorite;
  @SerializedName("cartQnt")
    @Expose
    private String cartQnt;

    @SerializedName("productused")
    @Expose
    private List<ProductUsed> productused = null;


    @SerializedName("reviews")
    @Expose
    private List<ReviewItem> reviews = null;

    public String getServiceduration() {
        return serviceduration;
    }

    public void setServiceduration(String serviceduration) {
        this.serviceduration = serviceduration;
    }

    @SerializedName("servicepics")
    @Expose
    private List<Servicepic> servicepics = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentused() {
        return equipmentused;
    }

    public void setEquipmentused(String equipmentused) {
        this.equipmentused = equipmentused;
    }

    public String getAdditionaldetails() {
        return additionaldetails;
    }

    public void setAdditionaldetails(String additionaldetails) {
        this.additionaldetails = additionaldetails;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getColortrayauusrance() {
        return colortrayauusrance;
    }

    public void setColortrayauusrance(String colortrayauusrance) {
        this.colortrayauusrance = colortrayauusrance;
    }

    public String getLongdescription() {
        return longdescription;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public String getInclusion() {
        return inclusion;
    }

    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
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

    public List<Servicepic> getServicepics() {
        return servicepics;
    }

    public void setServicepics(List<Servicepic> servicepics) {
        this.servicepics = servicepics;
    }

    public String getExculusion() {
        return exculusion;
    }

    public void setExculusion(String exculusion) {
        this.exculusion = exculusion;
    }

    public String getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(String isfavorite) {
        this.isfavorite = isfavorite;
    }

    public List<ReviewItem> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewItem> reviews) {
        this.reviews = reviews;
    }


    public String getCartQnt() {
        return cartQnt;
    }

    public void setCartQnt(String cartQnt) {
        this.cartQnt = cartQnt;
    }

    public List<ProductUsed> getProductused() {
        return productused;
    }

    public void setProductused(List<ProductUsed> productused) {
        this.productused = productused;
    }
}