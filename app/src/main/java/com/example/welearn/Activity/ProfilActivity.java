package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseSoal;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;
import com.example.welearn.Response.Profile.Profile;
import com.example.welearn.Response.Profile.ResponseProfile;
import com.example.welearn.Retrofit.AccessToken;
import com.example.welearn.Retrofit.ApiClientWelearn;
import com.example.welearn.Retrofit.ServerWelearn;
import com.example.welearn.Retrofit.TokenManager;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    ImageView btn_back, account, logoutProfile;
    TextView title, username, email, jenis_kelamin, textView3, scorehuruf, scoreangka, textView4, logout;
    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));

        btn_back = (ImageView)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilActivity.this, MenuBelajarActivity.class);
                startActivity(i);
            }
        });

        account = (ImageView)findViewById(R.id.account);
        logoutProfile = (ImageView)findViewById(R.id.logoutProfile);
        title = (TextView)findViewById(R.id.judul_level);
        username = (TextView)findViewById(R.id.username);
        email = (TextView)findViewById(R.id.email);
        jenis_kelamin = (TextView)findViewById(R.id.jenis_kelamin);
        textView3 = (TextView)findViewById(R.id.textView3);
        scorehuruf = (TextView)findViewById(R.id.scorehuruf);
        scoreangka = (TextView)findViewById(R.id.scoreangka);
        textView4 = (TextView)findViewById(R.id.textView4);
        logout = (TextView)findViewById(R.id.logout);
        logout.setOnClickListener(e -> {
            onBackPressed();
        });

        getProfile();
//        getHuruf();

//        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
//                Context.MODE_PRIVATE));
////                ApiClientWelearn api = ServerWelearn.createServiceWithAuth(ApiClientWelearn.class, tokenManager);
//        ApiClientWelearn api = ServerWelearn.createService(ApiClientWelearn.class);
//        Call<AccessToken> logout = api.logout();
    }

    private void getProfile() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(ProfilActivity.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.show();

        ApiClientWelearn api = ServerWelearn.createServiceWithAuth(ApiClientWelearn.class,tokenManager);
        final Call<ResponseSoal<Profile>> profile = api.getprofile();
        profile.enqueue(new Callback<ResponseSoal<Profile>>() {

            @Override
            public void onResponse(Call<ResponseSoal<Profile>> call, Response<ResponseSoal<Profile>> response) {
                if(response.isSuccessful()) {
                    pDialog.dismiss();
                    ResponseSoal<Profile> ResponseProfile = response.body();
                    username.setText(response.body().getMessage().getUsername());
                    email.setText(response.body().getMessage().getEmail());
                    jenis_kelamin.setText(response.body().getMessage().getJenis_kelamin());
                    scorehuruf.setText(String.valueOf(response.body().getMessage().getScore()));
                    textView4.setText(String.valueOf(response.body().getMessage().getAngka()));
                }
            }

            @Override
            public void onFailure(Call<ResponseSoal<Profile>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
        new SweetAlertDialog(ProfilActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Keluar Aplikasi")
                .setContentText("Apakah ingin keluar Aplikasi")
                .setCancelText("Tidak")
                .setConfirmText("Iya")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        Constans.quit(ProfilActivity.this);
                        Constans.deleteCache(ProfilActivity.this);
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .show();
//            super.onBackPressed();
//        }
    }

}