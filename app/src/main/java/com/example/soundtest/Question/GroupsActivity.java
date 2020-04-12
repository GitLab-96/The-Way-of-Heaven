package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.soundtest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupsActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ListView list_view;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String>list_of_group = new ArrayList<>();
    private DatabaseReference GroupRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        GroupRef = FirebaseDatabase.getInstance().getReference().child("Groups");

        init();

        RetrieveAndDisplayGroup();
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String currentGroupName = adapterView.getItemAtPosition(position).toString();

                Intent groupChatIntent = new Intent(GroupsActivity.this, GroupChatActivity.class);
                groupChatIntent.putExtra("groupName",currentGroupName);
                startActivity(groupChatIntent);

            }
        });

        BottomNavigationItemSelect();





    }



    private void init() {

        navigationView=findViewById(R.id.bottom_nev);

        list_view =findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_of_group);
        list_view.setAdapter(arrayAdapter);
    }

    private void RetrieveAndDisplayGroup() {

GroupRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        Set<String> set = new HashSet<>();
        Iterator iterator = dataSnapshot.getChildren().iterator();

        while (iterator.hasNext()){

            set.add(((DataSnapshot)iterator.next()).getKey());

        }

        list_of_group.clear();
        list_of_group.addAll(set);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

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
        startActivity(new Intent(GroupsActivity.this, ProfileActivity.class));

    }

    private void SendUserToGeoupActivity() {
        startActivity(new Intent(GroupsActivity.this, GroupsActivity.class));

    }

    private void SendUserToLiveActivity() {
        startActivity(new Intent(GroupsActivity.this, LiveActivity.class));

    }

    private void SendUserToBlogActivity() {

        startActivity(new Intent(GroupsActivity.this, BlogActivity.class));

    }

    private void SendUsertoCourseActivity() {

        startActivity(new Intent(GroupsActivity.this, CourseActivity.class));



    }

}
