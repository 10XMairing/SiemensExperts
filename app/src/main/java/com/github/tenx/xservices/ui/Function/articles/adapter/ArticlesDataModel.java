package com.github.tenx.xservices.ui.Function.articles.adapter;

public class ArticlesDataModel {


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

    public ArticlesDataModel(Integer image, String name) {
        this.image = image;
        this.name = name;
    }
}
