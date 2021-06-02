package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class SoalAksaraActivity extends AppCompatActivity {

    ImageView back, btn_sound, reset, send;
    TextView soal, soalnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_aksara);

        back = (ImageView)findViewById(R.id.back);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
    }
}