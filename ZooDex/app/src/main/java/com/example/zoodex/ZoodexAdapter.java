package com.example.zoodex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoodex.model.Animal;

public class ZoodexAdapter extends RecyclerView.Adapter<ZoodexAdapter.ViewHolder> {
    private Context context;
    private int resource;

    private Animal[] animals;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private ImageView imgAnimal;

        public ViewHolder(View v) {
            super(v);

            this.txtName = v.findViewById(R.id.txtAnimalName);
            this.imgAnimal = v.findViewById(R.id.imgAnimal);
        }

        public TextView getNameView() {
            return this.txtName;
        }

        public ImageView getImageView() {
            return this.imgAnimal;
        }
    }

    public ZoodexAdapter(Context context, int resource, Animal[] animals) {
        super();
        this.context = context;
        this.resource = resource;

        this.animals = animals;
    }

    @Override
    public ZoodexAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.resource, parent, false);

        return new ZoodexAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal a = this.animals[position];

        holder.getNameView().setText(a.getName());

        ImageView imgAnimal = holder.getImageView();
        if (a.isFound()) {
            imgAnimal.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            imgAnimal.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return this.animals.length;
    }
}
