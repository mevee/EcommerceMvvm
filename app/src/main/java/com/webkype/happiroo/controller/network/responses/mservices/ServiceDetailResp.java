package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceDetailResp {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("servicedetails")
    @Expose
    private Servicedetails servicedetails;

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

    public Servicedetails getServicedetails() {
        return servicedetails;
    }

    public void setServicedetails(Servicedetails servicedetails) {
        this.servicedetails = servicedetails;
    }
}