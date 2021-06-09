package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.welearn.MainActivity;
import com.example.welearn.R;
import com.example.welearn.Retrofit.AccessToken;
import com.example.welearn.Retrofit.ApiClientWelearn;
import com.example.welearn.Retrofit.ServerWelearn;
import com.example.welearn.Retrofit.TokenManager;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView title, textView, textRegister;
    CardView cardView, cardView1, cardView2;
    EditText username, password;
    TokenManager tokenManager;
//    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));

        title = (TextView)findViewById(R.id.judul);
        textView = (TextView)findViewById(R.id.textView);
        textRegister = (TextView)findViewById(R.id.register);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(j);
            }
        });
        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);
        cardView = (CardView)findViewById(R.id.card_username);
        cardView1 = (CardView)findViewById(R.id.card_password);
        cardView2 = (CardView)findViewById(R.id.btn_login);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                Context.MODE_PRIVATE));
//        btnLogin = (Button) findViewById(R.id.btn_login);
        cardView2.setOnClickListener(e -> {
            login();
        });
//        cardView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, MenuBelajarActivity.class);
//                startActivity(i);
//            }
//        });
    }

    protected void login() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.show();
//        Constans.setNip("05111740000015");
//        Constans.setNama("kiki");
//        Constans.setPassword("qwe123");
//        Constans.setToken("12345678");

        ApiClientWelearn api = ServerWelearn.createService(ApiClientWelearn.class);
        Call<AccessToken> login = api.login(username.getText().toString().trim(), password.getText().toString().trim());
        login.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                pDialog.dismiss();
//                Log.e("response", response.body().getMessage().getToken().toString());
                if (response.code() == 200) {
                    tokenManager.saveToken(response.body());
                    Intent intent = new Intent(LoginActivity.this, MenuBelajarActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Login Gagal")
                            .setContentText("Password Atau Username Anda Salah")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismiss();
                                }
                            }).show();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
//                System.out.print( "=====" +call.toString());
//                System.out.print( "=====" +t.toString());
                pDialog.dismiss();
                new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Internet")
                        .setContentText("Internet Anda bermasalah")
                        .setConfirmText("OK")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        }).show();
            }
        });
    }

    View.OnClickListener action = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_login:
                  Log.d("btn","mulai klik");
                    login();

//                    final SweetAlertDialog pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                    pDialog.setTitleText("Loading");
//                    pDialog.show();
//                    ApiClientSIPKS api = ServerSIPKS.builder(LoginActivity.this).create(ApiClientSIPKS.class);
//                    Call<ResponseLogin> login = api.login(email.getText().toString().trim(),password.getText().toString().trim());
//                    login.enqueue(new Callback<ResponseLogin>() {
//                        @Override
//                        public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
//                            pDialog.dismiss();
//                            if(response.code()==200)
//                            {
////                                Log.d("btn","ini sukses");
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                            else
//                            {
//
//                                new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
//                                        .setTitleText("Login Gagal")
//                                        .setContentText("Password Atau Username Anda Salah")
//                                        .setConfirmText("OK")
//                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                            @Override
//                                            public void onClick(SweetAlertDialog sDialog) {
//                                                sDialog.dismiss();
//                                            }
//                                        }).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseLogin> call, Throwable t) {
//                            System.out.print( "=====" +call.toString());
//                            t.toString();
//                            Log.d("TAG", "onFailure: Disini kerja");
//                            pDialog.dismiss();
//                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
//                                    .setTitleText("Internet")
//                                    .setContentText("Internet Anda bermasalah")
//                                    .setConfirmText("OK")
//                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                        @Override
//                                        public void onClick(SweetAlertDialog sDialog) {
//                                            sDialog.dismiss();
//                                        }
//                                    }).show();
//                            Log.d("btn","ini gagal");
//                        }
//                    });
                    break;

            }
        }
    };


}