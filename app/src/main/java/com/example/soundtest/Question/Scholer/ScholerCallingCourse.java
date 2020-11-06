package com.example.soundtest.Question.Scholer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soundtest.Question.LiveVidioActivity;
import com.example.soundtest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ScholerCallingCourse extends AppCompatActivity {
    TextView live_titleTV,scholer_nameTV,start_timeTV,end_timeTV,positionTV;
    Button start_button;
    ImageView scholerIV;

    private String currentUserID;
    public FirebaseAuth mAuth;
    public DatabaseReference RootRef,StartRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholer_calling_course);

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference();

        init();
        DataIntent();



        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference reference = firebaseDatabase.getReference().child("Users");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {


                            for(DataSnapshot d : dataSnapshot.getChildren()) {

                                HashMap<String, Object> result = new HashMap<>();
                                result.put("Live Start", "0");

                                reference.child(String.valueOf(d.getKey())).updateChildren(result);


                            }

                            reference.child(currentUserID).child("Live Start").removeValue();


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });





                Intent scholerintent = new Intent(ScholerCallingCourse.this, LiveVidioActivity.class);

                startActivity(scholerintent);
            }
        });



    }

    private void DataIntent() {

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

                String imageDb = dataSnapshot.child("Users").child(currentUserID).child("image").getValue().toString();
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
