package com.example.welearn.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("message")
    @Expose
    private Message message;

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getAccessToken(){ return accessToken; }

    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken(){
        return refreshToken;
    }

    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }

    public String getTokenType(){
        return tokenType;
    }

    public void setExpiresIn(int expiresIn){
        this.expiresIn = expiresIn;
    }

    public int getExpiresIn(){
        return expiresIn;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "access_token = '" + accessToken + '\'' +
                        ",refresh_token = '" + refreshToken + '\'' +
                        ",token_type = '" + tokenType + '\'' +
                        ",expires_in = '" + expiresIn + '\'' +
                        "}";
    }

}
