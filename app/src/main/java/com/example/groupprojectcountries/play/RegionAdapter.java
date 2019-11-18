package com.example.groupprojectcountries.play;

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

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.ContinentViewHolder> {
    private List<Region> continentsToAdapt;

    public void setData(ArrayList<Region> continentsToAdapt){
        this.continentsToAdapt = continentsToAdapt;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.region,parent, false);
        ContinentViewHolder continentViewHolder = new ContinentViewHolder(v);
        return continentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        final Region regionAtPosition = continentsToAdapt.get(position);
        holder.bind(regionAtPosition);
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

        public void bind(Region region) {
            nameTextView.setText(region.getName());
            String imageUrl = region.getImageUrl();
            Glide.with(view.getContext()).load(imageUrl).into(continentImageView);
            //TODO: view.setOnClickListener will redirect to new activity
        }
    }
}
