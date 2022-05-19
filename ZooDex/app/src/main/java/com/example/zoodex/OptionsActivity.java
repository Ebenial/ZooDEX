package com.example.quiperoselocalquimarche;

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
                    //VibrationEffect vibrationEffect1 = VibrationEffect.createWaveform(pattern, 0);
                    //vibe.vibrate(vibrationEffect1);
                    Toast toast = Toast.makeText(getApplicationContext(), "Vibration activé", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Vibration désactivé", Toast.LENGTH_LONG);
                    toast.show();
                    vibe.cancel();
                }
                break;
            case R.id.daltonienBox:
                if(checked) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Mode daltonien activé", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Mode daltonien activé", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
            case R.id.notificationBox:
                if(checked) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Notifications activé", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Notifications activé", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDelete:
                Toast toast = Toast.makeText(getApplicationContext(), "Données supprimées", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.buttonMDP:
                Toast toast = Toast.makeText(getApplicationContext(), "Mot de passe changé", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.creditText:
                Toast toast = Toast.makeText(getApplicationContext(), "Ont travaillé sur le projet : l'équipe rose ainsi que leur volonté de réussir et d'aller loin dans la vie", Toast.LENGTH_LONG);
                toast.show();
                break;
        }
    }


}