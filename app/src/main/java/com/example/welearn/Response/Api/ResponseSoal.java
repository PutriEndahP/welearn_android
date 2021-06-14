package com.example.welearn.Response.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSoal <T>{
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("message")
    @Expose
    private T message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) { this.success = success; }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


