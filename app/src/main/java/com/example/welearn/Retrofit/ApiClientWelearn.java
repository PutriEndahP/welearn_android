package com.example.welearn.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClientWelearn {
    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);

    @FormUrlEncoded
    @POST("login")
    Call<AccessToken> login(@Field("username") String username,
                            @Field("password") String password);


}
