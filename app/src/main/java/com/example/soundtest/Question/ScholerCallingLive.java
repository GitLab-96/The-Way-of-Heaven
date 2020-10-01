package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

import java.util.ArrayList;

public class ScholerCallingLive extends AppCompatActivity {

    TextView live_titleTV,scholer_nameTV,start_timeTV,end_timeTV,positionTV;
    Button start_button;
    ImageView scholerIV;

    private String currentUserID;
    public FirebaseAuth mAuth;
    public DatabaseReference RootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholer_calling_live);
        init();


        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

        Intent intent = getIntent();

        String liveTitle =  intent.getStringExtra("live_title");
        String liveScholer =  intent.getStringExtra("live_scholer");
        String liveStart =  intent.getStringExtra("live_start_time");
        String liveEnd =  intent.getStringExtra("live_end_time");
        int positionInt = intent.getIntExtra("live_position",0);

        String livePosition = String.valueOf(positionInt);

        live_titleTV.setText(liveTitle);
        scholer_nameTV.setText(liveScholer);
        start_timeTV.setText(liveStart);
        end_timeTV.setText(liveEnd);
        positionTV.setText(livePosition);



        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String imageDb = dataSnapshot.child("image").getValue().toString();
                Picasso.get().load(imageDb).placeholder(R.drawable.book11).into(scholerIV);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void init() {

        live_titleTV= findViewById(R.id.scholerliveTitle);
        scholer_nameTV= findViewById(R.id.scholersName);
        start_timeTV= findViewById(R.id.scholerstartTime);
        end_timeTV= findViewById(R.id.scholerendingTime);
        start_button= findViewById(R.id.scholerstartButtn);
        scholerIV = findViewById(R.id.scholersImageIV);
        positionTV = findViewById(R.id.scholerpositionNumber);
    }
}
