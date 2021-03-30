package com.webkype.happiroo.controller.network.responses.prod_review_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.webkype.happiroo.controller.network.responses.prod_detail_resp.ProductDetail;

import java.util.List;

public class ProductReviewResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("revlist")
    @Expose
    private List<Review> revlist;

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

    public List<Review> getRevlist() {
        return revlist;
    }

    public void setRevlist(List<Review> revlist) {
        this.revlist = revlist;
    }
}