package com.webkype.happiroo.controller.network.responses.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCatListResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("subcatlist")
@Expose
private List<Subcat> subcatlist = null;

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

public List<Subcat> getSubcatlist() {
return subcatlist;
}

public void setSubcatlist(List<Subcat> subcatlist) {
this.subcatlist = subcatlist;
}

}