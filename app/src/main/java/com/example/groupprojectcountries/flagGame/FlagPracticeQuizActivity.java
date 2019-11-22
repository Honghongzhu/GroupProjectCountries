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
import com.example.groupprojectcountries.flagGame.completed.FlagPracticeCompletedActivity;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FlagPracticeQuizActivity extends AppCompatActivity implements AsyncTaskDelegate {

    private TextView questionNr;
    private ImageView flag;
    private EditText userInput;
    private Button confirmButton;
    private String flagUrl;
    private String region;
    private String category;
    private String level;
    private int counter;
    private int nr;
    private String answer;
    private AppDatabase db;
    private int score;
    private List<Country> countryList;
    private UpdateScorePerRoundAsyncTask updateScorePerRoundAsyncTask;
    private UpdateScoreAsyncTask updateScoreAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_practice_quiz);

        questionNr = findViewById(R.id.pQuiz_count_flag);
        userInput = findViewById(R.id.response_ffq);
        confirmButton = findViewById(R.id.confirm4);
        flag = findViewById(R.id.pFlag_image);
        region = getIntent().getStringExtra("REGION");
        category = getIntent().getStringExtra("CATEGORY"); //not necessary
        level = getIntent().getStringExtra("LEVEL");

        counter = 0;
        nr = 1;
        score = 0;

        db = AppDatabase.getInstance(this);
        updateScoreAsyncTask = new UpdateScoreAsyncTask();
        updateScoreAsyncTask.setDatabase(db);
        updateScoreAsyncTask.setDelegate(this);

        FindCountriesAsyncTask findCountriesAsyncTask = new FindCountriesAsyncTask();
        findCountriesAsyncTask.setDatabase(db);
        findCountriesAsyncTask.setDelegate(this);
        findCountriesAsyncTask.execute(region);

        updateScorePerRoundAsyncTask = new UpdateScorePerRoundAsyncTask();
        updateScorePerRoundAsyncTask.setDatabase(db);
        updateScorePerRoundAsyncTask.setDelegate(this);
        updateScorePerRoundAsyncTask.execute(score);

        int amount = countryList.size() / 4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount *2);
        final List<Country> subListThree = countryList.subList(amount *2, amount *3);
        final List<Country> subListFour = countryList.subList(amount *3, countryList.size());
        questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));

        switch (level){
            case "1":
                flagUrl = subListOne.get(0).getFlag();
                GlideToVectorYou.justLoadImage(this, Uri.parse(flagUrl), flag);
                nextCountry(subListOne, "1");
                break;
            case "2":
                flagUrl = subListTwo.get(0).getFlag();
                GlideToVectorYou.justLoadImage(this, Uri.parse(flagUrl), flag);
                nextCountry(subListTwo, "2");
                break;
            case "3":
                flagUrl = subListThree.get(0).getFlag();
                GlideToVectorYou.justLoadImage(this, Uri.parse(flagUrl), flag);
                nextCountry(subListThree, "3");
                break;
            case "4":
                flagUrl = subListFour.get(0).getFlag();
                GlideToVectorYou.justLoadImage(this, Uri.parse(flagUrl), flag);
                nextCountry(subListFour, "4");
                break;
            default:
                System.out.println("nothing");
        }
    }

    public void nextCountry(final List<Country> subList, final String level){
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                Activity activity = (Activity) context;
                if(counter < subList.size()-1){
                    checkAnswer(subList);
                    userInput.setText("");
                    nr++;
                    questionNr.setText(String.format(Locale.getDefault(),"Question %s", nr));
                    flagUrl = subList.get(counter+1).getFlag();
                    GlideToVectorYou.justLoadImage(activity, Uri.parse(flagUrl), flag);
                    counter++;
                }
                else{
                    checkAnswer(subList);
                    Intent intent = new Intent(context, FlagPracticeCompletedActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", level);
                    context.startActivity(intent);
                }
            }
        });
    }

    public void checkAnswer(List<Country> subList){
        answer = userInput.getText().toString().toUpperCase();
        if(answer.equals(subList.get(counter).getCapital().toUpperCase())) {
            score++;
            updateScore();
            Toast.makeText(FlagPracticeQuizActivity.this,
                    "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(FlagPracticeQuizActivity.this,
                    "Your answer was wrong. The correct answer was: " + subList.get(counter).getName(), Toast.LENGTH_SHORT).show();
    }

    public void updateScore(){
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
