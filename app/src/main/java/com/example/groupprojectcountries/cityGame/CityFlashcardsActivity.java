package com.example.groupprojectcountries.cityGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.FindCountriesAsyncTask;
import com.example.groupprojectcountries.asynctask.InsertCountriesAsyncTask;
import com.example.groupprojectcountries.cityGame.completed.CityReadyToPracticeActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.RegionRecyclerFragment;

import java.util.List;

public class CityFlashcardsActivity extends AppCompatActivity implements AsyncTaskDelegate {

    private TextView countryName;
    private TextView capitalCity;
    private Button next;
    private int counter;
    private String region;
    private String level;
    List<Country> countryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_flashcard);

        countryName = findViewById(R.id.country_name_flash);
        capitalCity = findViewById(R.id.country_city_flash);
        next = findViewById(R.id.next_city);
        region = getIntent().getStringExtra("REGION");
        level = getIntent().getStringExtra("LEVEL");

        AppDatabase db = AppDatabase.getInstance(this);
        FindCountriesAsyncTask findCountriesAsyncTask = new FindCountriesAsyncTask();
        findCountriesAsyncTask.setDatabase(db);
        findCountriesAsyncTask.setDelegate(this);
        findCountriesAsyncTask.execute(region);

        int amount = countryList.size() / 4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount *2);
        final List<Country> subListThree = countryList.subList(amount *2, amount *3);
        final List<Country> subListFour = countryList.subList(amount *3, countryList.size());
        counter = 0;

        switch (level){
            case "1":
                countryName.setText(subListOne.get(0).getName());
                capitalCity.setText(subListOne.get(0).getCapital());
                nextCard(subListOne, "1");
                break;
            case "2":
                countryName.setText(subListTwo.get(0).getName());
                capitalCity.setText(subListTwo.get(0).getCapital());
                nextCard(subListTwo, "2");
                break;
            case "3":
                countryName.setText(subListThree.get(0).getName());
                capitalCity.setText(subListThree.get(0).getCapital());
                nextCard(subListThree, "3");
                break;
            case "4":
                countryName.setText(subListFour.get(0).getName());
                capitalCity.setText(subListFour.get(0).getCapital());
                nextCard(subListFour, "4");
                break;
            default:
                System.out.println("nothing");
        }
    }

    public void nextCard(final List<Country> subList, final String level){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                if(counter < subList.size()-1) {
                    countryName.setText(subList.get(counter+1).getName());
                    capitalCity.setText(subList.get(counter+1).getCapital());
                    counter++;
                } else{
                    Intent intent = new Intent(context, CityReadyToPracticeActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("LEVEL", level);
                    context.startActivity(intent);
                }
            }
        });
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
