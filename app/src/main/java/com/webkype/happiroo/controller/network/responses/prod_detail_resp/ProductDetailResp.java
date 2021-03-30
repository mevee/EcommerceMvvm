package com.webkype.happiroo.controller.network.responses.prod_detail_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.webkype.happiroo.controller.network.responses.product_list.Product;

import java.util.List;

public class ProductDetailResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("productlist")
    @Expose
    private ProductDetail productList;

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

    public ProductDetail getProductList() {
        return productList;
    }

    public void setProductList(ProductDetail productList) {
        this.productList = productList;
    }
}