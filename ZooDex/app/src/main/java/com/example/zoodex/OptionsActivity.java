package com.example.zoodex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
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
}