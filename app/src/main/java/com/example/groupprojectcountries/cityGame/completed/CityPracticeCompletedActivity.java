package com.example.groupprojectcountries.cityGame.completed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.CityFlashcardsActivity;
import com.example.groupprojectcountries.play.LevelActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityPracticeCompletedActivity extends AppCompatActivity {

    private Button okButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_completed);

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, LevelActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
