package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.welearn.R;

public class SkorActivity extends AppCompatActivity {

    TextView skor_huruf, skor_angka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        skor_huruf = (TextView)findViewById(R.id.skor_huruf);
        skor_angka = (TextView)findViewById(R.id.skor_angka);
    }
}