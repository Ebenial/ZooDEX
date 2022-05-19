package com.example.zoodex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zoodex.model.Animal;

public class ZoodexAdapter extends ArrayAdapter<Animal> {
    private Context context;
    private int resource;

    public ZoodexAdapter(Context context, int resource, Animal[] animals) {
        super(context, resource, animals);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = getItem(position);
        String name = animal.getName();
        boolean found = animal.isFound();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        TextView txtName = convertView.findViewById(R.id.txtAnimalName);
        ImageView imgAnimal = convertView.findViewById(R.id.imgAnimal);

        txtName.setText(name);
        if (found) {
            imgAnimal.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            imgAnimal.setImageResource(R.drawable.ic_launcher_background);
        }

        return convertView;
    }
}
