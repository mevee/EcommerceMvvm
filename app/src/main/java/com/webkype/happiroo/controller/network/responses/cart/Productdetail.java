package com.webkype.happiroo.controller.network.responses.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productdetail {

@SerializedName("productname")
@Expose
private String productname;
@SerializedName("sellingprice")
@Expose
private String sellingprice;
@SerializedName("discount_price")
@Expose
private String discountPrice;
@SerializedName("costprice")
@Expose
private String costprice;
@SerializedName("imageurl")
@Expose
private String imageurl;
@SerializedName("pid")
@Expose
private String pid;
@SerializedName("qty")
@Expose
private String qty;

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

public String getDiscountPrice() {
return discountPrice;
}

public void setDiscountPrice(String discountPrice) {
this.discountPrice = discountPrice;
}

public String getCostprice() {
return costprice;
}

public void setCostprice(String costprice) {
this.costprice = costprice;
}

public String getImageurl() {
return imageurl;
}

public void setImageurl(String imageurl) {
this.imageurl = imageurl;
}

public String getPid() {
return pid;
}

public void setPid(String pid) {
this.pid = pid;
}

public String getQty() {
return qty;
}

public void setQty(String qty) {
this.qty = qty;
}

}