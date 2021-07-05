package com.webkype.happiroo.controller.network.responses.home_page_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerVieodetum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("banner")
@Expose
private String banner;
@SerializedName("banner_vid")
@Expose
private String banner_vid;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getBanner() {
return banner;
}

public void setBanner(String banner) {
this.banner = banner;
}

    public String getBanner_vid() {
        return banner_vid;
    }

    public void setBanner_vid(String banner_vid) {
        this.banner_vid = banner_vid;
    }
}