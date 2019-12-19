package com.github.tenx.xservices.ui.main.recyclerView;

public class HomePageItemsModel {


    private Integer image;
    private String name;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomePageItemsModel(Integer image, String name) {
        this.image = image;
        this.name = name;
    }
}
