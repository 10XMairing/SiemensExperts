package com.github.tenx.xservices.data.models.auth;

import com.google.gson.annotations.SerializedName;

public class UpdateExpertBody {

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastNAme;

    @SerializedName("location")
    private String location;

    @SerializedName("bio")
    private String bio ;

    @SerializedName("token")
    private String token ;

    @SerializedName("profileImage")
    private String image ;




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
