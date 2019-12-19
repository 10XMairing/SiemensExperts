package com.github.tenx.xservices.ui.Services.equipments.adapter;

public class EquipmentsDataModel {

    private String product;
    private String manufacturer;
    private String price;
    private String location;
    private Integer image;


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public EquipmentsDataModel(String product, String manufacturer, String price, String location, Integer image) {
        this.product = product;
        this.manufacturer = manufacturer;
        this.price = price;
        this.location = location;
        this.image = image;
    }
}
