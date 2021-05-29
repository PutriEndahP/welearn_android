package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class CryActivity extends AppCompatActivity {

    ImageView pict_cry, prev, next;
    CardView btn_prev, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cry);
        pict_cry = (ImageView)findViewById(R.id.pict_cry);
        prev = (ImageView)findViewById(R.id.prev);
        next = (ImageView)findViewById(R.id.next);
        btn_prev = (CardView)findViewById(R.id.button_prev);
        btn_next = (CardView)findViewById(R.id.button_next);
    }
}