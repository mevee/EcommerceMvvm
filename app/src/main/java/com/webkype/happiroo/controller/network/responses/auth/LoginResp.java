package com.webkype.happiroo.controller.network.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("userdetail")
@Expose
private Userdetail userdetail;

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

public Userdetail getUserdetail() {
return userdetail;
}

public void setUserdetail(Userdetail userdetail) {
this.userdetail = userdetail;
}

}