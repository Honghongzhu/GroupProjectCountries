package com.example.groupprojectcountries.flagGame.completed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.flagGame.FlagFlashcardsActivity;
import com.example.groupprojectcountries.flagGame.FlagPracticeQuizActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FlagReadyToPracticeActivity extends AppCompatActivity {

    private Button noButton;
    private Button yesButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_to_practice);

        noButton = findViewById(R.id.noButton);
        yesButton = findViewById(R.id.yesButton);

        //If the user is not ready for the practice quiz, the flashcards will be shown again
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, FlagFlashcardsActivity.class);
                context.startActivity(intent);
            }
        });

        //If the user is ready for the practice quiz, the quiz will appear
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, FlagPracticeQuizActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
