package com.example.groupprojectcountries.play;

import android.os.Bundle;
import android.widget.TextView;

import com.example.groupprojectcountries.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {
    private TextView level1;
    private TextView level2;
    private TextView level3;
    private TextView level4;
    private TextView finalQuiz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        finalQuiz = findViewById(R.id.final_quiz);
    }
}
