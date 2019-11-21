package com.example.groupprojectcountries.flagGame.completed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.LevelActivity;
import com.example.groupprojectcountries.play.PlayActivity;

import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FlagPracticeCompletedActivity extends AppCompatActivity {

    private Button okButton;
    private TextView score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_completed);
        AppDatabase db = AppDatabase.getInstance(this);
        score = findViewById(R.id.nPoints);
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
