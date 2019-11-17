package com.example.groupprojectcountries.Play;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.groupprojectcountries.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {
    private List<Continent> continentsToAdapt;

    public void setData(ArrayList<Continent> continentsToAdapt){
        this.continentsToAdapt = continentsToAdapt;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.continent,parent, false);
        ContinentViewHolder continentViewHolder = new ContinentViewHolder(v);
        return continentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        final Continent continentAtPosition = continentsToAdapt.get(position);
        holder.bind(continentAtPosition);
    }

    @Override
    public int getItemCount() {
        return continentsToAdapt.size();
    }

    public class ContinentViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView continentImageView;
        private TextView nameTextView;

        public ContinentViewHolder(@NonNull View v) {
            super(v);
            view = v;
            continentImageView = v.findViewById(R.id.continentImage);
            nameTextView = v.findViewById(R.id.continentName);
        }

        public void bind(Continent continent) {
            nameTextView.setText(continent.getName());
            String imageUrl = continent.getImageUrl();
            Glide.with(view.getContext()).load(imageUrl).into(continentImageView);
            //TODO: view.setOnClickListener will redirect to new activity
        }
    }
}
