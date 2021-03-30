package com.webkype.happiroo.controller.network.responses.prod_detail_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdImage {

@SerializedName("img")
@Expose
private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}