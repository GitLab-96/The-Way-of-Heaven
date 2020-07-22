package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Locale;

public class Horof extends AppCompatActivity {
    private TabLayout horofTabLayout;
    private ViewPager horofviewPager;
    private HorofAccessAdapter horofAccessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horof);

        horofTabLayout = findViewById(R.id.horof_main_tabs);
        horofviewPager = findViewById(R.id.horofViewPager);
        horofAccessAdapter = new HorofAccessAdapter(getSupportFragmentManager());
        horofviewPager.setAdapter(horofAccessAdapter);
        horofTabLayout.setupWithViewPager(horofviewPager);

    }

}
