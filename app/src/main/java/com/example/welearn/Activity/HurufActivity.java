package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class HurufActivity extends AppCompatActivity {

    ImageView back, btn_sound, reset, send;
    TextView level, soal, soalnya;
    CardView isi_soal, button_reset, button_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf);

        back = (ImageView)findViewById(R.id.back);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        level = (TextView)findViewById(R.id.level);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
        isi_soal = (CardView)findViewById(R.id.isi_soal);
        button_reset = (CardView)findViewById(R.id.button_reset);
        button_send = (CardView)findViewById(R.id.button_send);

    }
}