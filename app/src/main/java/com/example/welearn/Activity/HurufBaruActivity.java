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

public class HurufBaruActivity extends AppCompatActivity {

    ImageView btn_back, btn_sound, reset, send;
    TextView text_level, text_soalke, text_soalnya;
    CardView card_soal, mBtnReset, mBtnSend;
    SignaturePad mHurufPad;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf_baru);
        id = getIntent().getIntExtra("id",0);

//        btn_back = (ImageView)findViewById(R.id.imageView3);
        btn_back = (ImageView)findViewById(R.id.btn_back);
//        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
//        text_level = (TextView)findViewById(R.id.textView2);
        text_level = (TextView)findViewById(R.id.judul_level);
//        text_soalke = (TextView)findViewById(R.id.textView3);
        text_soalke = (TextView)findViewById(R.id.soal);
        text_soalnya = (TextView)findViewById(R.id.soalnya);
//        card_soal = (CardView)findViewById(R.id.card_soal);
        card_soal = (CardView)findViewById(R.id.card_soal);
        mBtnReset = (CardView)findViewById(R.id.button_reset);
        mBtnSend = (CardView)findViewById(R.id.button_send);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HurufBaruActivity.this, HurufLv1Activity.class);
                startActivity(i);
            }
        });
        mHurufPad = (SignaturePad)findViewById(R.id.huruf_pad);

        mHurufPad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                mBtnSend.setEnabled(true);
                mBtnReset.setEnabled(true);
            }

            @Override
            public void onClear() {
                mBtnSend.setEnabled(false);
                mBtnReset.setEnabled(false);
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHurufPad.clear();
            }
        });
    }
}