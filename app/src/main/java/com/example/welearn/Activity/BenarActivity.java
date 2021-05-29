package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class BenarActivity extends AppCompatActivity {

    ImageView pict_smile, prev, next;
    TextView jwbn_benar;
    CardView btn_prev, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benar);
        pict_smile = (ImageView)findViewById(R.id.pict_smile);
        prev = (ImageView)findViewById(R.id.prev);
        next = (ImageView)findViewById(R.id.next);
//        jwbn_benar = (TextView)findViewById(R.id.smile);
        btn_prev = (CardView)findViewById(R.id.button_prev);
        btn_next = (CardView)findViewById(R.id.button_next);
    }
}