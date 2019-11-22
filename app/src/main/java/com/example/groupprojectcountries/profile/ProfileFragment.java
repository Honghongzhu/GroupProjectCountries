package com.example.groupprojectcountries.profile;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.GetUserAsyncTask;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;

import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements AsyncTaskDelegate {

    private ImageView userPhoto;
    private TextView userName;
    private TextView userScore;
    private RecyclerView Badges_rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Context context = v.getContext();
        AppDatabase db = AppDatabase.getInstance(context);
        GetUserAsyncTask getUserAsyncTask = new GetUserAsyncTask();
        getUserAsyncTask.setDatabase(db);
        getUserAsyncTask.setDelegate(this);
        getUserAsyncTask.execute();

        //TODO: create a database or fake data base to get the user information
        userPhoto = v.findViewById(R.id.profile_photo);
        //user_photo.setImageResource();//set user profile

        userName = v.findViewById(R.id.profile_name);

        userScore = v.findViewById(R.id.profile_score);


//        Badges_rv = v.findViewById(R.id.badges_rv);
//
//        Badges_rv.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(v.getContext());
//        Badges_rv.setLayoutManager(layoutManager);
//
//        mAdapter = new BadgesAdapter();//myDataset
//        Badges_rv.setAdapter(mAdapter);


        return v;


        }


    @Override
    public void handleTaskResult(List<Country> result) {

    }

    @Override
    public void handleTaskResult(String result) {

    }

    @Override
    public void handleTaskResult(User result) {
        String name = result.getName();
        userName.setText(name);
        int score = result.getScore();
        userScore.setText(String.format(Locale.getDefault(),"Total Points: %s", score));

    }
}

