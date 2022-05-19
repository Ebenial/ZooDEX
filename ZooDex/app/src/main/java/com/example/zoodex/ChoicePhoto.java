package com.example.zoodex;

import android.annotation.SuppressLint;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ChoicePhoto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicephoto_activity);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ImageView image = findViewById(R.id.photo);
        Button bestiaire = findViewById(R.id.zoodexButton);

        //On récupère la photo prise et on l'affiche dans la zone prévue
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("photo");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image.setImageBitmap(bmp);

        //Action du bouton "Chercher dans le zoodex", qui amène sur la liste des animaux non découverts pour sélectionner l'animal correspondant
        bestiaire.setOnClickListener(view -> {
            //setContentView(R.layout.dexlist_activity);
        });
    }
}