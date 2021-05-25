package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;
import com.williamww.silkysignature.views.SignaturePad;

public class SoalHuruf1Activity extends AppCompatActivity {

    ImageView btn_back, btn_sound, reset, send;
    TextView title, soal, soalnya;
    CardView cardSoal, cardReset, cardSend;
    SignaturePad huruf_pad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_huruf1);
        btn_back = (ImageView)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(SoalHuruf1Activity.this, ProfileActivity.class);
                startActivity(j);
            }
        });
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        title = (TextView)findViewById(R.id.judul_level);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
        cardSoal = (CardView)findViewById(R.id.card_soal);
        cardReset = (CardView)findViewById(R.id.button_reset);
        cardSend = (CardView)findViewById(R.id.button_send);
        cardSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SoalHuruf1Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
        huruf_pad = (SignaturePad)findViewById(R.id.huruf_pad);
    }
}