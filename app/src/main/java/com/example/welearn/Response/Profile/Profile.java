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

    @SerializedName("score")
    private Integer score;

    @SerializedName("angka")
    private Integer angka;

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

    public Integer getScore() { return score; }
    public Integer getAngka() { return angka; }
}

