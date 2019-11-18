package com.example.groupprojectcountries.FlagGame.Practice;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.groupprojectcountries.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlagPracticeFragment extends Fragment {


    public FlagPracticeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flag_practice, container, false);
    }

}
