package com.example.groupprojectcountries.profile;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BadgesAdapter extends RecyclerView.Adapter <BadgesAdapter.BadgeViewHolder>{


    @NonNull
    @Override
    public BadgesAdapter.BadgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BadgesAdapter.BadgeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BadgeViewHolder extends RecyclerView.ViewHolder {
        public BadgeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
