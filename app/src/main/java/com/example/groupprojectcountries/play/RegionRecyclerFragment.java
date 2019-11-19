package com.example.groupprojectcountries.play;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.groupprojectcountries.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegionRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Region> regions;
    private RecyclerView.LayoutManager layoutManager;

    public RegionRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_region_recycler, container, false);
        recyclerView = v.findViewById(R.id.rv_region);
        layoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);

        regions = new ArrayList<>(Arrays.asList(new Region("Africa"), new Region("Americas"), new Region("Asia"), new Region("Europe"), new Region("Oceania")));
        RegionAdapter regionAdapter = new RegionAdapter();
        regionAdapter.setData(regions);
        recyclerView.setAdapter(regionAdapter);

        return v;
    }

}
