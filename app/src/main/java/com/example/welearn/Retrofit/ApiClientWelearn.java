package com.example.welearn.Retrofit;

import com.example.welearn.Response.Api.ResponseApi;
import com.example.welearn.Response.Api.ResponsePredict;
import com.example.welearn.Response.Api.ResponseSoal;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;
import com.example.welearn.Response.Profile.Profile;
import com.example.welearn.Response.Profile.ResponseProfile;
import com.example.welearn.Response.Profile.ScoreHurufUser;
import com.example.welearn.Response.Ranking.RankingAngka;
import com.example.welearn.Response.Ranking.RankingHuruf;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

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
    Call<ResponsePredict> predict(@Field("img[]") ArrayList<String> image,
                                  @Field("id_soal") String id_soal, @Header("Authorization") String authHeader);


    @GET("randHuruf/{id}")
    Call<ResponseSoal<ArrayList<ListSoalHuruf>>> getSoalHuruf(@Path("id") String id, @Header("Authorization") String authHeader);

    @GET("randAngka/{id}")
    Call<ResponseSoal<ArrayList<ListSoalHuruf>>> getSoalAngka(@Path("id") String id, @Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("register")
    Call<AccessToken> register(@Field("email") String email,
                               @Field("password") String password,
                               @Field("name") String name,
                               @Field("username") String username,
                               @Field("jenis_kelamin") String jenis_kelamin);

    @GET("detail")
    Call<ResponseSoal<Profile>> getprofile();

    @FormUrlEncoded
    @POST("predictangka")
    Call<ResponsePredict> predictangka(@Field("img[]") ArrayList<String> image,
                                  @Field("id_soal") String id_soal, @Header("Authorization") String authHeader);

    @GET("scoreHurufUser")
    Call<ResponseSoal<ScoreHurufUser>> getScoreHurufUser();

    @GET("scoreTHuruf")
    Call<ResponseSoal<ArrayList<RankingHuruf>>> getRankingHuruf(@Header("Authorization") String authHeader);

    @GET("scoreTAngka")
    Call<ResponseSoal<ArrayList<RankingAngka>>> getRankingAngka(@Header("Authorization") String authHeader);

}
