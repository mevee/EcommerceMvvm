package com.webkype.happiroo.controller.network.responses.prod_order_detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Servicedetum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("productid")
@Expose
private String productid;
@SerializedName("productname")
@Expose
private String productname;
@SerializedName("quantity")
@Expose
private String quantity;
@SerializedName("productimage")
@Expose
private String productimage;
@SerializedName("sellingprice")
@Expose
private String sellingprice;
@SerializedName("discount_price")
@Expose
private String discountPrice;
@SerializedName("costprice")
@Expose
private String costprice;
@SerializedName("subtotal")
@Expose
private String subtotal;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getProductid() {
return productid;
}

public void setProductid(String productid) {
this.productid = productid;
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

public String getProductimage() {
return productimage;
}

public void setProductimage(String productimage) {
this.productimage = productimage;
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

public String getSubtotal() {
return subtotal;
}

public void setSubtotal(String subtotal) {
this.subtotal = subtotal;
}

}