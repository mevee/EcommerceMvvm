package com.webkype.happiroo.controller.network.responses.address;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressResp {

@SerializedName("status")
@Expose
private String status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("addresslist")
@Expose
private List<Addresslist> addresslist = null;

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

public List<Addresslist> getAddresslist() {
return addresslist;
}

public void setAddresslist(List<Addresslist> addresslist) {
this.addresslist = addresslist;
}

}