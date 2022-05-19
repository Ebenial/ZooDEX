package com.example.zoodex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

public class DiscoveryActivity extends AppCompatActivity {


    @SuppressLint("RestrictedApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_activity);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        Button locate = (Button) findViewById(R.id.locateToto);
        locate.setOnClickListener(view -> {
            setContentView(R.layout.activity_options);
        });
    }


}