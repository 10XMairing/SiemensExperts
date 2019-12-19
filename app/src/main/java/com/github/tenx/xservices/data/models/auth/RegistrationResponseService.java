package com.github.tenx.xservices.data.models.auth;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponseService {

    @SerializedName("message")
    private String message;
    @SerializedName("token")
    private String token;

    @SerializedName("business")
    private Data mData;

    public Data getmData() {
        return mData;
    }

    public void setmData(Data mData) {
        this.mData = mData;
    }

    public RegistrationResponseService(String message, String token, Data mData) {
        this.message = message;
        this.token = token;
        this.mData = mData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public class Data{
        @SerializedName("email")
        private String email;

        @SerializedName("_id")
        private String id;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Data(String email, String id) {
            this.email = email;
            this.id = id;
        }
    }

}
