package com.webkype.happiroo.controller.network.responses.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceCategory {

@SerializedName("cat_id")
@Expose
private String id;
@SerializedName("subcatimg")
@Expose
private String banerimgs;
@SerializedName("subcatname")
@Expose
private String subcatname;

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

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }
}