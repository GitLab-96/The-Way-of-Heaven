package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_live);
        positionTV = findViewById(R.id.positionNumber);
        liveTitleTV = findViewById(R.id.liveTitle);
        scholerNameTV = findViewById(R.id.scholersName);
        liveStartTimeTV = findViewById(R.id.startTime);
        liveEndTimeTV = findViewById(R.id.endingTime);
        liveJoinButtn = findViewById(R.id.joinButtn);
        scholer_IV = findViewById(R.id.scholersImage);

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);


        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        String title = intent.getStringExtra("Title");
        String scholer_name = intent.getStringExtra("ScholersName");
        String live_start_time = intent.getStringExtra("StartTime");
        String live_end_time = intent.getStringExtra("EndTime");


        String convertInt = String.valueOf(position);

        positionTV.setText(convertInt);
        liveTitleTV.setText(title);
        scholerNameTV.setText(scholer_name);
        liveStartTimeTV.setText(live_start_time);
        liveEndTimeTV.setText(live_end_time);
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
