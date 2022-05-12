package com.example.zoodex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ChoicePhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicephoto_activity);

        ImageView image = findViewById(R.id.photo);

        //On récupère la photo prise et on l'affiche dans la zone prévue
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("photo");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image.setImageBitmap(bmp);
    }
}