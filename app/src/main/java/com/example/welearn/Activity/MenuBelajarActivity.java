package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

public class MenuBelajarActivity extends AppCompatActivity {

    TextView title;
    CardView btn_huruf, btn_angka, btn_aksara;
    ImageView score, akun, pembatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_belajar);
        title = (TextView)findViewById(R.id.judul);
        btn_huruf = (CardView)findViewById(R.id.btn_huruf);
        btn_huruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuBelajarActivity.this, LevelHurufActivity.class);
                startActivity(i);
            }
        });
        btn_angka = (CardView)findViewById(R.id.btn_angka);
        btn_angka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MenuBelajarActivity.this, AngkaLv0aActivity.class);
                startActivity(k);
            }
        });

        score = (ImageView)findViewById(R.id.score);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MenuBelajarActivity.this, SkorActivity.class);
                startActivity(j);
            }
        });

        btn_aksara = (CardView)findViewById(R.id.btn_aksara);
        btn_aksara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MenuBelajarActivity.this, SoalAksaraActivity.class);
                startActivity(j);
            }
        });


    }
}