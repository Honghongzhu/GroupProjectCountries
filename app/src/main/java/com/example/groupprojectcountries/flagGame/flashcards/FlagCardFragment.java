package com.example.groupprojectcountries.flagGame.flashcards;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.groupprojectcountries.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlagCardFragment extends AppCompatActivity {
    private ImageButton last;
    private ImageButton next;
    private TextView flagCardLevel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_flag_card);
        // Inflate the layout for this fragment
        last=findViewById(R.id.Last);
        next.findViewById(R.id.Next);
        flagCardLevel.findViewById(R.id.flag_card_level);

        // need to create a fragment (FlagFlashcardsActivity)
        Fragment fragment =new FlagFlashcardsActivity();
        swapFragment(fragment);

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //replace fragment to last one using activity_flag_flashcard.xml
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //replace fragment to next one using activity_flag_flashcard.xml
            }
        });


    }

    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flag_fragment, fragment);
        fragmentTransaction.commit();

    }

}
