package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class HalamanUtamaActivity extends AppCompatActivity {

    CardView btn_lanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        btn_lanjutkan = (CardView)findViewById((R.id.btn_lanjutkan));

        btn_lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HalamanUtamaActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}