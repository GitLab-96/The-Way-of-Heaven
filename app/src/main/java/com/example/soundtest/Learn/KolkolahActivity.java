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

public class KolkolahActivity extends AppCompatActivity {

    private TabLayout kolkolaTabLayout;
    private ViewPager kolkolahorofviewPager;
    private KolkolaAccessAdapter kolkolaAccessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkolah);
        kolkolaTabLayout = findViewById(R.id.kolkola_main_tabs);
        kolkolahorofviewPager = findViewById(R.id.kolkolaViewPager);
        kolkolaAccessAdapter = new KolkolaAccessAdapter(getSupportFragmentManager());
        kolkolahorofviewPager.setAdapter(kolkolaAccessAdapter);
        kolkolaTabLayout.setupWithViewPager(kolkolahorofviewPager);



    }

}
