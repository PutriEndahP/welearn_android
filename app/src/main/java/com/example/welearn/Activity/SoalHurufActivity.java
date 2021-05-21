package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;
import com.williamww.silkysignature.views.SignaturePad;

public class SoalHurufActivity extends AppCompatActivity {

    ImageView ImageView, ImageLion, ImageSound;
    TextView judul, soal, textSoal;
    CardView cardView;
    SignaturePad hurufPad;
    ImageButton btn_reset, btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_huruf);
        ImageView = (ImageView)findViewById(R.id.btn_back);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(SoalHurufActivity.this, MainActivity.class);
                startActivity(j);
            }
        });
        ImageLion = (ImageView)findViewById(R.id.pict_lion);
        ImageSound = (ImageView)findViewById(R.id.btn_sound);
        judul = (TextView)findViewById(R.id.judul_level);
        soal = (TextView)findViewById(R.id.soal);
        textSoal = (TextView)findViewById(R.id.soalnya);
        cardView = (CardView)findViewById(R.id.sound);
        hurufPad = (SignaturePad)findViewById(R.id.huruf_pad);
        btn_reset = (ImageButton)findViewById(R.id.button_reset);
        btn_send = (ImageButton)findViewById(R.id.button_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SoalHurufActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}