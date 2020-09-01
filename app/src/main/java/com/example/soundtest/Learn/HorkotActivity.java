package com.example.soundtest.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class HorkotActivity extends AppCompatActivity {
    private TabLayout horofTabLayout;
    private ViewPager horofviewPager;
    private HorkotAccessAdapter horkotAccessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horkot);

        horofTabLayout = findViewById(R.id.horof_main_tabs);
        horofviewPager = findViewById(R.id.horofViewPager);
        horkotAccessAdapter = new HorkotAccessAdapter(getSupportFragmentManager());
        horofviewPager.setAdapter(horkotAccessAdapter);
        horofTabLayout.setupWithViewPager(horofviewPager);

    }


}
