package com.example.soundtest.Question;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soundtest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private Button upDateBttn;
    private TextView userName,userEmail,userPhone,userGender,userDOB;
    private ImageView userImage;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private BottomNavigationView navigationView;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth=FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        upDateBttn = view.findViewById(R.id.update_settings_buttn);
        userName = view.findViewById(R.id.get_user_name);
        userEmail = view.findViewById(R.id.get_user_statuse);
        userPhone = view.findViewById(R.id.get_user_phone_number);
        userGender= view.findViewById(R.id.gender);
        userDOB = view.findViewById(R.id.dateOfBirth);


        RetreveData();

        upDateBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToSettingsActivity();
            }
        });





      return view;
    }





    private void SendUserToSettingsActivity() {
        startActivity(new Intent(getContext(), SettingsActivity.class));

    }

    private void RetreveData() {

        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String retreveUsername = dataSnapshot.child("name").getValue().toString();
                String retreveUserstatus = dataSnapshot.child("status").getValue().toString();
                String retreveUserDoB = dataSnapshot.child("Date of Birth").getValue().toString();
                String retreveUserGender = dataSnapshot.child("Gender").getValue().toString();
                String retreveUserPhone = dataSnapshot.child("Phone No").getValue().toString();

                userName.setText(retreveUsername);
                userEmail.setText(retreveUserstatus);
                userPhone.setText(retreveUserPhone);
                userGender.setText(retreveUserGender);
                userDOB.setText(retreveUserDoB);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init() {


    }


}
