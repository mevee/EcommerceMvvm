package com.webkype.happiroo.controller.network.responses.mservices;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceListResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("servicelist")
@Expose
private List<Servicelist> servicelist = null;

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

public List<Servicelist> getServicelist() {
return servicelist;
}

public void setServicelist(List<Servicelist> servicelist) {
this.servicelist = servicelist;
}

}