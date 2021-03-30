package com.webkype.happiroo.controller.network.responses.product_cat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdSubCategory {

@SerializedName("catid")
@Expose
private String catid;
@SerializedName("cataname")
@Expose
private String cataname;

@SerializedName("catthumb")
@Expose
private String catthumb;

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCataname() {
        return cataname;
    }

    public void setCataname(String cataname) {
        this.cataname = cataname;
    }

    public String getCatthumb() {
        return catthumb;
    }

    public void setCatthumb(String catthumb) {
        this.catthumb = catthumb;
    }


}