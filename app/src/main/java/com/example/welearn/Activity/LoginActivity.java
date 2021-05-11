package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;

public class LoginActivity extends AppCompatActivity {

    TextView title;
    CardView cardView, cardView1, cardView2;
    EditText username, password;
//    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        title = (TextView)findViewById(R.id.judul);
        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);
        cardView = (CardView)findViewById(R.id.card_username);
        cardView1 = (CardView)findViewById(R.id.card_password);
        cardView2 = (CardView)findViewById(R.id.btn_login);
//        btnLogin = (Button) findViewById(R.id.btn_login);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}