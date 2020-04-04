package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.soundtest.BlogActivity;
import com.example.soundtest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CourseActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        init();
        BottomNavigationItemSelect();


    }

    private void init() {
        navigationView = findViewById(R.id.bottom_nev);
    }


    private void BottomNavigationItemSelect() {

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case  R.id.main_profile:
                        SendUserToProfileActivity();
                        break;

                    case R.id.main_groups_List:
                        SendUserToGeoupActivity();
                        break;

                    case R.id.all_course_list:

                        SendUsertoCourseActivity();
                        break;


                    case R.id.main_live_list:
                        SendUserToLiveActivity();
                        break;

                    case R.id.main_blog_list:
                        SendUserToBlogActivity();
                        break;



                }
                return false;
            }
        });
    }

    private void SendUserToProfileActivity() {
        startActivity(new Intent(CourseActivity.this, ProfileActivity.class));

    }

    private void SendUserToGeoupActivity() {
        startActivity(new Intent(CourseActivity.this, GroupsActivity.class));

    }

    private void SendUserToLiveActivity() {
        startActivity(new Intent(CourseActivity.this, LiveActivity.class));

    }

    private void SendUserToBlogActivity() {

        startActivity(new Intent(CourseActivity.this, BlogActivity.class));

    }

    private void SendUsertoCourseActivity() {

        startActivity(new Intent(CourseActivity.this, CourseActivity.class));



    }

}
