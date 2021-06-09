package com.example.welearn.Retrofit;

import com.example.welearn.Response.Api.ResponseApi;
import com.example.welearn.Response.Api.ResponsePredict;

import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiClientWelearn {
    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);

    @FormUrlEncoded
    @POST("login")
    Call<AccessToken> login(@Field("username") String username,
                            @Field("password") String password);
    @FormUrlEncoded
    @POST("predict")
    Call<ResponsePredict> predict(@Field("img") ArrayList<String> image,
                                  @Field("id_soal") String id_soal, @Header("Authorization") String authHeader);


}
