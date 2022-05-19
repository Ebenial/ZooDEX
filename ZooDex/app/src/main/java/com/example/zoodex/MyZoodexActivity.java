package com.example.zoodex;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoodex.model.Animal;

import java.util.ArrayList;
import java.util.Arrays;

public class MyZoodexActivity extends Activity {
    private ArrayList<Animal> animals;
    private ZoodexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_zoodex_activity);

        this.animals = new ArrayList(Arrays.asList(
                new Animal(0, "Capybara", "Desc capy", null, null),
                new Animal(1, "Lion", "Desc lion", null, null, true),
                new Animal(2, "Dauphin", "Desc dauphin", null, null),
                new Animal(3, "Girafe", "Desc girafe", null, null, true)
        ));

        this.adapter = new ZoodexAdapter(this, R.layout.dex_animal_element, this.animals);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView gridAnimals = findViewById(R.id.gridAnimals);
        gridAnimals.setLayoutManager(layoutManager);
        gridAnimals.setAdapter(this.adapter);
    }
}
