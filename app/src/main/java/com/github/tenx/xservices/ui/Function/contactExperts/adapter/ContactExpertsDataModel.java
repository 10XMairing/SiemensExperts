package com.github.tenx.xservices.ui.Function.contactExperts.adapter;

public class ContactExpertsDataModel {
    private String expertName;
    private Integer expertImage;


    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public Integer getExpertImage() {
        return expertImage;
    }

    public void setExpertImage(Integer expertImage) {
        this.expertImage = expertImage;
    }

    public ContactExpertsDataModel(Integer expertImage,String expertName) {
        this.expertName = expertName;
        this.expertImage = expertImage;
    }
}
