package com.webkype.happiroo.controller.network.responses.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categorydetails {

@SerializedName("cat_id")
@Expose
private String catId;
@SerializedName("categoryname")
@Expose
private String categoryname;
@SerializedName("belowbanner")
@Expose
private String belowbanner;
@SerializedName("howwedo")
@Expose
private String howwedo;

@SerializedName("video")
@Expose
private String video;
@SerializedName("subcategorydetails")
@Expose
private List<ServiceCategory> subcategorydetails = null;
@SerializedName("bannerimages")
@Expose
private List<Bannerimage> bannerimages = null;
@SerializedName("ratecardsimgdeta")
@Expose
private List<Ratecardsimgdetum> ratecardsimgdeta = null;

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

public String getBelowbanner() {
return belowbanner;
}

public void setBelowbanner(String belowbanner) {
this.belowbanner = belowbanner;
}

public List<ServiceCategory> getSubcategorydetails() {
return subcategorydetails;
}

public void setSubcategorydetails(List<ServiceCategory> subcategorydetails) {
this.subcategorydetails = subcategorydetails;
}

public List<Bannerimage> getBannerimages() {
return bannerimages;
}

public void setBannerimages(List<Bannerimage> bannerimages) {
this.bannerimages = bannerimages;
}

public List<Ratecardsimgdetum> getRatecardsimgdeta() {
return ratecardsimgdeta;
}

public void setRatecardsimgdeta(List<Ratecardsimgdetum> ratecardsimgdeta) {
this.ratecardsimgdeta = ratecardsimgdeta;
}

    public String getHowwedo() {
        return howwedo;
    }

    public void setHowwedo(String howwedo) {
        this.howwedo = howwedo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}