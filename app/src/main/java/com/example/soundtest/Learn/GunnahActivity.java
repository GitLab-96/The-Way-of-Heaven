package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class GunnahActivity extends AppCompatActivity {

    private TabLayout gunnahTabLayout;
    private ViewPager gunnahviewPager;
    private GunnahAccessAdapter gunnahAccessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunnah);

        gunnahTabLayout = findViewById(R.id.gunnah_main_tabs);
        gunnahviewPager = findViewById(R.id.gunnahViewPager);
        gunnahAccessAdapter = new GunnahAccessAdapter(getSupportFragmentManager());
        gunnahviewPager.setAdapter(gunnahAccessAdapter);
        gunnahTabLayout.setupWithViewPager(gunnahviewPager);


    }
}
