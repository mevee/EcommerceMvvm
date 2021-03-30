package com.webkype.happiroo.model;

public class SelectModel {

    private String itemName;
    private String itemId;

    public SelectModel(String name, String itemId) {
        this.itemName = name;
        this.itemId = itemId;
     }

    public SelectModel() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
