package com.webkype.happiroo.controller.network.responses.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subcat {

@SerializedName("catid")
@Expose
private String catid;
@SerializedName("cataname")
@Expose
private String cataname;

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

}