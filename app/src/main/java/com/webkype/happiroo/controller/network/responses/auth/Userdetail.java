package com.webkype.happiroo.controller.network.responses.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Userdetail {

@SerializedName("id")
@Expose
private String id;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("mobileno")
@Expose
private String mobileno;
@SerializedName("emailid")
@Expose
private String emailid;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

public String getMobileno() {
return mobileno;
}

public void setMobileno(String mobileno) {
this.mobileno = mobileno;
}

public String getEmailid() {
return emailid;
}

public void setEmailid(String emailid) {
this.emailid = emailid;
}

}