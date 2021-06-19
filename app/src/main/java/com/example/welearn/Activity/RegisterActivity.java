package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class RegisterActivity extends AppCompatActivity {

    TextView title;
    CardView cardView, cardView1, cardView2, cardView3, cardView4, cardView6;
    EditText name, username, email, password, jenis_kelamin;
    TokenManager tokenManager;
//    ProgressBar loading;
//    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        title = (TextView)findViewById(R.id.judul);
        cardView = (CardView)findViewById(R.id.card_nama);
        cardView1 = (CardView)findViewById(R.id.card_username);
        cardView2 = (CardView)findViewById(R.id.card_email);
        cardView3 = (CardView)findViewById(R.id.card_password);
        cardView4 = (CardView)findViewById(R.id.card_jeniskelamin);
//        cardView5 = (CardView)findViewById(R.id.card_tgllahir);
        cardView6 = (CardView)findViewById(R.id.btn_register);

        name = findViewById(R.id.register_nama);
        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        jenis_kelamin = findViewById(R.id.register_jeniskelamin);

        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                Context.MODE_PRIVATE));
        cardView6.setOnClickListener(e -> {
            register();
        });
//        cardView6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });
    }

    protected void register() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.show();

        ApiClientWelearn api = ServerWelearn.createService(ApiClientWelearn.class);
        Call<AccessToken> register = api.register(email.getText().toString(), password.getText().toString(), name.getText().toString(), username.getText().toString(), jenis_kelamin.getText().toString());
        register.enqueue(new Callback<AccessToken>() {

            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.code() == 201) {
//                    tokenManager.saveToken(response.body());
                    new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Register Berhasil")
                            .setContentText("Data Tersimpan")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            }).show();
//                    finish();
                } else {
                    Log.e("gagal register", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                pDialog.dismiss();
                new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.ERROR_TYPE)
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

}