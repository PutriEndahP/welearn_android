package com.example.welearn.Response.Login;

import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    @SerializedName("token")
    String token;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
