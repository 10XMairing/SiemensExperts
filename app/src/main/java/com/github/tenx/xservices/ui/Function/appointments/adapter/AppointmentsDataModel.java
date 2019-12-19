package com.github.tenx.xservices.ui.Function.appointments.adapter;

public class AppointmentsDataModel {

    private String name;
    private String subject;
    private Integer image;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AppointmentsDataModel(String name, String subject, Integer image, String status) {
        this.name = name;
        this.subject = subject;
        this.image = image;
        this.status = status;
    }
}
