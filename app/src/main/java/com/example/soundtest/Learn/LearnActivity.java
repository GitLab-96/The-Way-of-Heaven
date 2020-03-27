package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.soundtest.R;

public class LearnActivity extends AppCompatActivity {
    private TextView arabicHorof,tomijHorof;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        init();

        SendUserLearActivityToHorofActivity();
        SendUserLearActivityToTomijHorofActivity();


    }

    private void init() {

        arabicHorof = findViewById(R.id.arabicHorof);
        tomijHorof = findViewById(R.id.tomijHorof);
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
