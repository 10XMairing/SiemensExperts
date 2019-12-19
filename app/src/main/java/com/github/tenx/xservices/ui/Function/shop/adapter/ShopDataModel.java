package com.github.tenx.xservices.ui.Function.shop.adapter;

public class ShopDataModel {

    private String nameCompany;
    private String nameProduct;
    private String adBody;
    private Integer adImage;


    public ShopDataModel(String nameCompany, String nameProduct, String adBody, Integer adImage) {
        this.nameCompany = nameCompany;
        this.nameProduct = nameProduct;
        this.adBody = adBody;
        this.adImage = adImage;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getAdBody() {
        return adBody;
    }

    public void setAdBody(String adBody) {
        this.adBody = adBody;
    }

    public Integer getAdImage() {
        return adImage;
    }

    public void setAdImage(Integer adImage) {
        this.adImage = adImage;
    }
}
