package com.example.groupprojectcountries.Profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupprojectcountries.R;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profile;
    private ImageView user_photo;
    private TextView user_name;
    private TextView user_mark;
    private RecyclerView Badegs_rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set method about profile_button.
            }
        });
//create a database or fake data base to get the user information
        user_photo=findViewById(R.id.profile_photo);
        user_photo.setImageResource();//set user profile

        user_name=findViewById(R.id.profile_name);
        user_name.setText();//set user name

        user_mark=findViewById(R.id.profile_mark);
        user_mark.setText();//get user mark from data base

        Badegs_rv = findViewById(R.id.badges_rv);


        Badegs_rv.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        Badegs_rv.setLayoutManager(layoutManager);

        mAdapter = new BadgesAdapter();//myDataset
        Badegs_rv.setAdapter(mAdapter);


    }
}
