package com.example.groupprojectcountries.cityGame.completed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.PlayActivity;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityFinalResultsActivity extends AppCompatActivity {

    private Button okButton;
    private TextView score;
    private TextView nCorrect;
    private TextView nWrong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_results);
        String region = getIntent().getStringExtra("REGION");
        String correct = getIntent().getStringExtra("CORRECT");
        String wrong = getIntent().getStringExtra("WRONG");
        score = findViewById(R.id.nPoints);
        nCorrect = findViewById(R.id.nCorrect);
        nCorrect.setText(correct);
        nWrong = findViewById(R.id.nWrong);
        nWrong.setText(wrong);


        AppDatabase db = AppDatabase.getInstance(this);
        int scoreDb = db.userDao().getUser().getScorePerRound();
        score.setText(String.format(Locale.getDefault(), "%s", scoreDb));

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, PlayActivity.class);
                context.startActivity(intent);
            }
        });
    }
}