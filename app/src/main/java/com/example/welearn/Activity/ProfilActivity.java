package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ProfilActivity extends AppCompatActivity {

    ImageView btn_back, account, logoutProfile;
    TextView title, username, email, jenis_kelamin, textView3, scorehuruf, scoreangka, textView4, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        btn_back = (ImageView)findViewById(R.id.btn_back);
        account = (ImageView)findViewById(R.id.account);
        logoutProfile = (ImageView)findViewById(R.id.logoutProfile);
        title = (TextView)findViewById(R.id.judul_level);
        username = (TextView)findViewById(R.id.username);
        email = (TextView)findViewById(R.id.email);
        jenis_kelamin = (TextView)findViewById(R.id.jenis_kelamin);
        textView3 = (TextView)findViewById(R.id.textView3);
        scorehuruf = (TextView)findViewById(R.id.scorehuruf);
        scoreangka = (TextView)findViewById(R.id.scoreangka);
        textView4 = (TextView)findViewById(R.id.textView4);
        logout = (TextView)findViewById(R.id.logout);
        logout.setOnClickListener(e -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
        new SweetAlertDialog(ProfilActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Keluar Aplikasi")
                .setContentText("Apakah ingin keluar Aplikasi")
                .setCancelText("Tidak")
                .setConfirmText("Iya")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        Constans.quit(ProfilActivity.this);
                        Constans.deleteCache(ProfilActivity.this);
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .show();
//            super.onBackPressed();
//        }
    }
}