package com.github.tenx.xservices.ui.Function.cart.adapter;

public class CartDataModel {

    private String name;
    private int price;
    private Integer image;


    public CartDataModel(String name, int price, Integer image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDescription() {
        return price;
    }

    public void setDescription(int description) {
        this.price = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
