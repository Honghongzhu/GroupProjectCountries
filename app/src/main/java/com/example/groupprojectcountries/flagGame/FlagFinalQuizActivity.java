package com.example.groupprojectcountries.flagGame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.FindCountriesAsyncTask;
import com.example.groupprojectcountries.asynctask.UpdateScoreAsyncTask;
import com.example.groupprojectcountries.asynctask.UpdateScorePerRoundAsyncTask;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.flagGame.completed.FlagFinalResultsActivity;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

public class FlagFinalQuizActivity extends AppCompatActivity implements AsyncTaskDelegate {
    private TextView questionNr;
    private EditText userInput;
    private Button confirmButton;
    private ImageView flagImage;
    private Integer counter;
    private List<Country> countryList;
    private String correctAnswer;
    private String answer;
    private String flagUrl;
    private String region;
    private int score;
    private int nr;
    private UpdateScorePerRoundAsyncTask updateScorePerRoundAsyncTask;
    private UpdateScoreAsyncTask updateScoreAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_final_quiz);

        questionNr = findViewById(R.id.fQuiz_count_flag);
        userInput = findViewById(R.id.response_ffq);
        confirmButton = findViewById(R.id.confirm3);
        flagImage = findViewById(R.id.fFlag_image);
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
        flagUrl = countryList.get(counter).getFlag();
        GlideToVectorYou.justLoadImage(this, Uri.parse(flagUrl), flagImage);
        questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));

        nr = 1;
        nextQuestion();
    }

    public void nextQuestion(){
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                Activity activity = (Activity) context;
                if(counter < countryList.size()-1){
                    checkAnswer();
                    userInput.setText("");
                    nr++;
                    questionNr.setText(String.format(Locale.getDefault(),"Question %s", nr));
                    flagUrl = countryList.get(counter+1).getFlag();
                    GlideToVectorYou.justLoadImage(activity, Uri.parse(flagUrl), flagImage);
                    counter++;
                }
                else{
                    checkAnswer();
                    Intent intent = new Intent(context, FlagFinalResultsActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    public void checkAnswer(){
        answer = userInput.getText().toString().toUpperCase();
        correctAnswer = countryList.get(counter).getName().toUpperCase();
        if(answer.equals(correctAnswer)) {
            score++;
            updateScore();
            Toast.makeText(FlagFinalQuizActivity.this,
                    "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(FlagFinalQuizActivity.this,
                    "Your answer was wrong. The correct answer was: " + countryList.get(counter).getName(), Toast.LENGTH_SHORT).show();
    }

    public void updateScore(){
        AppDatabase db = AppDatabase.getInstance(this);
        int curScore = db.userDao().getUser().getScore();
        int newScore = curScore + 1;
        db.userDao().updateScorePerRound(score);
        db.userDao().updateScore(newScore);
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
