package com.example.welearn.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.welearn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import darren.googlecloudtts.BuildConfig;
import darren.googlecloudtts.GoogleCloudTTS;
import darren.googlecloudtts.GoogleCloudTTSFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SoalAksaraActivity extends AppCompatActivity {
    private static final String TAG = "MSoalAksaraActivity";

    ImageView back, btn_sound, reset, send;
    TextView soal, soalnya;

    @BindView(R.id.btnIdSpeak)
    Button mButtonSpeak;

//    private TTSViewModel mMainViewModel;
    public MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_aksara);

        ButterKnife.bind(this);
//        initViewValues();

        GoogleCloudTTS googleCloudTTS = GoogleCloudTTSFactory.create(BuildConfig.API_KEY);
        mMainViewModel = new MainViewModel(getApplication(), googleCloudTTS);

//        onLoading();

//        btnIdSpeak = (ImageView)findViewById(R.id.btnIdSpeak);

        back = (ImageView)findViewById(R.id.back);
        btn_sound = (ImageView)findViewById(R.id.btn_sound);
        reset = (ImageView)findViewById(R.id.reset);
        send = (ImageView)findViewById(R.id.send);
        soal = (TextView)findViewById(R.id.soal);
        soalnya = (TextView)findViewById(R.id.soalnya);
    }

    private void makeToast(String text, boolean longShow) {
        Toast.makeText(this, text, (longShow) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnIdSpeak)
    void onSpeak() {
        mMainViewModel.speak("Tuliskan huruf ha")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(t -> initTTSVoice())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        makeToast("Speak success", false);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        makeToast("Speak failed " + e.getMessage(), true);
                        Log.e(TAG, "Speak failed", e);
                    }
                });
    }

    SeekBar mSeekBarPitch;
    private int getProgressPitch() {
        return mSeekBarPitch.getProgress();
    }

    SeekBar mSeekBarSpeakRate;
    private int getProgressSpeakRate() {
        return mSeekBarSpeakRate.getProgress();
    }

    private void initTTSVoice() {
        String languageCode = "id-ID";
        String voiceName = "id-ID-Wavenet-A";
        float pitch = ((float) (getProgressPitch() - 2000) / 100);
        float speakRate = ((float) (getProgressSpeakRate() + 25) / 100);

        mMainViewModel.initTTSVoice(languageCode, voiceName, pitch, speakRate);
    }
}