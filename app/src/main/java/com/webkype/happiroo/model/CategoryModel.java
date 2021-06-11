package com.webkype.happiroo.model;

public class CategoryModel {

    private String image;
    private String name;
    private String catId;
    private String isHaveSubCat;


    public CategoryModel(String image, String name, String catId) {
        this.image = image;
        this.name = name;
        this.catId = catId;
    }

    public CategoryModel(String image, String name, String catId, String subCatId) {
        this.image = image;
        this.name = name;
        this.catId = catId;
        this.isHaveSubCat = subCatId;
    }

    public CategoryModel() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getIsHaveSubCat() {
        return isHaveSubCat;
    }

    public void setIsHaveSubCat(String isHaveSubCat) {
        this.isHaveSubCat = isHaveSubCat;
    }
}
