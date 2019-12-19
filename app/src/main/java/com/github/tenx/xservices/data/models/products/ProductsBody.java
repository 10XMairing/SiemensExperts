package com.github.tenx.xservices.data.models.products;

import com.google.gson.annotations.SerializedName;

public class ProductsBody {


    private String name;

    private String description;

    private int price;

    private int discount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ProductsBody(String name, String description, int price, int discount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }
}
