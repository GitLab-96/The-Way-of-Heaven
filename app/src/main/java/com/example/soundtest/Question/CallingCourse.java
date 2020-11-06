package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.Question.Scholer.RollDialogFragment;
import com.example.soundtest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class CallingCourse extends AppCompatActivity {
    public TextView liveTitleTV,scholerNameTV,liveStartTimeTV,liveEndTimeTV;
    public Button liveJoinButtn;
    private String currentUserID;
    public FirebaseAuth mAuth;
    public DatabaseReference RootRef;
    MediaPlayer ringingMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_course);
        init();
        ringingMedia = MediaPlayer.create(CallingCourse.this,R.raw.ringing);

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        DataIntent();

        RootRef.child("Course Start").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    ringingMedia.start();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(CallingCourse.this, "Error : "+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        liveJoinButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();

            }
        });





    }

    private void init() {

        liveTitleTV = findViewById(R.id.liveTitle);
        scholerNameTV = findViewById(R.id.scholersName);
        liveStartTimeTV = findViewById(R.id.startTime);
        liveEndTimeTV = findViewById(R.id.endingTime);
        liveJoinButtn = findViewById(R.id.joinButtn);

    }
    private void DataIntent() {

        Intent callingintent = getIntent();
        String title = callingintent.getStringExtra("live_title");
        String scholer_name = callingintent.getStringExtra("live_scholer");
        String start_time = callingintent.getStringExtra("live_start_time");
        String end_time = callingintent.getStringExtra("live_end_time");


        liveTitleTV.setText(title);
        scholerNameTV.setText(scholer_name);
        liveStartTimeTV.setText(start_time);
        liveEndTimeTV.setText(end_time);


    }

    private void openDialog() {

        RollDialogFragment rollDialogFragment = new RollDialogFragment();
        rollDialogFragment.show(getSupportFragmentManager(),"Example dialog");


    }
}
