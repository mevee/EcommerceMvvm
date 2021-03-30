package com.webkype.happiroo.model;

public class OrderModel {
    private String orderId,productName,value,noOfItems,orderDate,imageUrl,status;


    public OrderModel() {
    }

    public OrderModel(String orderId, String productName, String value, String noOfItems, String orderDate, String imageUrl, String status) {
        this.orderId = orderId;
        this.productName = productName;
        this.value = value;
        this.noOfItems = noOfItems;
        this.orderDate = orderDate;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(String noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
