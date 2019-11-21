package com.example.groupprojectcountries.play;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.CityFinalQuizActivity;
import com.example.groupprojectcountries.cityGame.CityFlashcardsActivity;
import com.example.groupprojectcountries.flagGame.FlagFinalQuizActivity;
import com.example.groupprojectcountries.flagGame.FlagFlashcardsActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {
    private TextView level1;
    private TextView level2;
    private TextView level3;
    private TextView level4;
    private TextView finalQuiz;
    private String region;
    private String category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        finalQuiz = findViewById(R.id.final_quiz);

        region = getIntent().getStringExtra("REGION");
        category = getIntent().getStringExtra("CATEGORY");

        //If the user clicks on one of the levels, flashcards will show depending on the chosen category.
        //It will also pass on which level is clicked.
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent;
                if(category.equals("capitalCities")){
                    intent = new Intent(context, CityFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "1");
                    context.startActivity(intent);
                }
                else{
                    intent = new Intent(context, FlagFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "1");
                }
                context.startActivity(intent);

            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent;
                if(category.equals("capitalCities")){
                    intent = new Intent(context, CityFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "2");
                }
                else{
                    intent = new Intent(context, FlagFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "2");
                }
                context.startActivity(intent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent;
                if(category.equals("capitalCities")){
                    intent = new Intent(context, CityFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "3");
                }
                else{
                    intent = new Intent(context, FlagFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "3");
                }
                context.startActivity(intent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent;
                if(category.equals("capitalCities")){
                    intent = new Intent(context, CityFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "4");
                }
                else{
                    intent = new Intent(context, FlagFlashcardsActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "4");
                }
                context.startActivity(intent);
            }
        });

        finalQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent;
                if(category.equals("capitalCities")){
                    intent = new Intent(context, CityFinalQuizActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "5");
                }
                else{
                    intent = new Intent(context, FlagFinalQuizActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", "5");
                }
                context.startActivity(intent);
            }
        });
    }
}
