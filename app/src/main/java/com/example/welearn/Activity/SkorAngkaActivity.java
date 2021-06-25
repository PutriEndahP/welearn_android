package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.welearn.Activity.Fragment.RankAngkaAdabter;
import com.example.welearn.Activity.Fragment.RankHurufAdabter;
import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseSoal;
import com.example.welearn.Response.Ranking.RankingAngka;
import com.example.welearn.Response.Ranking.RankingHuruf;
import com.example.welearn.Retrofit.ApiClientWelearn;
import com.example.welearn.Retrofit.ServerWelearn;
import com.example.welearn.Retrofit.TokenManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkorAngkaActivity extends AppCompatActivity {

    RankAngkaAdabter adapter;
    ArrayList<RankingAngka> mAngka = new ArrayList<>();
    TextView skor_huruf, skor_angka;
    TokenManager tokenManager;
    ApiClientWelearn api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_angka);

        Bundle bundle = getIntent().getExtras();
        ArrayList<RankingAngka> arraylist = bundle.getParcelableArrayList("mylist");
        mAngka.addAll(arraylist);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvRankAngka);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new RankAngkaAdabter(this, arraylist);
        recyclerView.setAdapter(adapter);

        skor_huruf = findViewById(R.id.skor_huruf);
        skor_huruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", Context.MODE_PRIVATE));
                api = ServerWelearn.createService(ApiClientWelearn.class);
                Call<ResponseSoal<ArrayList<RankingHuruf>>> rank = api.getRankingHuruf("Bearer " + tokenManager.getToken());

                rank.enqueue(new Callback<ResponseSoal<ArrayList<RankingHuruf>>>() {
                    @Override
                    public void onResponse(Call<ResponseSoal<ArrayList<RankingHuruf>>> call, Response<ResponseSoal<ArrayList<RankingHuruf>>> response) {
                        if (response.code() == 200) {
                            Log.e("response get huruf", response.body().getMessage().toString());

                            Intent i = new Intent(SkorAngkaActivity.this, SkorActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("mylist", response.body().getMessage());
                            i.putExtras(bundle);
                            startActivity(i);

                        } else {
                            Log.e("gagal get huruf", response.raw().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSoal<ArrayList<RankingHuruf>>> call, Throwable t) {
                        Log.e("Gagal", t.toString());
                    }

                });
            }
        });
    }
}