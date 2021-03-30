package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Servicepic {

    @SerializedName("imgid")
    @Expose
    private String imgid;
    @SerializedName("image")
    @Expose
    private String image;

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}