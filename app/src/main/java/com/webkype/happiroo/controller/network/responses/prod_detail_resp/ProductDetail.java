package com.webkype.happiroo.controller.network.responses.prod_detail_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("productname")
    @Expose
    private String productname;

    @SerializedName("shortdescription")
    @Expose
    private String shortdescription;
    @SerializedName("longdescription")
    @Expose
    private String longdescription;
    @SerializedName("mrp")
    @Expose
    private String mrp;

    @SerializedName("cartQnt")
    @Expose
    private String cartQnt;
    @SerializedName("in_stock_qty")
    @Expose
    private String in_stock_qty;
    @SerializedName("productpic")
    @Expose
    private List<ProdImage> productpic;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("isfav")
    @Expose
    private String isfav;
    @SerializedName("discount_percent")
    @Expose
    private String discount_percent;

    @SerializedName("discount_value")
    @Expose
    private String discount_value;

    @SerializedName("sellingprice")
    @Expose
    private String sellingprice;

    @SerializedName("iscart")
    @Expose
    private String iscart;
    @SerializedName("israte")
    @Expose
    private String israte;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getIn_stock_qty() {
        return in_stock_qty;
    }

    public void setIn_stock_qty(String in_stock_qty) {
        this.in_stock_qty = in_stock_qty;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIsfav() {
        return isfav;
    }

    public void setIsfav(String isfav) {
        this.isfav = isfav;
    }

    public String getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(String discount_percent) {
        this.discount_percent = discount_percent;
    }

    public String getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(String discount_value) {
        this.discount_value = discount_value;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getLongdescription() {
        return longdescription;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public List<ProdImage> getProductpic() {
        return productpic;
    }

    public void setProductpic(List<ProdImage> productpic) {
        this.productpic = productpic;
    }

    public String getIscart() {
        return iscart;
    }

    public void setIscart(String iscart) {
        this.iscart = iscart;
    }

    public String getIsrate() {
        return israte;
    }

    public void setIsrate(String israte) {
        this.israte = israte;
    }

    public String getCartQnt() {
        return cartQnt;
    }

    public void setCartQnt(String cartQnt) {
        this.cartQnt = cartQnt;
    }
}