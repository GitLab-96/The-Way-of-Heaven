package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.soundtest.LoginActivity;
import com.example.soundtest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class QuestionActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private ViewPager myviewPager;
    private TabLayout myTabLayout;
    private TeastAccessAdapter myteastAccessAdapter;
    private FirebaseAuth mAuth;
    private LinearLayout sendPadLayout;
    private EditText typeMassage;
    private BottomNavigationView navigationView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        navigationView=findViewById(R.id.bottom_nev);
        mtoolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mtoolbar);
        myviewPager = findViewById(R.id.main_tab_Pager);
        myteastAccessAdapter = new TeastAccessAdapter(getSupportFragmentManager());
        myviewPager.setAdapter(myteastAccessAdapter);
        myTabLayout = findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myviewPager );
        mAuth = FirebaseAuth.getInstance();


        init();
        SendQuestionToAnswerPad();
        BottomNavigationItemSelect();
        typeMassage();

        floatingBtn();


    }

    private void init() {
        typeMassage = findViewById(R.id.typeMassage);
        sendPadLayout = findViewById(R.id.sendPad);
        fab = findViewById(R.id.floatingActionBtn);
    }

    private void floatingBtn() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionActivity.this,AnswarPad.class));
            }
        });

    }



    private void typeMassage() {
     typeMassage.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(QuestionActivity.this,AnswarPad.class));
         }
     });
    }

    private void BottomNavigationItemSelect() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.main_chat_group_list:
                        startActivity(new Intent(QuestionActivity.this, ProfileActivity.class));
                        break;

                    case R.id.main_chat_List:
                        startActivity(new Intent(QuestionActivity.this,AnswarPad.class));
                        break;
                }
                return false;
            }
        });

    }

    private void SendQuestionToAnswerPad() {

        sendPadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionActivity.this,AnswarPad.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.main_find_friends_option:
                Toast.makeText(this, "Find Your Friend", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_create_group_option:
                Toast.makeText(this, "Create Your Group", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_setting_option:
                Toast.makeText(this, "Your Setting Option", Toast.LENGTH_SHORT).show();
                SendUserToSettingsActivity();
                break;
            case R.id.main_logout_option:
                mAuth.signOut();
                SendUserToLoginActivity();
                Toast.makeText(this, "Your Logout Option", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void SendUserToLoginActivity() {
        startActivity(new Intent(QuestionActivity.this, LoginActivity.class));
    }

    private void SendUserToSettingsActivity(){
        startActivity(new Intent(QuestionActivity.this, SettingsActivity.class));
    }


}
