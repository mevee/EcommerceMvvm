package com.webkype.happiroo.controller.network.responses.home_page_resp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stripdatum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("stripname")
@Expose
private String stripname;
@SerializedName("stripcategories")
@Expose
private List<Stripcategory> stripcategories = null;
@SerializedName("bannersdeta")
@Expose
private List<Adddetum> bannersdeta = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getStripname() {
return stripname;
}

public void setStripname(String stripname) {
this.stripname = stripname;
}

public List<Stripcategory> getStripcategories() {
return stripcategories;
}

public void setStripcategories(List<Stripcategory> stripcategories) {
this.stripcategories = stripcategories;
}

    public List<Adddetum> getBannersdeta() {
        return bannersdeta;
    }

    public void setBannersdeta(List<Adddetum> bannersdeta) {
        this.bannersdeta = bannersdeta;
    }
}