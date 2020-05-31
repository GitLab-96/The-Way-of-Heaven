package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.soundtest.R;

public class LearnActivity extends AppCompatActivity {
    private TextView arabicHorof,tomijHorof,horkot,kolkolah,wajib,madd;



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

    }




    private void init() {

        arabicHorof = findViewById(R.id.arabicHorof);
        tomijHorof = findViewById(R.id.tomijHorof);
        horkot = findViewById(R.id.horkot);
        kolkolah = findViewById(R.id.kolkola);
        wajib = findViewById(R.id.wajibGunnah);
        madd = findViewById(R.id.madd);
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
                startActivity(new Intent(LearnActivity.this, TomijHorof.class));
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
