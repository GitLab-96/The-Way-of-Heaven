package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.Learn.Ek_Alif_Access_Adapter;
import com.example.soundtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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
