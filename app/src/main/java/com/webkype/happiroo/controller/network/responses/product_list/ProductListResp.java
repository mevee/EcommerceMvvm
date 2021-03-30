package com.webkype.happiroo.controller.network.responses.product_list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdCategory;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdSubCategory;

import java.util.List;

public class ProductListResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("productlist")
    @Expose
    private List<Product> productList;

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}