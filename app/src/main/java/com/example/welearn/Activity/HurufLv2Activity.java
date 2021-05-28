package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;
import com.williamww.silkysignature.views.SignaturePad;

public class HurufLv2Activity extends AppCompatActivity {

    ImageView btn_back, btn_sound, reset, send;
    TextView title, soal, soalnya;
    CardView card_soal, btn_reset, btn_send;
    SignaturePad huruf_pad, huruf_pad2, huruf_pad3, huruf_pad4, huruf_pad5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf_lv2);
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
        huruf_pad = (SignaturePad)findViewById(R.id.padsoalangka);
        huruf_pad2 = (SignaturePad)findViewById(R.id.huruf_pad2);
        huruf_pad3 = (SignaturePad)findViewById(R.id.huruf_pad3);
        huruf_pad4 = (SignaturePad)findViewById(R.id.huruf_pad4);
        huruf_pad5 = (SignaturePad)findViewById(R.id.huruf_pad5);
    }
}