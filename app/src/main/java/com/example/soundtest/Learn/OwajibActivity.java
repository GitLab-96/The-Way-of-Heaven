package com.example.soundtest.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class OwajibActivity extends AppCompatActivity {

    private TabLayout wajibTabLayout;
    private ViewPager wajibviewPager;
    private  WajibAccessAdapter wajibAccessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owajib);

        wajibTabLayout = findViewById(R.id.wajib_main_tabs);
        wajibviewPager = findViewById(R.id.wajibViewPager);
        wajibAccessAdapter = new WajibAccessAdapter(getSupportFragmentManager());
        wajibviewPager.setAdapter(wajibAccessAdapter);
        wajibTabLayout.setupWithViewPager(wajibviewPager);


    }

}


