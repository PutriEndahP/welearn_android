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

public class AngkaLv12Activity extends AppCompatActivity {

    ImageView back, speaker, resetangka, submit;
    TextView levelangka, soalangka, soalnya, samadengan, tambah;
    CardView card_soalangka, card_reset, card_submit, card_soalangka1, card_soalangka2;
    SignaturePad padjawabangka1;
    TokenManager tokenManager;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka_lv12);
        id = getIntent().getIntExtra("id",0);
        back = (ImageView)findViewById(R.id.back);
        speaker = (ImageView)findViewById(R.id.speaker);
        resetangka = (ImageView)findViewById(R.id.resetangka);
        submit = (ImageView)findViewById(R.id.submit);
        levelangka = (TextView)findViewById(R.id.levelangka);
        soalangka = (TextView)findViewById(R.id.soalangka);
        soalnya = (TextView)findViewById(R.id.soalnya);
        tambah = (TextView)findViewById(R.id.tambah);
        samadengan = (TextView)findViewById(R.id.samadengan);
        card_soalangka = (CardView)findViewById(R.id.card_soalangka);
        card_reset = (CardView)findViewById(R.id.card_reset);
        card_submit = (CardView)findViewById(R.id.card_submit);
        card_soalangka1 = (CardView)findViewById(R.id.card_soalangka1);
        card_soalangka2 = (CardView)findViewById(R.id.card_soalangka2);
        padjawabangka1 = (SignaturePad) findViewById(R.id.padjawabangka1);

        padjawabangka1 = (SignaturePad) findViewById(R.id.padjawabangka1);

        padjawabangka1.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                card_submit.setEnabled(true);
                card_reset.setEnabled(true);
            }

            @Override
            public void onClear() {
                card_submit.setEnabled(false);
                card_reset.setEnabled(false);
            }
        });

        card_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                padjawabangka1.clear();
            }
        });
        card_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getApplicationContext().getCacheDir(), "angka");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap angkaBitmap = padjawabangka1.getTransparentSignatureBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                angkaBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] bitmap_data = byteArrayOutputStream.toByteArray();

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
                ArrayList<String> valueList = new ArrayList<>();
                valueList.add(value);

                Log.e("listfoto", String.valueOf(valueList.size()));

                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), reqFile);

                tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",
                        Context.MODE_PRIVATE));
                ApiClientWelearn api = ServerWelearn.createService(ApiClientWelearn.class);
                Call<ResponsePredict> upload = api.predictangka(valueList,"9", "Bearer " + tokenManager.getToken());

                final SweetAlertDialog pDialog = new SweetAlertDialog(AngkaLv12Activity.this, SweetAlertDialog.PROGRESS_TYPE);
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
                            new SweetAlertDialog(AngkaLv12Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText(response.body().getMessage())
                                    .setContentText("Berhasil Dikonfirmasi")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismissWithAnimation();

                                        }
                                    }).show();

                            padjawabangka1.clear();
                            Intent intent = new Intent(AngkaLv12Activity.this, AngkaLv13Activity.class); //coba coba
                            intent.putExtra("id", id);
                            startActivity(intent);
                        } else {
                            pDialog.dismiss();
                            Log.e("testes", response.raw().toString());
                            new SweetAlertDialog(AngkaLv12Activity.this, SweetAlertDialog.WARNING_TYPE)
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
                        new SweetAlertDialog(AngkaLv12Activity.this, SweetAlertDialog.ERROR_TYPE)
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