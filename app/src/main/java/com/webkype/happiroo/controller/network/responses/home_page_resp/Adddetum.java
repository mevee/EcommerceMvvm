package com.webkype.happiroo.controller.network.responses.home_page_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Adddetum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("banerimgs")
@Expose
private String banner;

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

}