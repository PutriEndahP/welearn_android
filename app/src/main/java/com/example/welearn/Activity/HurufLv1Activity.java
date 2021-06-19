package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponsePredict;
import com.example.welearn.Retrofit.ApiClientWelearn;
import com.example.welearn.Retrofit.ServerWelearn;
import com.example.welearn.Retrofit.TokenManager;
import com.williamww.silkysignature.views.SignaturePad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HurufLv1Activity extends AppCompatActivity {

    ImageView btn_back, btn_sound, reset, send;
    TextView title, soal, soalnya;
    CardView card_soal, mBtnReset, mBtnSend;
    SignaturePad mHurufPad, mHurufPad2, mHurufPad3;
    int id;
    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf_lv1);
        id = getIntent().getIntExtra("id",0);

        btn_back = (ImageView)findViewById(R.id.btn_back);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        title = (TextView)findViewById(R.id.judul_level);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
        card_soal = (CardView)findViewById(R.id.card_soal);
        mBtnReset = (CardView)findViewById(R.id.button_reset);
        mBtnSend = (CardView)findViewById(R.id.button_send);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HurufLv1Activity.this, HurufLv2Activity.class);
                startActivity(a);
            }
        });
        mHurufPad = (SignaturePad)findViewById(R.id.huruf_pad);
        mHurufPad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                mBtnSend.setEnabled(true);
                mBtnReset.setEnabled(true);
            }

            @Override
            public void onClear() {
                mBtnSend.setEnabled(false);
                mBtnReset.setEnabled(false);
            }
        });
        mHurufPad2 = (SignaturePad)findViewById(R.id.huruf_pad2);
        mHurufPad2.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                mBtnSend.setEnabled(true);
                mBtnReset.setEnabled(true);
            }

            @Override
            public void onClear() {
                mBtnSend.setEnabled(false);
                mBtnReset.setEnabled(false);
            }
        });
        mHurufPad3 = (SignaturePad)findViewById(R.id.huruf_pad3);
        mHurufPad3.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                mBtnSend.setEnabled(true);
                mBtnReset.setEnabled(true);
            }

            @Override
            public void onClear() {
                mBtnSend.setEnabled(false);
                mBtnReset.setEnabled(false);
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHurufPad.clear();
                mHurufPad2.clear();
                mHurufPad3.clear();
            }
        });

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getApplicationContext().getCacheDir(), "huruf");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap hurufBitmap = mHurufPad.getSignatureBitmap();
                Bitmap hurufBitmap2 = mHurufPad2.getSignatureBitmap();
                Bitmap hurufBitmap3 = mHurufPad3.getSignatureBitmap();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();

                hurufBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] bitmap_data = byteArrayOutputStream.toByteArray();
                hurufBitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                byte[] bitmap_data2 = byteArrayOutputStream2.toByteArray();
                hurufBitmap3.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream3);
                byte[] bitmap_data3 = byteArrayOutputStream3.toByteArray();

                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(bitmap_data);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String value = Base64.encodeToString(bitmap_data, Base64.DEFAULT); //image to base64
                String value2 = Base64.encodeToString(bitmap_data2, Base64.DEFAULT); //image to base64
                String value3 = Base64.encodeToString(bitmap_data3, Base64.DEFAULT); //image to base64
                ArrayList<String> valueList = new ArrayList<>();
                valueList.add(value);
                valueList.add(value2);
                valueList.add(value3);

                Log.e("listfoto", String.valueOf(valueList.size()));

                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), reqFile);

                tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                        Context.MODE_PRIVATE));
                ApiClientWelearn api = ServerWelearn.createService(ApiClientWelearn.class);
                Call<ResponsePredict> upload = api.predict(valueList,"9", "Bearer " + tokenManager.getToken());

                final SweetAlertDialog pDialog = new SweetAlertDialog(HurufLv1Activity.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Loading");
                pDialog.setCancelable(false);
                pDialog.show();

                upload.enqueue(new Callback<ResponsePredict>() {
                    @Override
                    public void onResponse(Call<ResponsePredict> call, Response<ResponsePredict> response) {
                        if (response.code() == 200) {
                            Log.e("response", response.body().getMessage());
                            pDialog.dismiss();
                            new SweetAlertDialog(HurufLv1Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText(response.body().getMessage())
                                    .setContentText("Berhasil Dikonfirmasi")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismissWithAnimation();

                                        }
                                    }).show();

                            mHurufPad.clear();
                            mHurufPad2.clear();
                            mHurufPad3.clear();
                            Intent intent = new Intent(HurufLv1Activity.this, HurufLv2Activity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                    } else {
                            pDialog.dismiss();
                            Log.e("testes", response.raw().toString());
                            new SweetAlertDialog(HurufLv1Activity.this, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Error")
                                    .setContentText("Terjadi kesalahan, mohon ulangi lagi.")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismissWithAnimation();
                                        }
                                    }).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponsePredict> call, Throwable t) {
                        Log.e("response", t.toString());
                        pDialog.dismiss();
                        new SweetAlertDialog(HurufLv1Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Hasil")
                                .setContentText("Internet Anda Bermasalah")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();
                                    }
                                }).show();
                    }
                });

            }
        });
    }
}