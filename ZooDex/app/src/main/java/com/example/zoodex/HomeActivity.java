package com.example.zoodex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button photo = (Button) findViewById(R.id.photo);
        Button bestiaire = (Button) findViewById(R.id.zoodex);
        Button options = (Button) findViewById(R.id.options);

        //Action du bouton photo, qui permet de donner accès à la caméra pour prendre une photo
        photo.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(intent, 1);
            }else{
                Toast.makeText(HomeActivity.this, "Impossible de prendre une photo, aucune application ne le permet", Toast.LENGTH_SHORT).show();
            }
        });

        //Action du bouton bestiaire, qui donne l'accès au zoodex
        bestiaire.setOnClickListener(view -> {
            //setContentView(R.layout.dexlist_activity);
        });

        //Action du bouton options, qui donne accès aux paramètres de l'application
        options.setOnClickListener(v -> {
            setContentView(R.layout.activity_options);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            //On récupère la photo prise avec l'appareil photo
            Bundle bundle = data.getExtras();
            Bitmap finalPhoto = (Bitmap) bundle.get("data");

            //On compresse la photo et on la passe à la classe ChoicePhoto
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            finalPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            Intent intent = new Intent(this, ChoicePhoto.class);
            intent.putExtra("photo", byteArray);
            startActivity(intent);
        }
    }
}