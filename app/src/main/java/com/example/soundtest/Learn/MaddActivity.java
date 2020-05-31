package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.soundtest.Question.TeastAccessAdapter;
import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class MaddActivity extends AppCompatActivity {

    private TabLayout maddTabLayout;
    private ViewPager maddviewPager;
    private MaddAccessAdapter maddAccessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madd);

        maddTabLayout = findViewById(R.id.madd_main_tabs);
        maddviewPager = findViewById(R.id.maddViewPager);
        maddAccessAdapter = new MaddAccessAdapter(getSupportFragmentManager());
        maddviewPager.setAdapter(maddAccessAdapter);
        maddTabLayout.setupWithViewPager(maddviewPager);



    }
}
