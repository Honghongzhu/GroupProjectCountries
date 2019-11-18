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
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegionRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Region> regions;

    public RegionRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_region_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_region);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        regions = new ArrayList<>(Arrays.asList(new Region("Africa"), new Region("Americas"), new Region("Asia"), new Region("Europe"), new Region("Oceania")));
        RegionAdapter regionAdapter = new RegionAdapter();
        regionAdapter.setData(regions);
        recyclerView.setAdapter(regionAdapter);
        return view;
    }

}
