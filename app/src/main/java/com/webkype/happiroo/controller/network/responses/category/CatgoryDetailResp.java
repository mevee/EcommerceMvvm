package com.webkype.happiroo.controller.network.responses.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatgoryDetailResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("categorydetails")
@Expose
private Categorydetails categorydetails;

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

public Categorydetails getCategorydetails() {
return categorydetails;
}

public void setCategorydetails(Categorydetails categorydetails) {
this.categorydetails = categorydetails;
}

}