package com.example.groupprojectcountries.cityGame.flashcards;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.flagGame.flashcards.FlagFlashcardsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class cityCardFragment extends AppCompatActivity {
    private ImageButton golast;
    private ImageButton gonext;
    private TextView cityCardLevel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_city_card);

        golast.findViewById(R.id.go_last_card);
        gonext.findViewById(R.id.go_next_card);
        cityCardLevel.findViewById(R.id.city_card_level);

        //need to create a Fragement (cityFlashcardsActivity.java)
        Fragment fragment =new cityFlashcardsActivity();
        swapFragment(fragment);


        golast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //replace fragment to last one using activity_city_flashcard.xml
            }
        });

        gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //replace fragment to last one using activity_city_flashcard.xml
            }
        });
    }


    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.city_fragment, fragment);
        fragmentTransaction.commit();
    }
}
