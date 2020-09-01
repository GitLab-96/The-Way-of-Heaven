package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soundtest.R;

public class LearnActivity extends AppCompatActivity {
    private TextView arabicHorof,tomijHorof,horkot,kolkolah,wajib,madd,gunnah,raPurBarik,allahPurBarik,surah;
    private ImageView arabicHorofLock,tomijHorofLock,horkotLock,kolkolahLock,wajibLock,maddLock,gunnahLock,raPurBarikLock,allahPurBarikLock,surahLock;

    int mark=18;

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




        if (mark>15){

            tomijHorofLock.setVisibility(View.INVISIBLE);
        }

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
    }

    private void SendUserLearnActivityToSurahActivityActivity() {

        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, SuraActivity.class));
            }
        });

    }

    private void SendUserLearnActivityToAllahPurBarikActivity() {

        allahPurBarik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this,AllahActivity.class));
            }
        });

    }
    private void SendUserLearnActivityToRaPurBarikActivity() {

        raPurBarik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, Ra_Pur_Barik_Activity.class));
            }
        });
    }
    private void SendUserLearnActivityToGunnaActivity() {

        gunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LearnActivity.this, GunnahActivity.class));
            }
        });
    }




    private void SendUserLearnActivityToMaddActivity() {

        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, MaddActivity.class));
            }
        });
    }

    private void SendUserLearnActivityToHorkotActivity() {

        horkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, HorkotActivity.class));
            }
        });
    }

    private void SendUserLearnActivityToOwajibActivity() {

        wajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LearnActivity.this, OwajibActivity.class));

            }
        });


    }

    private void SendUserLearnActivityToKolkolahActivity() {

        kolkolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, KolkolahActivity.class));
            }
        });
    }

    private void SendUserLearActivityToTomijHorofActivity() {
        tomijHorof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mark>15){

                    startActivity(new Intent(LearnActivity.this, TomijHorof.class));
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
