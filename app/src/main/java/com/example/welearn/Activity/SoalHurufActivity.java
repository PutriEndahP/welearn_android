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

    ImageView ImageView, ImageSound, reset, send;
    TextView judul, soal, textSoal;
    CardView cardSoal, btn_reset, btn_send;
    SignaturePad hurufPad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_huruf);
//        ImageView = (ImageView)findViewById(R.id.btn_back);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(SoalHurufActivity.this, ProfileActivity.class);
                startActivity(j);
            }
        });
        ImageSound = (ImageView)findViewById(R.id.btn_sound);
//        judul = (TextView)findViewById(R.id.judul_level);
        soal = (TextView)findViewById(R.id.soal);
        textSoal = (TextView)findViewById(R.id.soalnya);
//        cardSoal = (CardView)findViewById(R.id.card_soal);
        hurufPad = (SignaturePad)findViewById(R.id.huruf_pad);
        btn_reset = (CardView)findViewById(R.id.button_reset);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        btn_send = (CardView)findViewById(R.id.button_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SoalHurufActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}