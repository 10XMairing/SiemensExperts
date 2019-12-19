package com.github.tenx.xservices.data.models.appointments;

import com.google.gson.annotations.SerializedName;

public class AppointmentsConfirmationResponse {

    @SerializedName("appointment")
    private Data mData;

    public AppointmentsConfirmationResponse(Data mData) {
        this.mData = mData;
    }

    public Data getmData() {
        return mData;
    }

    public void setmData(Data mData) {
        this.mData = mData;
    }

    public class Data{

        @SerializedName("confirmStatus")
        boolean cnfStatus;

        public Data(boolean cnfStatus) {
            this.cnfStatus = cnfStatus;
        }

        public boolean isCnfStatus() {
            return cnfStatus;
        }

        public void setCnfStatus(boolean cnfStatus) {
            this.cnfStatus = cnfStatus;
        }
    }

}
