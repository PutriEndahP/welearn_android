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

public class SoalAngkaLv1cActivity extends AppCompatActivity {

    ImageView back, speaker, resetangka, submit;
    TextView levelangka, soalangka, soalnya, samadengan, kurang;
    CardView card_soalangka, card_reset, card_submit;
    SignaturePad padsoalangka1, padsoalangka2, padjawabangka1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_angka_lv1c);
        back = (ImageView)findViewById(R.id.back);
        speaker = (ImageView)findViewById(R.id.speaker);
        resetangka = (ImageView)findViewById(R.id.resetangka);
        submit = (ImageView)findViewById(R.id.submit);
        levelangka = (TextView)findViewById(R.id.levelangka);
        soalangka = (TextView)findViewById(R.id.soalangka);
        soalnya = (TextView)findViewById(R.id.soalnya);
        samadengan = (TextView)findViewById(R.id.samadengan);
        kurang = (TextView)findViewById(R.id.kurang);
        card_soalangka = (CardView)findViewById(R.id.card_soalangka);
        card_reset = (CardView)findViewById(R.id.card_reset);
        card_submit = (CardView)findViewById(R.id.card_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SoalAngkaLv1cActivity.this, SoalAngkaLv4bActivity.class);
                startActivity(i);
            }
        });
        padsoalangka1 = (SignaturePad)findViewById(R.id.padsoalangka1);
        padsoalangka2 = (SignaturePad)findViewById(R.id.padsoalangka2);
        padjawabangka1 = (SignaturePad)findViewById(R.id.padjawabangka1);
    }
}