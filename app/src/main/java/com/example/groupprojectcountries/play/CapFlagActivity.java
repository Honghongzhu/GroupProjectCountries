package com.example.groupprojectcountries.play;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.profile.ProfileActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CapFlagActivity extends AppCompatActivity {

    private ConstraintLayout capitalCities;
    private ConstraintLayout flags;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_flag);

        capitalCities = findViewById(R.id.city);
        capitalCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, LevelActivity.class);
                intent.putExtra("CATEGORY", "capitalCities");
                context.startActivity(intent);
            }
        });

        flags = findViewById(R.id.flag);
        flags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, LevelActivity.class);
                intent.putExtra("CATEGORY", "flags");
                context.startActivity(intent);
            }
        });
    }
}