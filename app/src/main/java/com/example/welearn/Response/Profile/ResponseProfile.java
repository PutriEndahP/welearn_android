package com.example.welearn.Response.Profile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseProfile {
    @SerializedName("profile")
    private List<Profile> profile;

    public List<Profile> getProfile(){
        return profile;
    }
}
