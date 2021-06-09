package com.example.welearn.Response.Api;

import com.example.welearn.Retrofit.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseApi {
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("message")
    @Expose
    private Message message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) { this.success = success; }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
