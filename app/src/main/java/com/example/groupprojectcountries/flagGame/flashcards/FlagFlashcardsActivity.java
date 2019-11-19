package com.example.groupprojectcountries.flagGame.flashcards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.groupprojectcountries.R;

public class FlagFlashcardsActivity extends Fragment {

    private ImageView country_flag;
    private TextView flag_name;

    public FlagFlashcardsActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_flag_flashcard,container,false);

        country_flag = view.findViewById(R.id.country_flag);
        flag_name = view.findViewById(R.id.flag_name);

        //set image and text on country_flag and flag_name;



        return view;
    }
}
