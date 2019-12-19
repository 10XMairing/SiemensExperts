package com.github.tenx.xservices.data.models.appointments;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllExpertsResponse {

    @SerializedName("expert")
    private ArrayList<ExpertProfileBody> mList;

    public ArrayList<ExpertProfileBody> getmList() {
        return mList;
    }

    public void setmList(ArrayList<ExpertProfileBody> mList) {
        this.mList = mList;
    }

    public AllExpertsResponse(ArrayList<ExpertProfileBody> mList) {
        this.mList = mList;
    }
}
