package com.example.soundtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.soundtest.Question.CourseActivity;
import com.example.soundtest.Question.GroupsActivity;
import com.example.soundtest.Question.LiveActivity;
import com.example.soundtest.Question.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BlogActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private Button link1Bttn,link2Bttn,link3Bttn,link4Bttn,link5Bttn,link6Bttn,link7Bttn,link8Bttn,link9Bttn,link10Bttn;
    private Intent intent,chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        init();
        BottomNavigationItemSelect();
        click();
    }

    private void click() {

        link1Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://islamshikka.blogspot.com/p/blog-page_10.html"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link2Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://prootisruti.blogspot.com/2018/10/blog-post.html"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link3Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link4Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/results?search_query=quran+shikkha+bangla+tutorial+"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link5Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://islamshikka.blogspot.com/p/blog-page_10.html"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link6Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://prootisruti.blogspot.com/2018/10/blog-post.html"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link7Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link8Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/results?search_query=quran+shikkha+bangla+tutorial+"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });
        link9Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });

        link10Bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/results?search_query=quran+shikkha+bangla+tutorial+"));
                chooser = Intent.createChooser(intent,"Youtube");
                startActivity(chooser);

            }
        });


    }

    private void init() {
        navigationView = findViewById(R.id.bottom_nev);
        link1Bttn    =  findViewById(R.id.link1Btn);
        link2Bttn    =  findViewById(R.id.link2Btn);
        link3Bttn    =  findViewById(R.id.link3Btn);
        link4Bttn    =  findViewById(R.id.link4Btn);
        link5Bttn    =  findViewById(R.id.link5Btn);
        link6Bttn    =  findViewById(R.id.link6Btn);
        link7Bttn    =  findViewById(R.id.link7Btn);
        link8Bttn    =  findViewById(R.id.link8Btn);
        link9Bttn    =  findViewById(R.id.link9Btn);
        link10Bttn    =  findViewById(R.id.link10Btn);

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
        startActivity(new Intent(BlogActivity.this, ProfileActivity.class));

    }

    private void SendUserToGeoupActivity() {
        startActivity(new Intent(BlogActivity.this, GroupsActivity.class));

    }

    private void SendUserToLiveActivity() {
        startActivity(new Intent(BlogActivity.this, LiveActivity.class));

    }

    private void SendUserToBlogActivity() {

        startActivity(new Intent(BlogActivity.this, BlogActivity.class));

    }

    private void SendUsertoCourseActivity() {

        startActivity(new Intent(BlogActivity.this, CourseActivity.class));



    }

}
