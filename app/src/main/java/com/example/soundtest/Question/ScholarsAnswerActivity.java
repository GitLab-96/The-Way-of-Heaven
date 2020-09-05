package com.example.soundtest.Question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

public class ScholarsAnswerActivity extends AppCompatActivity {


    private TabLayout scholars_TabLayout;
    private ViewPager scholars_viewPager;
    private ScholarsAccessAdapter scholars_AccessAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholars_answer);


        scholars_TabLayout = findViewById(R.id.Scholars_main_tabs);
        scholars_viewPager = findViewById(R.id.scholarsViewPager);
        scholars_AccessAdapter = new ScholarsAccessAdapter(getSupportFragmentManager());
        scholars_viewPager.setAdapter(scholars_AccessAdapter);
        scholars_TabLayout.setupWithViewPager(scholars_viewPager);




    }
}
