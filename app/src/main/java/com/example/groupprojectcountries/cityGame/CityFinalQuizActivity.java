package com.example.groupprojectcountries.cityGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.FindCountriesAsyncTask;
import com.example.groupprojectcountries.asynctask.UpdateScoreAsyncTask;
import com.example.groupprojectcountries.asynctask.UpdateScorePerRoundAsyncTask;
import com.example.groupprojectcountries.cityGame.completed.CityFinalResultsActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityFinalQuizActivity extends AppCompatActivity implements AsyncTaskDelegate {

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
    private String answer;
    private UpdateScorePerRoundAsyncTask updateScorePerRoundAsyncTask;
    private UpdateScoreAsyncTask updateScoreAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_final_quiz);

        questionNr = findViewById(R.id.fQuiz_count_city);
        userInput = findViewById(R.id.response_fcq);
        confirmButton = findViewById(R.id.confirm1);
        countryName = findViewById(R.id.fCity_text);
        region = getIntent().getStringExtra("REGION");

        AppDatabase db = AppDatabase.getInstance(this);

        updateScoreAsyncTask = new UpdateScoreAsyncTask();
        updateScoreAsyncTask.setDatabase(db);
        updateScoreAsyncTask.setDelegate(this);
        updateScoreAsyncTask.execute(score);

        FindCountriesAsyncTask findCountriesAsyncTask = new FindCountriesAsyncTask();
        findCountriesAsyncTask.setDatabase(db);
        findCountriesAsyncTask.setDelegate(this);
        findCountriesAsyncTask.execute(region);

        updateScorePerRoundAsyncTask = new UpdateScorePerRoundAsyncTask();
        updateScorePerRoundAsyncTask.setDatabase(db);
        updateScorePerRoundAsyncTask.setDelegate(this);
        score = 0;
        updateScorePerRoundAsyncTask.execute(score);

        counter = 0;
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
        answer = userInput.getText().toString().toUpperCase();
        correctAnswer = countryList.get(counter).getCapital().toUpperCase();
        if (answer.equals(correctAnswer)) {
            score++;
            updateScore();
            Toast.makeText(CityFinalQuizActivity.this,
                    "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(CityFinalQuizActivity.this,
                    "Your answer was wrong. The correct answer was: " + countryList.get(counter).getCapital(), Toast.LENGTH_SHORT).show();
    }

    public void updateScore() {
        AppDatabase db = AppDatabase.getInstance(this);
        int curScore = db.userDao().getUser().getScore();
        int newScore = curScore + 1;
        updateScorePerRoundAsyncTask.execute(score);
        updateScoreAsyncTask.execute(newScore);
    }

    @Override
    public void handleTaskResult(List<Country> result) {
        countryList = result;
    }

    @Override
    public void handleTaskResult(String result) {

    }

    @Override
    public void handleTaskResult(User result) {

    }
}
