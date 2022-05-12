package com.example.zoodex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalInfoController extends AppCompatActivity {

    private ImageView animalPicture;
    private TextView title;
    private TextView desc;
    private Toolbar navBar;
    private VideoView photoView;
    private MediaPlayer mediaPlayer;

    AnimalInfoController(Bundle savedInstanceState/*Animal animal*/){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info_activity);

        this.animalPicture = findViewById(R.id.animalPicture);
        this.title = findViewById(R.id.titleAnimal);
        this.desc = findViewById(R.id.descAnimal);
        this.navBar = findViewById(R.id.navBar);
        this.photoView = findViewById(R.id.photoView);
        //this.mediaPlayer = MediaPlayer.create(this, animal.getSound());

        /*this.animalPicture.setBackgroundResource(animal.getImageSource());
        this.title.setText(animal.getName());
        this.desc.setText(animal.getDesc());
        this.navBar.setBackgroundColor(animal.getColor());*/
    }

    public void reTakePhoto(View v){
        photoView.setVisibility(View.VISIBLE);
    }

    public void sound(View v){
        mediaPlayer.start();
    }

}
