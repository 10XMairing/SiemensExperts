package com.github.tenx.xservices.ui.Services.storage.adapter;

public class StorageDataModel {
    private String name;
    private String location;
    private String price;
    private Integer image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public StorageDataModel(String name, String location, String price, Integer image) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.image = image;
    }
}
