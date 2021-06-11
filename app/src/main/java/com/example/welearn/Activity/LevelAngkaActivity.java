package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

import org.w3c.dom.Text;

public class LevelAngkaActivity extends AppCompatActivity {

    ImageView icon0, icon1, icon2, icon3, icon4, btn_back;
    TextView lev0, lev1, lev2, lev3, lev4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_angka);

        icon0 = (ImageView) findViewById(R.id.icon0);
        icon0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LevelAngkaActivity.this, AngkaLv0aActivity.class);
                startActivity(i);
            }
        });

        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LevelAngkaActivity.this, MenuBelajarActivity.class);
                startActivity(i);
            }
        });
    }
}