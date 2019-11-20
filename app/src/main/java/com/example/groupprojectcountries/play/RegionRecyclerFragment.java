package com.example.groupprojectcountries.play;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        final RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://restcountries.eu/rest/v2/all";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Country[] countryArray = gson.fromJson(response, Country[].class);
                List<Country> countryList = Arrays.asList(countryArray);
                AppDatabase db = AppDatabase.getInstance(getContext());
                db.countryDao().insertAll(countryList);
                queue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error");
                queue.stop();
            }
        };
        System.out.println(url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        queue.add(stringRequest);

        return v;
    }

}
