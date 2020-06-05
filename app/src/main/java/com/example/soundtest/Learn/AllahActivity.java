package com.example.soundtest.Learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class AllahActivity extends AppCompatActivity {

    private TabLayout allahTabLayout;
    private ViewPager allahviewPager;
    private AllahAccessAdapter allahAccessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allah);

        allahTabLayout = findViewById(R.id.allah_main_tabs);
        allahviewPager = findViewById(R.id.allahViewPager);
         allahAccessAdapter = new AllahAccessAdapter(getSupportFragmentManager());
        allahviewPager.setAdapter(allahAccessAdapter);
        allahTabLayout.setupWithViewPager(allahviewPager);

    }
}
