package com.example.groupprojectcountries.play;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.profile.ProfileActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Region> regions;
    private RecyclerView.LayoutManager layoutManager;
    private Button profileButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        recyclerView = findViewById(R.id.rv_region);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        regions = new ArrayList<>(Arrays.asList(new Region("Africa"), new Region("Americas"), new Region("Asia"), new Region("Europe"), new Region("Oceania")));
        RegionAdapter regionAdapter = new RegionAdapter();
        regionAdapter.setData(regions);
        recyclerView.setAdapter(regionAdapter);

        profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ProfileActivity.class);
                context.startActivity(intent);
            }
        });

    }
}
