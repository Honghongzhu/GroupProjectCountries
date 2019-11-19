package com.example.groupprojectcountries.cityGame.flashcards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.groupprojectcountries.R;

public class cityFlashcardsActivity extends Fragment {
    private TextView countryName;
    private TextView capitalCity;

    public cityFlashcardsActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_city_flashcard,container,false);

       countryName = view.findViewById(R.id.country_name);
       capitalCity = view.findViewById(R.id.capital_city_name);
        //countryName.setText();
        //capitalCity.setText();
        //get the country name and capital city from data base.

        return view;
    }
}
