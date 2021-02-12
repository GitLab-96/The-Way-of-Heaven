package com.example.soundtest.Learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
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

public class LearnActivity extends AppCompatActivity  {
    private TextView arabicHorof,tomijHorof,horkot,kolkolah,wajib,madd,gunnah,raPurBarik,allahPurBarik,surah;
    private ImageView tomijHorofLock,horkotLock,kolkolahLock,wajibLock,maddLock,gunnahLock,raPurBarikLock,allahPurBarikLock,surahLock;


    TextView horofMarksTV,tomijMarksTV,horkotMarksTV,kolkolaMarksTV,wajibMarksTV,maddMarksTV,gunnahMarksTV,roMarksTV,allahMarksTV,suraMarksTV;
    int marksHoroh,markTomij,marksHorkot,marksKolkola,marksWajib,marksMadd,marksGunnah,marksRo,marksAllah;

    public FirebaseAuth mAuth;
    public DatabaseReference RootRef;
    private String currentUserID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);



        init();
        SendUserLearActivityToHorofActivity();
        SendUserLearActivityToTomijHorofActivity();
        SendUserLearnActivityToHorkotActivity();
        SendUserLearnActivityToKolkolahActivity();
        SendUserLearnActivityToOwajibActivity();
        SendUserLearnActivityToMaddActivity();
        SendUserLearnActivityToGunnaActivity();
        SendUserLearnActivityToRaPurBarikActivity();
        SendUserLearnActivityToAllahPurBarikActivity();
        SendUserLearnActivityToSurahActivityActivity();

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();


        RootRef = FirebaseDatabase.getInstance().getReference().child("Marks").child(currentUserID).child("Marks");



        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String retreveHorohMarks = (String) dataSnapshot.child("HorofExam").getValue();
                    String retreveTomijMarks = (String) dataSnapshot.child("TomijExam").getValue();
                    String retreveHorkotMarks = (String) dataSnapshot.child("HorkotExam").getValue();
                    String retreveKolkolaMarks = (String) dataSnapshot.child("KolkolaExam").getValue();
                    String retreveWajibMarks = (String) dataSnapshot.child("WajibExam").getValue();
                    String retreveMaddMarks = (String) dataSnapshot.child("MaddExam").getValue();
                    String retreveGunnahMarks = (String) dataSnapshot.child("GunnahExam").getValue();
                    String retreveRohMarks = (String) dataSnapshot.child("RoExam").getValue();
                    String retreveAllahMarks = (String) dataSnapshot.child("AllahExam").getValue();
                    String retreveSuraMarks = (String) dataSnapshot.child("SuraExam").getValue();


                    horofMarksTV.setText(retreveHorohMarks);
                    tomijMarksTV.setText(retreveTomijMarks);
                    horkotMarksTV.setText(retreveHorkotMarks);
                    kolkolaMarksTV.setText(retreveKolkolaMarks);
                    wajibMarksTV.setText(retreveWajibMarks);
                    maddMarksTV.setText(retreveMaddMarks);
                    gunnahMarksTV.setText(retreveGunnahMarks);
                    roMarksTV.setText(retreveRohMarks);
                    allahMarksTV.setText(retreveAllahMarks);
                    suraMarksTV.setText(retreveSuraMarks);


                    marksHoroh = Integer.parseInt(retreveHorohMarks);
                    markTomij = Integer.parseInt(retreveTomijMarks);
                    marksHorkot = Integer.parseInt(retreveHorkotMarks);
                    marksKolkola = Integer.parseInt(retreveKolkolaMarks);
                    marksWajib = Integer.parseInt(retreveWajibMarks);
                    marksMadd = Integer.parseInt(retreveMaddMarks);
                    marksGunnah = Integer.parseInt(retreveGunnahMarks);
                    marksRo = Integer.parseInt(retreveRohMarks);
                    marksAllah = Integer.parseInt(retreveAllahMarks);


                    if (marksHoroh>5){

                        tomijHorofLock.setVisibility(View.INVISIBLE);
                        horofMarksTV.setGravity(1);
                    }
                    if (markTomij>5){

                        horkotLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksHorkot>5){
                        kolkolahLock.setVisibility(View.INVISIBLE);

                    }
                    if (marksKolkola>5){
                        wajibLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksWajib>5){
                        maddLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksMadd>5){
                        gunnahLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksGunnah>5){
                        raPurBarikLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksRo>5){
                        allahPurBarikLock.setVisibility(View.INVISIBLE);
                    }
                    if (marksAllah>5){
                        surahLock.setVisibility(View.INVISIBLE);
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LearnActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });













    }


    private void init() {

        arabicHorof = findViewById(R.id.arabicHorof);
        tomijHorof = findViewById(R.id.tomijHorof);
        horkot = findViewById(R.id.horkot);
        kolkolah = findViewById(R.id.kolkola);
        wajib = findViewById(R.id.wajibGunnah);
        madd = findViewById(R.id.madd);
        gunnah = findViewById(R.id.gunnah);
        raPurBarik = findViewById(R.id.roErNiyom);
        allahPurBarik = findViewById(R.id.allahPorarNiyom);
        surah = findViewById(R.id.Surah);
        tomijHorofLock = findViewById(R.id.arabicTomijHoroflock);
        horkotLock = findViewById(R.id.arabicHorkotlock);
        kolkolahLock = findViewById(R.id.kolkolahlock);
        wajibLock = findViewById(R.id.wajiblock);
        maddLock = findViewById(R.id.maddlock);
        gunnahLock = findViewById(R.id.gunnahlock);
        raPurBarikLock = findViewById(R.id.rolock);
        allahPurBarikLock = findViewById(R.id.allah);
        surahLock = findViewById(R.id.suraLock);
        horofMarksTV = findViewById(R.id.marksHorof);
        tomijMarksTV = findViewById(R.id.marksTomij);
        horkotMarksTV = findViewById(R.id.marksHorkot);
        kolkolaMarksTV = findViewById(R.id.marksKolkola);
        wajibMarksTV  = findViewById(R.id.marksWajib);
        maddMarksTV = findViewById(R.id.marksMadd);
        gunnahMarksTV = findViewById(R.id.marksGunnah);
        roMarksTV = findViewById(R.id.marksRo);
        allahMarksTV = findViewById(R.id.marksAlloh);
        suraMarksTV = findViewById(R.id.marksSura);

    }

    private void SendUserLearnActivityToSurahActivityActivity() {

        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (marksAllah>5){
                    startActivity(new Intent(LearnActivity.this, SuraActivity.class));
                }

            }
        });

    }

    private void SendUserLearnActivityToAllahPurBarikActivity() {

        allahPurBarik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (marksRo>5){
                    startActivity(new Intent(LearnActivity.this,AllahActivity.class));
                }

            }
        });

    }
    private void SendUserLearnActivityToRaPurBarikActivity() {

        raPurBarik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (marksGunnah>5){
                    startActivity(new Intent(LearnActivity.this, Ra_Pur_Barik_Activity.class));
                }
            }
        });
    }
    private void SendUserLearnActivityToGunnaActivity() {

        gunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (marksMadd>5){
                    startActivity(new Intent(LearnActivity.this, GunnahActivity.class));
                }

            }
        });
    }

    private void SendUserLearnActivityToMaddActivity() {

        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (marksWajib>5){
                    startActivity(new Intent(LearnActivity.this, MaddActivity.class));
                }

            }
        });
    }


    private void SendUserLearnActivityToOwajibActivity() {

        wajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (marksKolkola>5){
                    startActivity(new Intent(LearnActivity.this, OwajibActivity.class));
                }


            }
        });


    }

    private void SendUserLearnActivityToKolkolahActivity() {

        kolkolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (marksHorkot>5){
                    startActivity(new Intent(LearnActivity.this, KolkolahActivity.class));
                }

            }
        });
    }

    private void SendUserLearActivityToTomijHorofActivity() {
        tomijHorof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (marksHoroh>5){
                    startActivity(new Intent(LearnActivity.this, TomijHorof.class));
                }



            }
        });

    }
    private void SendUserLearnActivityToHorkotActivity() {

        horkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (markTomij>5){
                    startActivity(new Intent(LearnActivity.this, HorkotActivity.class));
                }


            }
        });
    }

    private void SendUserLearActivityToHorofActivity() {
        arabicHorof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LearnActivity.this,Horof.class));
            }
        });
    }



}
