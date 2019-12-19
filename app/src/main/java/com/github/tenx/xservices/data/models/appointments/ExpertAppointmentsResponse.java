package com.github.tenx.xservices.data.models.appointments;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExpertAppointmentsResponse {

    @SerializedName("expert")
    private String id;

    @SerializedName("appointments")
    private ArrayList<AppointmentBody> mList;

    public String getFarmer_id() {
        return id;
    }

    public void setFarmer_id(String id) {
        this.id = id;
    }

    public ArrayList<AppointmentBody> getmList() {
        return mList;
    }

    public void setmList(ArrayList<AppointmentBody> mList) {
        this.mList = mList;
    }

    public ExpertAppointmentsResponse(String id, ArrayList<AppointmentBody> mList) {
        this.id = id;
        this.mList = mList;
    }

    public class AppointmentBody{

        @SerializedName("confirmStatus")
        private boolean confirmStatus;

        @SerializedName("_id")
        private String id;


        @SerializedName("price")
        private String price;

        @SerializedName("description")
        private String description;

        @SerializedName("farmer")
        private Farmer farmer;

        public Farmer getFarmer() {
            return farmer;
        }

        public void setFarmer(Farmer farmer) {
            this.farmer = farmer;
        }

        public class Farmer{

            @SerializedName("firstName")
            private String fName;

            @SerializedName("lastName")
            private String lName;

            public Farmer(String fName, String lName) {
                this.fName = fName;
                this.lName = lName;
            }

            public String getfName() {
                return fName;
            }

            public void setfName(String fName) {
                this.fName = fName;
            }

            public String getlName() {
                return lName;
            }

            public void setlName(String lName) {
                this.lName = lName;
            }
        }


        //TODO send me name of farmer,myname.

        public AppointmentBody(boolean confirmStatus, String id,
                               String price, String description) {
            this.confirmStatus = confirmStatus;
            this.id = id;
            this.price = price;
            this.description = description;
        }

        public boolean isConfirmStatus() {
            return confirmStatus;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean getConfirmStatus() {
            return confirmStatus;
        }

        public void setConfirmStatus(boolean confirmStatus) {
            this.confirmStatus = confirmStatus;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public AppointmentBody(boolean confirmStatus, String id, String price) {
            this.confirmStatus = confirmStatus;
            this.id = id;

            this.price = price;
        }
    }

}
