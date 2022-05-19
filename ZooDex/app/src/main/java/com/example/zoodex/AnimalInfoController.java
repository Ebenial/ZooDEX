package com.example.zoodex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class AnimalInfoController extends AppCompatActivity {

    private ImageView animalPicture;
    private TextView title;
    private TextView desc;
    private Toolbar navBar;
    private MediaPlayer mediaPlayer;
    private Button takePhotoButton;

    AnimalInfoController(Bundle savedInstanceState/*Animal animal*/){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info_activity);

        this.animalPicture = findViewById(R.id.animalPicture);
        this.title = findViewById(R.id.titleAnimal);
        this.desc = findViewById(R.id.descAnimal);
        this.navBar = findViewById(R.id.navBar);
        //this.mediaPlayer = MediaPlayer.create(this, animal.getSound());

        /*this.animalPicture.setBackgroundResource(animal.getImageSource());
        this.title.setText(animal.getName());
        this.desc.setText(animal.getDesc());
        this.navBar.setBackgroundColor(animal.getColor());*/
    }

    public void reTakePhoto(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 1);
        }else{
            Toast.makeText(this, "Impossible de prendre une photo, aucune application ne le permet", Toast.LENGTH_SHORT).show();
        }
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
            Intent intent = new Intent(this, this.getClass());
            intent.putExtra("photo", byteArray);
            startActivity(intent);
        }
    }


    public void sound(View v){
        mediaPlayer.start();
    }

}
