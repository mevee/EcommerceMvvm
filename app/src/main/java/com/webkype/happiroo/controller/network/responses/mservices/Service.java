package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

@SerializedName("id")
@Expose
private String id;
@SerializedName("servicename")
@Expose
private String servicename;
@SerializedName("rating")
@Expose
private String rating;
@SerializedName("sellingprice")
@Expose
private String sellingprice;
@SerializedName("banner")
@Expose
private String banner;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getServicename() {
return servicename;
}

public void setServicename(String servicename) {
this.servicename = servicename;
}

public String getRating() {
return rating;
}

public void setRating(String rating) {
this.rating = rating;
}

public String getSellingprice() {
return sellingprice;
}

public void setSellingprice(String sellingprice) {
this.sellingprice = sellingprice;
}

public String getBanner() {
return banner;
}

public void setBanner(String banner) {
this.banner = banner;
}

}