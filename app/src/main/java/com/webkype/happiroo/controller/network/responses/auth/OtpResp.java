package com.webkype.happiroo.controller.network.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("otp")
@Expose
private int otp;

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

public int getOtp() {
return otp;
}

public void setOtp(int otp) {
this.otp = otp;
}

}