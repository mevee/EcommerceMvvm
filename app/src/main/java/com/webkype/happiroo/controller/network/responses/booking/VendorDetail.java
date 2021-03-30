package com.webkype.happiroo.controller.network.responses.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorDetail {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("vendorname")
    @Expose
    private String vendorname;


    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("noofrating")
    @Expose
    private String noofrating;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNoofrating() {
        return noofrating;
    }

    public void setNoofrating(String noofrating) {
        this.noofrating = noofrating;
    }
}