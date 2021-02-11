package com.example.soundtest.Salah;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.soundtest.R;
import com.example.soundtest.Salah.BoysFragment;
import com.example.soundtest.Salah.GirlsFragment;

public class SalahActivity extends AppCompatActivity {

    LinearLayout boys,girls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah);

        boys = findViewById(R.id.boysLayout);
        girls = findViewById(R.id.girlslayout);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framLayout,new BoysFragment());
        ft.commit();

        boys.getResources().getColor(R.color.colorAccent);
        girls.getResources().getDrawable(R.drawable.bounarydesign);

        boys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framLayout,new BoysFragment());
                ft.commit();

                boys.getResources().getColor(R.color.colorAccent);
                girls.getResources().getDrawable(R.drawable.bounarydesign);


            }
        });

        girls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framLayout,new GirlsFragment());
                ft.commit();

                girls.getResources().getColor(R.color.colorAccent);
                boys.getResources().getDrawable(R.drawable.bounarydesign);
            }
        });


   }
}
