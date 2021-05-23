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

public class RegisterActivity extends AppCompatActivity {

    TextView title;
    CardView cardView, cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;
    EditText nama, username, email, password, konfirm_pass, tgl_lahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        title = (TextView)findViewById(R.id.judul);
        cardView = (CardView)findViewById(R.id.card_nama);
        cardView1 = (CardView)findViewById(R.id.card_username);
        cardView2 = (CardView)findViewById(R.id.card_email);
        cardView3 = (CardView)findViewById(R.id.card_password);
        cardView4 = (CardView)findViewById(R.id.card_konfirmasi_password);
        cardView5 = (CardView)findViewById(R.id.card_tgl_lahir);
        cardView6 = (CardView)findViewById(R.id.btn_register);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}