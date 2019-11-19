package com.example.groupprojectcountries.profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupprojectcountries.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private ImageView profile;
    private ImageView user_photo;
    private TextView user_name;
    private TextView user_mark;
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

        profile = v.findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set method about profile_button.
            }
        });
//create a database or fake data base to get the user information
        user_photo=v.findViewById(R.id.profile_photo);
        //user_photo.setImageResource();//set user profile

        user_name=v.findViewById(R.id.profile_name);
        //user_name.setText();//set user name

        user_mark=v.findViewById(R.id.profile_mark);
        //user_mark.setText();//get user mark from data base

        Badges_rv = v.findViewById(R.id.badges_rv);


        Badges_rv.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(v.getContext());
        Badges_rv.setLayoutManager(layoutManager);

        mAdapter = new BadgesAdapter();//myDataset
        Badges_rv.setAdapter(mAdapter);


        return v;
    }

}
