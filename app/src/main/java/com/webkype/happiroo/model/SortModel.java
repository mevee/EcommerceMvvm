package com.webkype.happiroo.model;

import androidx.annotation.NonNull;

public class SortModel {
    String sortTitle,sortValue;

    public SortModel(String sortTitle, String sortValue) {
        this.sortTitle = sortTitle;
        this.sortValue = sortValue;
    }

    public String getSortTitle() {
        return sortTitle;
    }

    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    @NonNull
    @Override
    public String toString() {
        return sortTitle;
    }
}
