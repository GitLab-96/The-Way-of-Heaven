package com.example.soundtest.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.soundtest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LiveVidioActivity extends AppCompatActivity {

    private ImageView cancelScholerLiveBtn,cancelUserLiveBtn;


    private String currentUserID;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_vidio);

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();

        cancelScholerLiveBtn = findViewById(R.id.close_video_chat_btn);
        cancelUserLiveBtn = findViewById(R.id.close_video_chat_from_user_btn);



        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference Rootref = firebaseDatabase.getReference().child("Users").child(currentUserID).child("Live Start");
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    cancelUserLiveBtn.setVisibility(View.VISIBLE);
                    cancelScholerLiveBtn.setVisibility(View.GONE);
                }
                else {
                    cancelUserLiveBtn.setVisibility(View.GONE);
                    cancelScholerLiveBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(LiveVidioActivity.this, "Error : "+databaseError, Toast.LENGTH_SHORT).show();

            }
        });





        cancelUserLiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference Rootref = firebaseDatabase.getReference().child("Users").child(currentUserID).child("Live Start");
                Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            Rootref.removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(LiveVidioActivity.this, "Error : "+databaseError, Toast.LENGTH_SHORT).show();

                    }
                });

                Intent intent = new Intent(LiveVidioActivity.this,HomeQuestionActivity.class);
                startActivity(intent);

            }
        });


        cancelScholerLiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference reference = firebaseDatabase.getReference().child("Users");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            for(DataSnapshot d : dataSnapshot.getChildren()) {

                                reference.child(String.valueOf(d.getKey())).child("Live Start").removeValue();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });





                Intent intent = new Intent(LiveVidioActivity.this,ScholarsAnswerActivity.class);
                startActivity(intent);

            }
        });



    }
}
