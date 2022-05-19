package com.example.zoodex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.zoodex.model.Animal;

public class MyZoodexActivity extends Activity {
    private Animal[] animals;
    private ZoodexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_zoodex_activity);

        this.animals = new Animal[] {
                new Animal(0, "Capybara", "Desc capy", null, null),
                new Animal(1, "Lion", "Desc lion", null, null, true),
                new Animal(2, "Dauphin", "Desc dauphin", null, null),
                new Animal(3, "Girafe", "Desc girafe", null, null, true)
        };

        this.adapter = new ZoodexAdapter(this, R.layout.dex_animal_element, this.animals);
        GridView gridAnimals = findViewById(R.id.gridAnimals);
        gridAnimals.setAdapter(this.adapter);
    }
}
