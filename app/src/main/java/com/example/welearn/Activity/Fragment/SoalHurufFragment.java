package com.example.welearn.Activity.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welearn.Activity.HurufBaruActivity;
import com.example.welearn.Activity.HurufLv1Activity;
import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponsePredict;
import com.example.welearn.Response.Api.ResponseSoal;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SoalHurufFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoalHurufFragment extends Fragment {

    ImageView btn_back, btn_sound, reset, send;
    TextView text_level, text_soalke, text_soalnya;
    CardView card_soal, mBtnReset, mBtnSend;
    SignaturePad mHurufPad;
    TokenManager tokenManager;
    ApiClientWelearn api;
    int id;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SoalHurufFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoalHurufFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoalHurufFragment newInstance(String param1, String param2) {
        SoalHurufFragment fragment = new SoalHurufFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_huruf, container, false);

        id = getActivity().getIntent().getIntExtra("id",0);

        btn_back = (ImageView)view.findViewById(R.id.btn_back);
        btn_sound = (ImageView)view.findViewById(R.id.btn_sound);
        reset = (ImageView)view.findViewById(R.id.reset);
        send = (ImageView)view.findViewById(R.id.send);
        text_level = (TextView)view.findViewById(R.id.judul_level);
        text_soalke = (TextView)view.findViewById(R.id.soal);
        text_soalnya = (TextView)view.findViewById(R.id.soalnya);

        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs",
                Context.MODE_PRIVATE));
//                ApiClientWelearn api = ServerWelearn.createServiceWithAuth(ApiClientWelearn.class, tokenManager);
        api = ServerWelearn.createService(ApiClientWelearn.class);
        Call<ResponseSoal<ArrayList<ListSoalHuruf>>> soal = api.getSoalHuruf("2", "Bearer " + tokenManager.getToken());

        soal.enqueue(new Callback<ResponseSoal<ArrayList<ListSoalHuruf>>>() {
            @Override
            public void onResponse(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Response<ResponseSoal<ArrayList<ListSoalHuruf>>> response) {
                if (response.code() == 200) {
                    Log.e("response get soal", response.body().getMessage().toString());

                } else {
                    Log.e("gagal get soal", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseSoal<ArrayList<ListSoalHuruf>>> call, Throwable t) {
                Log.e("Gagal", t.toString());
            }
        });



        card_soal = (CardView)view.findViewById(R.id.card_soal);
        mBtnReset = (CardView)view.findViewById(R.id.button_reset);
        mBtnSend = (CardView)view.findViewById(R.id.button_send);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HurufLv1Activity.class);
                startActivity(i);
            }
        });
        mHurufPad = (SignaturePad)view.findViewById(R.id.huruf_pad);

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

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHurufPad.clear();
            }
        });

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getActivity().getApplicationContext().getCacheDir(), "huruf");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap hurufBitmap = mHurufPad.getSignatureBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                hurufBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                String value = Base64.encodeToString(bitmap_data, Base64.DEFAULT);
                ArrayList<String> valueList = new ArrayList<>();
                valueList.add(value);

                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), reqFile);

                Call<ResponsePredict> upload = api.predict(valueList,"11", "Bearer " + tokenManager.getToken());
//                Log.e("response", tokenManager.getToken());
//                Log.e("response", valueList.toArray().toString());

                final SweetAlertDialog pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
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
                            new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
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
                            Intent intent = new Intent(getActivity(), HurufLv1Activity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                        } else {
                            pDialog.dismiss();
                            Log.e("testes", response.raw().toString());
                            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
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
                        new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
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


//        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_soal_huruf, container, false);
        return view;

//        return inflater.inflate(R.layout.fragment_soal_huruf, container, false);
    }


}