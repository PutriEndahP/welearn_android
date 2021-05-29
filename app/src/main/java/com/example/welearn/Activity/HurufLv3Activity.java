package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;
import com.williamww.silkysignature.views.SignaturePad;

public class HurufLv3Activity extends AppCompatActivity {

    ImageView btn_back, btn_sound, reset, send;
    TextView title, soal, soalnya;
    SignaturePad huruf_pad, huruf_pad2, huruf_pad3, huruf_pad4, huruf_pad5, huruf_pad6, huruf_pad7, huruf_pad8, huruf_pad9;
    CardView card_soal, btn_reset, btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf_lv3);
        btn_back = (ImageView)findViewById(R.id.btn_back);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        title = (TextView)findViewById(R.id.judul_level);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
        card_soal = (CardView)findViewById(R.id.card_soal);
        btn_reset = (CardView)findViewById(R.id.button_reset);
        btn_send = (CardView)findViewById(R.id.button_send);
        huruf_pad = (SignaturePad)findViewById(R.id.huruf_pad);
        huruf_pad2 = (SignaturePad)findViewById(R.id.huruf_pad2);
        huruf_pad3 = (SignaturePad)findViewById(R.id.huruf_pad3);
        huruf_pad4 = (SignaturePad)findViewById(R.id.huruf_pad4);
        huruf_pad5 = (SignaturePad)findViewById(R.id.huruf_pad5);
        huruf_pad6 = (SignaturePad)findViewById(R.id.huruf_pad6);
        huruf_pad7 = (SignaturePad)findViewById(R.id.huruf_pad7);
        huruf_pad8 = (SignaturePad)findViewById(R.id.huruf_pad8);
        huruf_pad9 = (SignaturePad)findViewById(R.id.huruf_pad9);
    }
}