package com.example.zoodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volControl = (SeekBar)findViewById(R.id.volumeBar);
        volControl.setMax(maxVolume);
        volControl.setProgress(curVolume);
        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });
    }


    public void onCheckboxClicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        Toast toast = null;

    }


}