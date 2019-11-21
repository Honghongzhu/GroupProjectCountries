package com.example.groupprojectcountries.flagGame;

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
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.flagGame.completed.FlagPracticeCompletedActivity;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FlagPracticeQuizActivity extends AppCompatActivity {

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
        db.userDao().updateScorePerRound(score);
        List<Country> countryList = db.countryDao().getCountriesByRegion(region);

        int amount = countryList.size() / 4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount *2);
        final List<Country> subListThree = countryList.subList(amount *2, amount *3);
        final List<Country> subListFour = countryList.subList(amount *3, countryList.size());
        questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));

        switch (level){
            case "1":
                flagUrl = subListOne.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                nextCountry(subListOne, "1");
                break;
            case "2":
                flagUrl = subListTwo.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                nextCountry(subListTwo, "2");
                break;
            case "3":
                flagUrl = subListThree.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                nextCountry(subListThree, "3");
                break;
            case "4":
                flagUrl = subListFour.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
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
                if(counter < subList.size()-1){
                    checkAnswer(subList);
                    userInput.setText("");
                    nr++;
                    questionNr.setText(String.format(Locale.getDefault(),"Question %s", nr));
                    flagUrl = subList.get(counter+1).getFlag();
                    Glide.with(context).load(flagUrl).into(flag);
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
        db.userDao().updateScorePerRound(score);
        db.userDao().updateScore(newScore);
    }
}
