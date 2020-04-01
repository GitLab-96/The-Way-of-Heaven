package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

public class ProfileActivity extends AppCompatActivity {
    private Button upDateBttn;
    private TextView userName,userEmail,userPhone,userGender,userDOB;
    private ImageView userImage;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth=FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        init();
        BottomNavigationItemSelect();

        RetreveData();

        upDateBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToSettingsActivity();
            }
        });



    }

    private void BottomNavigationItemSelect() {

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.main_profile:

                        break;

                    case R.id.all_answer_list:

                        startActivity(new Intent(ProfileActivity.this,QuestionActivity.class));

                        break;

                    case R.id.main_groups_List:
                        SendUserToGeoupActivity();
                        break;

                    case R.id.main_live_list:
                        SendUserToLiveActivity();


                }
                return false;
            }
        });
    }

    private void SendUserToLiveActivity() {
        startActivity(new Intent(ProfileActivity.this, LiveActivity.class));

    }

    private void SendUserToGeoupActivity() {
        startActivity(new Intent(ProfileActivity.this, GroupsActivity.class));

    }

    private void SendUserToSettingsActivity() {
        startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));

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
        upDateBttn = findViewById(R.id.update_settings_buttn);
        userName = findViewById(R.id.get_user_name);
        userEmail = findViewById(R.id.get_user_statuse);
        userPhone = findViewById(R.id.get_user_phone_number);
        userGender= findViewById(R.id.gender);
        userDOB = findViewById(R.id.dateOfBirth);
        navigationView=findViewById(R.id.bottom_nev);

    }


}
