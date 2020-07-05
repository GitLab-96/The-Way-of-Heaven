package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScholarsAnswerActivity extends AppCompatActivity {

    private EditText typeAnswerET;
    private ImageView sendAnswerButtn;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<TypeQuestionClass> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholars_answer);


        typeAnswerET = findViewById(R.id.typeAnswerET);
        sendAnswerButtn = findViewById(R.id.sendAnswernBttn);
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<TypeQuestionClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("Question");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    TypeQuestionClass p = dataSnapshot1.getValue(TypeQuestionClass.class);
                    list.add(p);
                }
                adapter = new MyAdapter(ScholarsAnswerActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(ScholarsAnswerActivity.this, "Opps......", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
