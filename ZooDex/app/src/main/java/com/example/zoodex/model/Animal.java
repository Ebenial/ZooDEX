package com.example.zoodex.model;

import android.net.Uri;

import java.net.URI;

public class Animal {
    private static int globalId = 0;
    private int id;

    private String name;
    private String description;
    private Uri picturePath;
    private Uri soundPath;

    private boolean found;

    public Animal(int id, String name, String description, Uri picturePath, Uri soundPath, boolean found) {
        this.id = id;

        this.name = name;
        this.description = description;
        this.picturePath = picturePath;
        this.soundPath = soundPath;

        this.found = found;
    }

    public Animal(int id, String name, String description, Uri picturePath, Uri soundPath) {
        this(id, name, description, picturePath, soundPath, false);
    }

    public Animal(String name, String description, Uri picturePath, Uri soundPath) {
        this(0, name, description, picturePath, soundPath);
    }

    public static Animal createAnimal(String name, String description, Uri picturePath, Uri soundPath) {
        globalId++;
        Animal a = new Animal(globalId, name, description, picturePath, soundPath);

        return a;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isFound() {
        return this.found;
    }
}
