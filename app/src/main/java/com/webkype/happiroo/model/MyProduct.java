package com.webkype.happiroo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyProduct {

@SerializedName("productname")
@Expose
private String productname;
@SerializedName("sellingprice")
@Expose
private String sellingprice;
@SerializedName("size")
@Expose
private String size;
@SerializedName("imageurl")
@Expose
private String imageurl;
@SerializedName("rating")
@Expose
private float rating;
@SerializedName("stockstatus")
@Expose
private String stockstatus;
@SerializedName("shortdesc")
@Expose
private String shortdesc;
@SerializedName("pid")
@Expose
private String pid;
@SerializedName("costprice")
@Expose
private String costprice;
@SerializedName("color")
@Expose
private String color;
@SerializedName("sellername")
@Expose
private String sellername;
@SerializedName("discount")
@Expose
private String discount;
@SerializedName("cartqty")
@Expose
private String cartqty;
@SerializedName("favoritecheck")
@Expose
private String favoritecheck;

    public MyProduct() {
    }

    public MyProduct(String productname, String sellingprice, String size, String imageurl, float rating, String stockstatus, String shortdesc, String pid, String costprice, String color, String sellername, String discount, String cartqty, String favoritecheck) {
        this.productname = productname;
        this.sellingprice = sellingprice;
        this.size = size;
        this.imageurl = imageurl;
        this.rating = rating;
        this.stockstatus = stockstatus;
        this.shortdesc = shortdesc;
        this.pid = pid;
        this.costprice = costprice;
        this.color = color;
        this.sellername = sellername;
        this.discount = discount;
        this.cartqty = cartqty;
        this.favoritecheck = favoritecheck;
    }

    public String getProductname() {
return productname;
}

public void setProductname(String productname) {
this.productname = productname;
}

public String getSellingprice() {
return sellingprice;
}

public void setSellingprice(String sellingprice) {
this.sellingprice = sellingprice;
}

public String getSize() {
return size;
}

public void setSize(String size) {
this.size = size;
}

public String getImageurl() {
return imageurl;
}

public void setImageurl(String imageurl) {
this.imageurl = imageurl;
}

public float getRating() {
return rating;
}

public void setRating(float rating) {
this.rating = rating;
}

public String getStockstatus() {
return stockstatus;
}

public void setStockstatus(String stockstatus) {
this.stockstatus = stockstatus;
}

public String getShortdesc() {
return shortdesc;
}

public void setShortdesc(String shortdesc) {
this.shortdesc = shortdesc;
}

public String getPid() {
return pid;
}

public void setPid(String pid) {
this.pid = pid;
}

public String getCostprice() {
return costprice;
}

public void setCostprice(String costprice) {
this.costprice = costprice;
}

public String getColor() {
return color;
}

public void setColor(String color) {
this.color = color;
}

public String getSellername() {
return sellername;
}

public void setSellername(String sellername) {
this.sellername = sellername;
}

public String getDiscount() {
return discount;
}

public void setDiscount(String discount) {
this.discount = discount;
}

public String getCartqty() {
return cartqty;
}

public void setCartqty(String cartqty) {
this.cartqty = cartqty;
}

public String getFavoritecheck() {
return favoritecheck;
}

public void setFavoritecheck(String favoritecheck) {
this.favoritecheck = favoritecheck;
}

}