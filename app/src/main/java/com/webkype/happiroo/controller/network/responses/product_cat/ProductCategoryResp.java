package com.webkype.happiroo.controller.network.responses.product_cat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductCategoryResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("productcatdeta")
    @Expose
    private List<ProdCategory> catList;

    @SerializedName("productsubcatdeta")
    @Expose
    private List<ProdSubCategory> productsubcatdeta;

    public List<ProdSubCategory> getProductsubcatdeta() {
        return productsubcatdeta;
    }

    public void setProductsubcatdeta(List<ProdSubCategory> productsubcatdeta) {
        this.productsubcatdeta = productsubcatdeta;
    }

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

    public List<ProdCategory> getCatList() {
        return catList;
    }

    public void setCatList(List<ProdCategory> catList) {
        this.catList = catList;
    }
}