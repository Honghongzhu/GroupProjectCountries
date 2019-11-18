package com.example.groupprojectcountries.play;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupprojectcountries.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {
    private List<Region> regionToAdapt;

    public void setData(ArrayList<Region> continentsToAdapt){
        this.regionToAdapt = continentsToAdapt;
    }

    @NonNull
    @Override
    public RegionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.region,parent, false);
        RegionViewHolder regionViewHolder = new RegionViewHolder(v);
        return regionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RegionViewHolder holder, int position) {
        final Region regionAtPosition = regionToAdapt.get(position);
        holder.bind(regionAtPosition);
    }

    @Override
    public int getItemCount() {
        return regionToAdapt.size();
    }

    public class RegionViewHolder extends RecyclerView.ViewHolder {
        private View view;
        //private ImageView regionImageView;
        private TextView nameTextView;

        public RegionViewHolder(@NonNull View v) {
            super(v);
            view = v;
            //regionImageView = v.findViewById(R.id.regionImage);
            nameTextView = v.findViewById(R.id.regionName);
        }

        public void bind(Region region) {
            nameTextView.setText(region.getName());
            //regionImageView.setImageResource();
            //TODO: view.setOnClickListener will redirect to new activity
        }
    }
}
