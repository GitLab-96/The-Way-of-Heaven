package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.soundtest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LiveActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        init();

        BottomNavigationItemSelect();
    }

    private void init() {
        navigationView=findViewById(R.id.bottom_nev);
    }

    private void BottomNavigationItemSelect() {

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.main_profile:
                        startActivity(new Intent(LiveActivity.this, ProfileActivity.class));
                        break;

                    case R.id.all_answer_list:

                        startActivity(new Intent(LiveActivity.this, QuestionActivity.class));

                        break;

                    case R.id.main_groups_List:
                        startActivity(new Intent(LiveActivity.this, GroupsActivity.class));
                        break;

                    case R.id.main_live_list:

                        break;


                }
                return false;
            }
        });
    }
}
