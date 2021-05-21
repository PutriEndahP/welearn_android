
package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;

public class ProfileActivity extends AppCompatActivity {

    TextView profile, nama, namaProfile, score, scoreProfile, logout;
    CardView card_nmProfile, card_score, card_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile = (TextView) findViewById(R.id.profile);
        nama = (TextView) findViewById(R.id.nama);
        namaProfile = (TextView) findViewById(R.id.namaProfile);
        score = (TextView) findViewById(R.id.score);
        scoreProfile = (TextView) findViewById(R.id.scoreProfile);
        logout = (TextView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        card_nmProfile = (CardView) findViewById(R.id.card_nmProfile);
        card_score = (CardView) findViewById(R.id.card_score);
        card_logout = (CardView) findViewById(R.id.card_logout);
//        btnLogin = (Button) findViewById(R.id.btn_login);
        card_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(j);
            }
        });
    }
}