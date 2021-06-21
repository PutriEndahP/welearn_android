package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseSoal;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;
import com.example.welearn.Retrofit.ApiClientWelearn;
import com.example.welearn.Retrofit.ServerWelearn;
import com.example.welearn.Retrofit.TokenManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LevelHurufActivity extends AppCompatActivity {

    ImageView icon0, icon1, icon2, icon3, icon4, btn_back;
    TextView lev0, lev1, lev2, lev3, lev4;
    TokenManager tokenManager;
    ApiClientWelearn api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_huruf);

        icon0 = (ImageView) findViewById(R.id.icon0);
        icon0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                        Context.MODE_PRIVATE));
//                ApiClientWelearn api = ServerWelearn.createServiceWithAuth(ApiClientWelearn.class, tokenManager);
                api = ServerWelearn.createService(ApiClientWelearn.class);
                Call<ResponseSoal<ArrayList<ListSoalHuruf>>> soal = api.getSoalHuruf("0", "Bearer " + tokenManager.getToken());

                soal.enqueue(new Callback<ResponseSoal<ArrayList<ListSoalHuruf>>>() {
                    @Override
                    public void onResponse(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Response<ResponseSoal<ArrayList<ListSoalHuruf>>> response) {
                        if (response.code() == 200) {
                            Log.e("response get soal", response.body().getMessage().toString());
//
//                            Intent i = new Intent(LevelHurufActivity.this, Level0SoalActivity.class);
//                            i.putExtra("idSoal", );
//                            startActivity(i);

                            Intent i = new Intent(LevelHurufActivity.this, Level0SoalActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("mylist", response.body().getMessage());
                            i.putExtras(bundle);
                            startActivity(i);

                        } else {
                            Log.e("gagal get soal", response.raw().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Throwable t) {
                        Log.e("Gagal", t.toString());
                    }
                });
            }
        });

        icon1 = (ImageView) findViewById(R.id.icon1);
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                        Context.MODE_PRIVATE));
//                ApiClientWelearn api = ServerWelearn.createServiceWithAuth(ApiClientWelearn.class, tokenManager);
                api = ServerWelearn.createService(ApiClientWelearn.class);
                Call<ResponseSoal<ArrayList<ListSoalHuruf>>> soal = api.getSoalHuruf("1", "Bearer " + tokenManager.getToken());

                soal.enqueue(new Callback<ResponseSoal<ArrayList<ListSoalHuruf>>>() {
                    @Override
                    public void onResponse(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Response<ResponseSoal<ArrayList<ListSoalHuruf>>> response) {
                        if (response.code() == 200) {
                            Log.e("response get soal", response.body().getMessage().toString());
//
//                            Intent i = new Intent(LevelHurufActivity.this, Level0SoalActivity.class);
//                            i.putExtra("idSoal", );
//                            startActivity(i);

                            Intent i = new Intent(LevelHurufActivity.this, Level0SoalActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("mylist", response.body().getMessage());
                            i.putExtras(bundle);
                            startActivity(i);

                        } else {
                            Log.e("gagal get soal", response.raw().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Throwable t) {
                        Log.e("Gagal", t.toString());
                    }
                });
            }
        });




        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LevelHurufActivity.this, MenuBelajarActivity.class);
                startActivity(i);
            }
        });
    }
}