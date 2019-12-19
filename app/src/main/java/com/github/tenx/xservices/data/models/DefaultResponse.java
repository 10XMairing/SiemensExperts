package com.github.tenx.xservices.data.models;

public class DefaultResponse {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DefaultResponse(String status) {
        this.status = status;
    }
}
