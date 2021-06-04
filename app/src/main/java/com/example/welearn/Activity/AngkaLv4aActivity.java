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

public class AngkaLv4aActivity extends AppCompatActivity {

    ImageView back, speaker, resetangka, submit;
    TextView levelangka, soalangka, soalnya, samadengan, tambah;
    CardView card_soalangka, card_reset, card_submit, card_soalangka1, card_soalangka2;
    SignaturePad padjawabangka1, padjawabangka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka_lv4a);
        back = (ImageView) findViewById(R.id.back);
        speaker = (ImageView) findViewById(R.id.speaker);
        resetangka = (ImageView) findViewById(R.id.resetangka);
        submit = (ImageView) findViewById(R.id.submit);
        levelangka = (TextView) findViewById(R.id.levelangka);
        soalangka = (TextView) findViewById(R.id.soalangka);
        soalnya = (TextView) findViewById(R.id.soalnya);
        tambah = (TextView) findViewById(R.id.tambah);
        samadengan = (TextView) findViewById(R.id.samadengan);
        card_soalangka = (CardView) findViewById(R.id.card_soalangka);
        card_reset = (CardView) findViewById(R.id.card_reset);
        card_submit = (CardView) findViewById(R.id.card_submit);
        card_soalangka1 = (CardView)findViewById(R.id.card_soalangka1);
        card_soalangka2 = (CardView)findViewById(R.id.card_soalangka2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AngkaLv4aActivity.this, AngkaLv4bActivity.class);
                startActivity(i);
            }
        });
        padjawabangka1 = (SignaturePad) findViewById(R.id.padjawabangka1);
        padjawabangka2 = (SignaturePad) findViewById(R.id.padjawabangka2);
    }
}