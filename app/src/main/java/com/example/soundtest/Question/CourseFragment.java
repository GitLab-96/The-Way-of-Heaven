package com.example.soundtest.Question;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.soundtest.Question.Scholer.CourseScholerAdapter;
import com.example.soundtest.Question.Scholer.ScholersCourseClass;
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
public class CourseFragment extends Fragment {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ScholersCourseClass> course_list;
    CourseAdapter adapter;

    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=  inflater.inflate(R.layout.fragment_course, container, false);


        recyclerView = view.findViewById(R.id.courseRecylerView);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

         course_list = new ArrayList<ScholersCourseClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("Course");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    ScholersCourseClass p = dataSnapshot1.getValue(ScholersCourseClass.class);
                    course_list.add(p);
                }
                adapter = new CourseAdapter(getContext(),course_list);
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
