package com.example.groupprojectcountries.cityGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;

import java.util.List;

public class CityFlashcardsActivity extends AppCompatActivity {

    private TextView countryName;
    private TextView capitalCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_flashcard);

        countryName = findViewById(R.id.country_name_flash);
        capitalCity = findViewById(R.id.country_city_flash);

        AppDatabase db = AppDatabase.getInstance(this);
        String region = getIntent().getStringExtra("REGION");
        String category = getIntent().getStringExtra("CATEGORY"); //not necessary
        String level = getIntent().getStringExtra("LEVEL");
        System.out.println("Region:" + region + " Category:" + category + " Level:" + level);

        List<Country> countryList = db.countryDao().getCountriesByRegion(region);

        int amount = countryList.size()/4;

        List<Country> subListOne = countryList.subList(0, amount);
        List<Country> subListTwo = countryList.subList(amount, amount*2);
        List<Country> subListThree = countryList.subList(amount*2, amount*3);
        List<Country> subListFour = countryList.subList(amount*3, countryList.size());

        switch (level){
            case "1":
                System.out.println("1");
                countryName.setText(subListOne.get(0).getName());
                capitalCity.setText(subListOne.get(0).getCapital());
                break;
            case "2":
                System.out.println("2");
                countryName.setText(subListTwo.get(0).getName());
                capitalCity.setText(subListTwo.get(0).getCapital());
                break;
            case "3":
                System.out.println("3");
                countryName.setText(subListThree.get(0).getName());
                capitalCity.setText(subListThree.get(0).getCapital());
                break;
            case "4":
                System.out.println("4");
                countryName.setText(subListFour.get(0).getName());
                capitalCity.setText(subListFour.get(0).getCapital());
                break;
            default:
                System.out.println("nothing");
        }

    }

}
