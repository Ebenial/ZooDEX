package com.example.zoodex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoodex.model.Animal;

import java.util.ArrayList;
import java.util.Arrays;

public class MyZoodexActivity extends Activity {
    private ArrayList<Animal> allAnimals;
    private ArrayList<Animal> selectedAnimals;

    private ZoodexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_zoodex_activity);

        this.allAnimals = new ArrayList<Animal>(Arrays.asList(
                new Animal(0, "Capybara", "Desc capy", null, null),
                new Animal(1, "Lion", "Desc lion", null, null, true),
                new Animal(2, "Dauphin", "Desc dauphin", null, null),
                new Animal(3, "Girafe", "Desc girafe", null, null)
        ));
        this.selectedAnimals = new ArrayList<>(this.allAnimals);

        this.adapter = new ZoodexAdapter(this, R.layout.dex_animal_element, this.selectedAnimals);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView gridAnimals = findViewById(R.id.gridAnimals);
        gridAnimals.setLayoutManager(layoutManager);
        gridAnimals.setAdapter(this.adapter);

        // Buttons
        RadioButton rdShowAll = findViewById(R.id.rdShowAll);
        rdShowAll.setOnClickListener(e -> this.showAll());

        RadioButton rdShowFound = findViewById(R.id.rdShowFound);
        rdShowFound.setOnClickListener(e -> this.showFound());

        RadioButton rdShowNotFound = findViewById(R.id.rdShowNotFound);
        rdShowNotFound.setOnClickListener(e -> this.showNotFound());
    }

    private void showAll() {
        this.selectedAnimals.clear();
        for (Animal a : this.allAnimals) {
            this.selectedAnimals.add(a);
        }

        this.adapter.notifyDataSetChanged();
    }

    private void showFound() {
        this.selectedAnimals.clear();
        for (Animal a : this.allAnimals) {
            if (a.isFound()) {
                this.selectedAnimals.add(a);
            }
        }

        this.adapter.notifyDataSetChanged();
    }

    private void showNotFound() {
        this.selectedAnimals.clear();
        for (Animal a : this.allAnimals) {
            if (!a.isFound()) {
                this.selectedAnimals.add(a);
            }
        }

        this.adapter.notifyDataSetChanged();
    }
}
