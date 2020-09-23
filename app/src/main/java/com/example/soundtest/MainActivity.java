package com.example.soundtest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.Learn.LearnActivity;
import com.example.soundtest.Question.HomeQuestionActivity;
import com.example.soundtest.Question.SettingsActivity;
import com.example.soundtest.Read.Read;
import com.example.soundtest.Salah.SalahActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Typeface typeface;
     private  ImageButton learnBtn,readBtn,salahBtn,questionBtn;
     private FirebaseUser currentUser;

     private FirebaseAuth mAuth;
     private DatabaseReference RootRef;




    public DatabaseReference RootRefMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        mAuth=FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef= FirebaseDatabase.getInstance().getReference();



        textView = findViewById(R.id.the_way);
        typeface = Typeface.createFromAsset(getAssets(),"alexbrush_regular.ttf");

        textView.setTypeface(typeface);

        SendUserMainActivityToSalahActivity();
        SendUserMainActivityToReadActivity();
        SendUserMainActivityToLearnActivity();
        SendUserMainActivityToQuestionActivity();




    }



    private void init() {

        learnBtn = findViewById(R.id.learnBtn);
        readBtn = findViewById(R.id.readBtn);
        salahBtn = findViewById(R.id.salahBtn);
        questionBtn = findViewById(R.id.questionBtn);
    }


    private void SendUserMainActivityToQuestionActivity() {

        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, HomeQuestionActivity.class));
            }
        });
    }

    private void SendUserMainActivityToLearnActivity() {

        learnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, LearnActivity.class));
            }
        });
    }

    private void SendUserMainActivityToReadActivity() {
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Read.class));
            }
        });

    }

    private void SendUserMainActivityToSalahActivity() {
        salahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SalahActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
          super.onStart();

          if(currentUser== null){

              SendUserToLoginActivity();
          }
          else{

              VerifyUserExistance();
          }
    }

    private void VerifyUserExistance() {

        String currentUserID=mAuth.getCurrentUser().getUid();
        RootRef.child("Users").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if ((dataSnapshot.child("name").exists())){

                }else {
                    SendUserToSettingsActivity();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void SendUserToSettingsActivity() {

        Intent settingIntent=new Intent(MainActivity.this, SettingsActivity.class);
        settingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingIntent);
        finish();
        }
    private void SendUserToLoginActivity() {

        Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }
}
