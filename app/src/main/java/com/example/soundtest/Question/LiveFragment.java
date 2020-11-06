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

import com.example.soundtest.Question.Scholer.ScholarsLiveClass;
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
public class LiveFragment extends Fragment {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ScholarsLiveClass> live_list;
    LiveAdapter adapter;

    public LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        recyclerView = view.findViewById(R.id.liveRecylerView);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

         live_list = new ArrayList<ScholarsLiveClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("Live");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    ScholarsLiveClass p = dataSnapshot1.getValue(ScholarsLiveClass.class);
                    live_list.add(p);
                }
                adapter = new LiveAdapter(getContext(),live_list);
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
