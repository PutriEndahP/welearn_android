package com.example.welearn.Response.Profile;

import com.google.gson.annotations.SerializedName;

public class Profile {
//    @SerializedName("name")
//    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;

//    public String getName(){
//        return name;
//    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getJenis_kelamin(){
        return jenis_kelamin;
    }
}

