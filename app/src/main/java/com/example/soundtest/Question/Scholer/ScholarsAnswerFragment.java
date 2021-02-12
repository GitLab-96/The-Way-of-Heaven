package com.example.soundtest.Question.Scholer;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.soundtest.Question.MyAdapter;
import com.example.soundtest.Question.TypeQuestionClass;
import com.example.soundtest.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScholarsAnswerFragment extends Fragment {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<TypeQuestionClass> list;
    MyAdapter adapter;
    public ScholarsAnswerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_scholars_answer, container, false);



        recyclerView = view.findViewById(R.id.myRecycler);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<TypeQuestionClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("Question");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){


                    String answer = dataSnapshot1.child("typeAnswer").getValue(String.class);


                        TypeQuestionClass p = dataSnapshot1.getValue(TypeQuestionClass.class);
                        list.add(p);


                }
                adapter = new MyAdapter(getContext(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Opps......", Toast.LENGTH_SHORT).show();
            }
        });

    return view;
    }

}
