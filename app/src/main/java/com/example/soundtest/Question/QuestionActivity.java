package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.soundtest.LoginActivity;
import com.example.soundtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private DatabaseReference RootRef;



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
        mAuth=FirebaseAuth.getInstance();
        RootRef= FirebaseDatabase.getInstance().getReference();


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
        startActivity(new Intent(QuestionActivity.this, ProfileActivity.class));

    }

    private void SendUserToBlogActivity() {

        startActivity(new Intent(QuestionActivity.this, BlogActivity.class));

    }

    private void SendUsertoCourseActivity() {

        startActivity(new Intent(QuestionActivity.this, CourseActivity.class));



    }

    private void SendUserToLiveActivity() {

        startActivity(new Intent(QuestionActivity.this, LiveActivity.class));
    }

    private void SendUserToGeoupActivity() {
        startActivity(new Intent(QuestionActivity.this, GroupsActivity.class));

    }


    private void SendQuestionToAnswerPad() {

        sendPadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionActivity.this, AnswarPad.class));


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
                SendUserToFindFriendActivity();
                break;

            case R.id.main_create_group_option:
                RequestNewGroup();
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

    private void SendUserToFindFriendActivity() {
        startActivity(new Intent(QuestionActivity.this, FindFriendActivity.class));

    }

    private void RequestNewGroup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this,R.style.AlertDialog);
        builder.setTitle("Enter Group Name");

        final EditText groupnameField = new EditText(QuestionActivity.this);
        groupnameField.setHint("e.g Coding Cafe");
        builder.setView(groupnameField);

        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String groupName = groupnameField.getText().toString();

                if (TextUtils.isEmpty(groupName)){

                    Toast.makeText(QuestionActivity.this, "Please write Group Name", Toast.LENGTH_SHORT).show();

                }
                else {

                    CreateNewGroup(groupName);

                }

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               dialog.cancel();

            }
        });

        builder.show();


    }

    private void CreateNewGroup(final String groupName) {

        RootRef.child("Groups").child(groupName).setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                
                if (task.isSuccessful()){
                    Toast.makeText(QuestionActivity.this, groupName +"is Created Successfully.....", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    private void SendUserToLoginActivity() {
        startActivity(new Intent(QuestionActivity.this, LoginActivity.class));
    }

    private void SendUserToSettingsActivity(){
        startActivity(new Intent(QuestionActivity.this, SettingsActivity.class));
    }


}
