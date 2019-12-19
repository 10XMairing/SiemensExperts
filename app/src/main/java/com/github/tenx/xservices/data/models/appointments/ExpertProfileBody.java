package com.github.tenx.xservices.data.models.appointments;

public class ExpertProfileBody {

    private Integer profilePic;

    private String name;

    private String expertise;

    private String description;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExpertProfileBody(Integer profilePic, String name, String expertise, String description, String id) {
        this.profilePic = profilePic;
        this.name = name;
        this.expertise = expertise;
        this.description = description;
        this.id = id;
    }

    public Integer getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Integer profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
