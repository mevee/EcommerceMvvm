package com.webkype.happiroo.controller.network.responses.prod_review_resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("user_name")
    @Expose
    private String user_name;
    @SerializedName("user_img")
    @Expose
    private String user_img;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }
}