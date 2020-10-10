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

import com.example.soundtest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class CallingLive extends AppCompatActivity {

    public TextView positionTV,liveTitleTV,scholerNameTV,liveStartTimeTV,liveEndTimeTV;
    public Button liveJoinButtn;
    public ImageView scholer_IV;
    private String currentUserID;
    public FirebaseAuth mAuth;
    public DatabaseReference RootRef;
    MediaPlayer ringingMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_live);
        init();
        ringingMedia = MediaPlayer.create(CallingLive.this,R.raw.ringing);

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        DataIntent();

        RootRef.child("Live Start").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    ringingMedia.start();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(CallingLive.this, "Error : "+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        liveJoinButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CallingLive.this,LiveVidioActivity.class);
                startActivity(intent);
            }
        });





    }

    private void init() {

        positionTV = findViewById(R.id.positionNumber);
        liveTitleTV = findViewById(R.id.liveTitle);
        scholerNameTV = findViewById(R.id.scholersName);
        liveStartTimeTV = findViewById(R.id.startTime);
        liveEndTimeTV = findViewById(R.id.endingTime);
        liveJoinButtn = findViewById(R.id.joinButtn);
        scholer_IV = findViewById(R.id.scholersImage);

    }

    private void DataIntent() {

        Intent callingintent = getIntent();
        int position = callingintent.getIntExtra("live_position",0);
        String convertInt = String.valueOf(position);
        String title = callingintent.getStringExtra("live_title");
        String scholer_name = callingintent.getStringExtra("live_scholer");
        String start_time = callingintent.getStringExtra("live_start_time");
        String end_time = callingintent.getStringExtra("live_end_time");


        positionTV.setText(convertInt);
        liveTitleTV.setText(title);
        scholerNameTV.setText(scholer_name);
        liveStartTimeTV.setText(start_time);
        liveEndTimeTV.setText(end_time);


        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String imageDb = dataSnapshot.child("image").getValue().toString();
                Picasso.get().load(imageDb).placeholder(R.drawable.book11).into(scholer_IV);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
