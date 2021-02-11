package com.example.soundtest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
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
    TextView thwayTV,heavenTV,persentTV;
    Typeface typeface;
     private  ImageButton learnBtn,readBtn,salahBtn,questionBtn;
     private FirebaseUser currentUser;
     private FirebaseAuth mAuth;
     private DatabaseReference RootRef;

    boolean exit = false;
    ProgressBar VerticalProgressBar;

    Handler handler = new Handler();

    int totalMarks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



        mAuth=FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef= FirebaseDatabase.getInstance().getReference();





        thwayTV = findViewById(R.id.the_way);
        heavenTV = findViewById(R.id.heaven);
        typeface = Typeface.createFromAsset(getAssets(),"alexbrush_regular.ttf");

        thwayTV.setTypeface(typeface);
        heavenTV.setTypeface(typeface);


        SendUserMainActivityToSalahActivity();
        SendUserMainActivityToReadActivity();
        SendUserMainActivityToLearnActivity();
        SendUserMainActivityToQuestionActivity();


      ProgressingTask();





    }

    private void ProgressingTask() {

        String currentUserID=mAuth.getCurrentUser().getUid();
        RootRef.child("Marks").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String Allah = (dataSnapshot.child("Marks").child("AllahExam").getValue(String.class));
                int allah =Integer.parseInt(Allah);
                String Gunnah = dataSnapshot.child("Marks").child("GunnahExam").getValue(String.class);
                int gunnah =Integer.parseInt(Gunnah);
                String Horkot = dataSnapshot.child("Marks").child("HorkotExam").getValue(String.class);
                int horkot =Integer.parseInt(Horkot);
                String Horof = dataSnapshot.child("Marks").child("HorofExam").getValue(String.class);
                int horof =Integer.parseInt(Horof);
                String Kolkola = dataSnapshot.child("Marks").child("KolkolaExam").getValue(String.class);
                int kolkolah =Integer.parseInt(Kolkola);
                String Madd = dataSnapshot.child("Marks").child("MaddExam").getValue(String.class);
                int modd =Integer.parseInt(Madd);
                String Ro = dataSnapshot.child("Marks").child("RoExam").getValue(String.class);
                int ro =Integer.parseInt(Ro);
                String Sura = dataSnapshot.child("Marks").child("SuraExam").getValue(String.class);
                int sura =Integer.parseInt(Sura);
                String Tomij = dataSnapshot.child("Marks").child("TomijExam").getValue(String.class);
                int tomij =Integer.parseInt(Tomij);
                String Wajib =dataSnapshot.child("Marks").child("WajibExam").getValue(String.class);
                int wajib =Integer.parseInt(Wajib);
                totalMarks = allah+gunnah+horkot+horof+kolkolah+modd+ro+sura+tomij+wajib;

                String TM = String.valueOf(totalMarks);
                persentTV.setText(TM);
                // Toast.makeText(MainActivity.this, TM, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Adding colors on progress bar
        VerticalProgressBar.getProgressDrawable().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(totalMarks < 200)
                {
                    // intValue++;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            VerticalProgressBar.setProgress(totalMarks);


                        }
                    });try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        }).start();

    }


    private void init() {

        learnBtn = findViewById(R.id.learnBtn);
        readBtn = findViewById(R.id.readBtn);
        salahBtn = findViewById(R.id.salahBtn);
        questionBtn = findViewById(R.id.questionBtn);
        persentTV = findViewById(R.id.persentTV);
        VerticalProgressBar = (ProgressBar)findViewById(R.id.progressBar1);
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

    @Override
    public void onBackPressed() {



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do You Exit ?");
        builder.setMessage("Are you Sure do you want to quit ?");
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {



                exit = true;
                getOutApp(exit);


            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                exit = false;
                getOutApp(exit);
            }
        });

        builder.create();
        builder.show();
    }

    public void  getOutApp(boolean exit){
        if (exit==true){
            super.onBackPressed();
        }
        else {
            Toast.makeText(this, "Thanks for Reciting the Holly Quran", Toast.LENGTH_SHORT).show();
        }
    }

}
