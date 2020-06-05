package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class Ra_Pur_Barik_Activity extends AppCompatActivity {
    private TabLayout raTabLayout;
    private ViewPager raviewPager;
    private RaAccessAdapter raAccessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra__pur__barik_);

        raTabLayout = findViewById(R.id.ra_main_tabs);
        raviewPager = findViewById(R.id.raViewPager);
        raAccessAdapter = new RaAccessAdapter(getSupportFragmentManager());
        raviewPager.setAdapter(raAccessAdapter);
        raTabLayout.setupWithViewPager(raviewPager);




    }
}
