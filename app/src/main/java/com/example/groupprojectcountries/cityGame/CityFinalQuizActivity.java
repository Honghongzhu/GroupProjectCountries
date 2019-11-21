package com.example.groupprojectcountries.cityGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.completed.CityFinalResultsActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.flagGame.FlagFinalQuizActivity;
import com.example.groupprojectcountries.flagGame.completed.FlagFinalResultsActivity;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityFinalQuizActivity extends AppCompatActivity {

    private TextView questionNr;
    private TextView countryName;
    private EditText userInput;
    private Button confirmButton;
    private Integer counter;
    private List<Country> countryList;
    private String correctAnswer;
    private String region;
    private int score;
    private int nr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_final_quiz);

        questionNr = findViewById(R.id.pQuiz_count_city);
        userInput = findViewById(R.id.response_fcq);
        confirmButton = findViewById(R.id.confirm1);
        countryName = findViewById(R.id.fCity_text);

        AppDatabase db = AppDatabase.getInstance(this);
        region = getIntent().getStringExtra("REGION");
        countryList = db.countryDao().getCountriesByRegion(region);
        score = 1;
        db.userDao().updateScorePerRound(score);

        counter = 0;
        correctAnswer = countryList.get(counter).getName().toUpperCase();
        countryName.setText(countryList.get(counter).getName());
        questionNr.setText(String.format(Locale.getDefault(), "Question %s", 1));

        nr = 1;
        nextQuestion();
    }

    public void nextQuestion() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                if (counter < countryList.size() - 1) {
                    checkAnswer();
                    userInput.setText("");
                    nr++;
                    questionNr.setText(String.format(Locale.getDefault(), "Question %s", nr));
                    countryName.setText(countryList.get(counter + 1).getName());
                    counter++;
                } else {
                    checkAnswer();
                    Intent intent = new Intent(context, CityFinalResultsActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    public void checkAnswer() {
        String answer = userInput.getText().toString().toUpperCase();
        if (answer.equals(correctAnswer)) {
            score++;
            updateScore();
            Toast.makeText(CityFinalQuizActivity.this,
                    "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(CityFinalQuizActivity.this,
                    "Your answer was wrong. The correct answer was: " + countryList.get(counter).getName(), Toast.LENGTH_SHORT).show();
    }

    public void updateScore() {
        AppDatabase db = AppDatabase.getInstance(this);
        int curScore = db.userDao().getUser().getScore();
        int newScore = curScore + 1;
        db.userDao().updateScorePerRound(score);
        db.userDao().updateScore(newScore);
    }

}
