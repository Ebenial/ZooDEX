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

        switch (v.getId()) {
            case R.id.vibrationBox:
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
                if(checked) {
                    long[] pattern = {10, 10};
                VibrationEffect vibrationEffect1 = VibrationEffect.createOneShot(500, 5);
                    vibe.vibrate(vibrationEffect1);
                    Toast.makeText(getApplicationContext(), "Vibration activ??", Toast.LENGTH_LONG).show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Vibration d??sactiv??", Toast.LENGTH_LONG);
                    vibe.cancel();
                }
                break;
            case R.id.daltonienBox:
                if(checked) {
                    Toast.makeText(getApplicationContext(), "Mode Daltonien activ??", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Mode Daltonien d??sactiv??", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.notificationBox:
                if(checked) {
                    Toast.makeText(getApplicationContext(), "Notifications activ??", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Notifications d??sactiv??", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDelete:
                Toast.makeText(getApplicationContext(), "Donn??es supprim??es", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonMDP:
                Toast.makeText(getApplicationContext(), "Mot de passe chang??", Toast.LENGTH_LONG).show();
                break;
            case R.id.creditText:
                Toast.makeText(getApplicationContext(), "Ont travaill?? sur le projet : l'??quipe rose ainsi que leur volont?? de r??ussir et d'aller loin dans la vie", Toast.LENGTH_LONG).show();
                break;
        }
    }

}