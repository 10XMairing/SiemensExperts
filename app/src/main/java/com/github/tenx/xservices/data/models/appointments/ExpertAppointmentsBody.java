package com.github.tenx.xservices.data.models.appointments;

public class ExpertAppointmentsBody {
    private String location;
    private String date;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ExpertAppointmentsBody(String location, String date) {
        this.location = location;
        this.date = date;
    }
}
