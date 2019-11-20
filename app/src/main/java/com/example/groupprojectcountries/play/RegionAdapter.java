package com.example.groupprojectcountries.play;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
        private TextView nameTextView;

        public RegionViewHolder(@NonNull View v) {
            super(v);
            view = v;
            nameTextView = v.findViewById(R.id.regionName);
        }

        //When user clicks on a region, the next CapFlagActivity will appear.
        public void bind(final Region region) {
            nameTextView.setText(region.getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context =  v.getContext();
                    Intent intent = new Intent(context, CapFlagActivity.class);
                    intent.putExtra("REGION", region.getName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
