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
    @SerializedName("adbanner1")
    @Expose
    private String adbanner1;
    @SerializedName("adbanner2")
    @Expose
    private String adbanner2;
    @SerializedName("adbanner3")
    @Expose
    private String adbanner3;

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

    @SerializedName("bannersdeta_pro")
    @Expose
    private List<Ratecardsimgdetum> bannersdeta_pro = null;

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

    public String getAdbanner1() {
        return adbanner1;
    }

    public void setAdbanner1(String adbanner1) {
        this.adbanner1 = adbanner1;
    }

    public String getAdbanner2() {
        return adbanner2;
    }

    public void setAdbanner2(String adbanner2) {
        this.adbanner2 = adbanner2;
    }

    public String getAdbanner3() {
        return adbanner3;
    }

    public void setAdbanner3(String adbanner3) {
        this.adbanner3 = adbanner3;
    }

    public List<Ratecardsimgdetum> getBannersdeta_pro() {
        return bannersdeta_pro;
    }

    public void setBannersdeta_pro(List<Ratecardsimgdetum> bannersdeta_pro) {
        this.bannersdeta_pro = bannersdeta_pro;
    }
}