package com.webkype.happiroo.controller.network.responses.home_page_resp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeApiResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("banner_video")
@Expose
private List<BannerVieodetum> banner_video = null;

@SerializedName("bannerdeta")
@Expose
private List<Bannerdetum> bannerdeta = null;
@SerializedName("addbanner")
@Expose
private List<Addbanner> addbanner = null;
@SerializedName("categorydeta")
@Expose
private List<Categorydetum> categorydeta = null;
@SerializedName("stripdata")
@Expose
private List<Stripdatum> stripdata = null;

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

public List<Bannerdetum> getBannerdeta() {
return bannerdeta;
}

public void setBannerdeta(List<Bannerdetum> bannerdeta) {
this.bannerdeta = bannerdeta;
}

public List<Addbanner> getAddbanner() {
return addbanner;
}

public void setAddbanner(List<Addbanner> addbanner) {
this.addbanner = addbanner;
}

public List<Categorydetum> getCategorydeta() {
return categorydeta;
}

public void setCategorydeta(List<Categorydetum> categorydeta) {
this.categorydeta = categorydeta;
}

public List<Stripdatum> getStripdata() {
return stripdata;
}

public void setStripdata(List<Stripdatum> stripdata) {
this.stripdata = stripdata;
}

    public List<BannerVieodetum> getBanner_video() {
        return banner_video;
    }

    public void setBanner_video(List<BannerVieodetum> banner_video) {
        this.banner_video = banner_video;
    }
}