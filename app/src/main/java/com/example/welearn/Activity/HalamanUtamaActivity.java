package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;
import com.example.welearn.Retrofit.TokenManager;

public class HalamanUtamaActivity extends AppCompatActivity {

    CardView btn_lanjutkan;
    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        btn_lanjutkan = (CardView)findViewById((R.id.btn_lanjutkan));

//        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
//                Context.MODE_PRIVATE));
//        if (tokenManager.getToken()!=null) {
//            Intent i = new Intent(HalamanUtamaActivity.this, MenuBelajarActivity.class);
//            startActivity(i);
//        }

        btn_lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HalamanUtamaActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}