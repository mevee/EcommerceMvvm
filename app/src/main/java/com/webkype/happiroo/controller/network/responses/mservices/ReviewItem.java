package com.webkype.happiroo.controller.network.responses.mservices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewItem {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("reviewdate")
    @Expose
    private String reviewdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }
}