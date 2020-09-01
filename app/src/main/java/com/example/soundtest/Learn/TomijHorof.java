package com.example.soundtest.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class TomijHorof extends AppCompatActivity {

    private TabLayout tomijhorofTabLayout;
    private ViewPager tomijhorofviewPager;
    private TomijHorofAccessAdapter  tomijHorofAccessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomij_horof);

        tomijhorofTabLayout = findViewById(R.id.tomij_horof_main_tabs);
        tomijhorofviewPager = findViewById(R.id.tomijhorofViewPager);
        tomijHorofAccessAdapter = new TomijHorofAccessAdapter(getSupportFragmentManager());
        tomijhorofviewPager.setAdapter(tomijHorofAccessAdapter);
        tomijhorofTabLayout.setupWithViewPager(tomijhorofviewPager);

    }


}
