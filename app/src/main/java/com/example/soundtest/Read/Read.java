package com.example.soundtest.Read;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.soundtest.R;
import com.example.soundtest.Salah.BoysFragment;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Read extends AppCompatActivity {


    ImageView listIV,readIV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        init();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framLayout,new SuraList());
        ft.commit();
        readIV.setVisibility(View.VISIBLE);

        listIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framLayout,new SuraList());
                ft.commit();

                listIV.setVisibility(View.INVISIBLE);
                readIV.setVisibility(View.VISIBLE);

            }
        });

        readIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framLayout,new SuraRead());
                ft.commit();
                readIV.setVisibility(View.INVISIBLE);
                listIV.setVisibility(View.VISIBLE);

            }
        });


    }

    private void init() {

        listIV = findViewById(R.id.toolBarList);
        readIV = findViewById(R.id.toolBarRead);
    }



}
