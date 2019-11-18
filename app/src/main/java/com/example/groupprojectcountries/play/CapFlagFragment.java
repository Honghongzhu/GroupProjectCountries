package com.example.groupprojectcountries.play;


import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.groupprojectcountries.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CapFlagFragment extends Fragment {

    private ConstraintLayout capitalCities;
    private ConstraintLayout flags;

    public CapFlagFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cap_flag, container, false);

        capitalCities = v.findViewById(R.id.city);
        capitalCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                Fragment fragment = new LevelFragment();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_slot, fragment);
                fragmentTransaction.commit();
            }
        });

        flags = v.findViewById(R.id.flag);
        flags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                Fragment fragment = new LevelFragment();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_slot, fragment);
                fragmentTransaction.commit();
            }
        });
        return v;
    }

}
