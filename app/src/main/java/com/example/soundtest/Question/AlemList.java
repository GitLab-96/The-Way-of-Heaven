package com.example.soundtest.Question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class AlemList extends AppCompatActivity {
    private LinearLayout obaidullah,shofikullah,jakaria,muhibbullah,sakhawat,obaydullah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alem_list);
        init();

        obaidullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        shofikullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        jakaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });
        muhibbullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        sakhawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        obaydullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });


    }

    private void init() {


        obaidullah = findViewById(R.id.obaidullah);
        shofikullah = findViewById(R.id.shofikullah);
        jakaria = findViewById(R.id.jakaria);
        muhibbullah= findViewById(R.id.muhibbullah);
        sakhawat = findViewById(R.id.sakhawat);
        obaydullah = findViewById(R.id.obaydullah);
    }

    private void openDialog() {

        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(),"Example dialog");


    }
}
