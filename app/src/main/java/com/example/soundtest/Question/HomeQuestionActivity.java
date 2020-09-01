package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.soundtest.LoginActivity;
import com.example.soundtest.R;
import com.example.soundtest.Salah.BoysFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeQuestionActivity extends AppCompatActivity {

     BottomNavigationView navigationView;
     private Toolbar mtoolbar;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_question);


        init();
        BottomNavigationItemSelect();
        mtoolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mtoolbar);
        mAuth = FirebaseAuth.getInstance();
        mAuth=FirebaseAuth.getInstance();
        RootRef= FirebaseDatabase.getInstance().getReference();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.homeQuestionFramLayout,new QuestionFragment());
        ft.commit();


    }

    private void init() {
        navigationView = findViewById(R.id.question_home_bottom_nev);
    }

    private void BottomNavigationItemSelect() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case  R.id.main_home_question_List:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.homeQuestionFramLayout,new QuestionFragment());
                        ft.commit();
                        mtoolbar.setVisibility(View.VISIBLE);
                        break;

                    case R.id.main_profile_List:
                        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.homeQuestionFramLayout,new ProfileFragment());

                        ft1.commit();
                        mtoolbar.setVisibility(View.GONE);
                        break;

                    case R.id.all_course_list:
                        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.homeQuestionFramLayout,new CourseFragment());
                        ft2.commit();
                        mtoolbar.setVisibility(View.GONE);
                        break;


                    case R.id.main_live_list:

                        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.homeQuestionFramLayout,new LiveFragment());
                        ft3.commit();
                        mtoolbar.setVisibility(View.GONE);
                        break;

                    case R.id.main_blog_list:

                        FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                        ft4.replace(R.id.homeQuestionFramLayout,new BlogFragment());
                        ft4.commit();
                        mtoolbar.setVisibility(View.GONE);
                        break;
                }
                return false;
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

            case R.id.main_setting_option:
                SendUserToSettingsActivity();
                Toast.makeText(this, "Your Setting Option", Toast.LENGTH_SHORT).show();

                break;

            case R.id.main_share_app_option:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                String subject = "App Sharing Practice";
                String body = "I am Sumon";
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(intent,"share with"));
                break;

            case R.id.main_contact_us_option:

                startActivity(new Intent(HomeQuestionActivity.this,AboutActivity.class));
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
        startActivity(new Intent(HomeQuestionActivity.this, LoginActivity.class));
    }
    private void SendUserToSettingsActivity(){
        startActivity(new Intent(HomeQuestionActivity.this, SettingsActivity.class));
    }
}
