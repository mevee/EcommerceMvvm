package com.webkype.happiroo.controller.network.responses.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bannerimage {

@SerializedName("id")
@Expose
private String id;
@SerializedName("banerimgs")
@Expose
private String banerimgs;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getBanerimgs() {
return banerimgs;
}

public void setBanerimgs(String banerimgs) {
this.banerimgs = banerimgs;
}

}