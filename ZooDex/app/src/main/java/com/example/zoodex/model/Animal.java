package com.example.zoodex.model;

public class Animal {
    private static int globalId = 0;
    private int id;

    private String name;
    private String description;
    private String picturePath;
    private String soundPath;

    private boolean found;

    public Animal(int id, String name, String description, String picturePath, String soundPath) {
        this.id = id;

        this.name = name;
        this.description = description;
        this.picturePath = picturePath;
        this.soundPath = soundPath;

        this.found = false;
    }

    public Animal(String name, String description, String picturePath, String soundPath) {
        this(0, name, description, picturePath, soundPath);
    }

    public static Animal createAnimal(String name, String description, String picturePath, String soundPath) {
        globalId++;
        Animal a = new Animal(globalId, name, description, picturePath, soundPath);

        return a;
    }
}
