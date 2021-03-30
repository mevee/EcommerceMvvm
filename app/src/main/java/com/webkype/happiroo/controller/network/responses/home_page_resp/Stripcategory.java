package com.webkype.happiroo.controller.network.responses.home_page_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stripcategory {

@SerializedName("cat_id")
@Expose
private String catId;
@SerializedName("categoryname")
@Expose
private String categoryname;
@SerializedName("catimgnew")
@Expose
private String catimgnew;

public String getCatId() {
return catId;
}

public void setCatId(String catId) {
this.catId = catId;
}

public String getCategoryname() {
return categoryname;
}

public void setCategoryname(String categoryname) {
this.categoryname = categoryname;
}

public String getCatimgnew() {
return catimgnew;
}

public void setCatimgnew(String catimgnew) {
this.catimgnew = catimgnew;
}

}