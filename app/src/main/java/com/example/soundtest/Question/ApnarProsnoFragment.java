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
public class ApnarProsnoFragment extends Fragment {

    DatabaseReference reference;
    RecyclerView apnar_proshno_recyclerView;
    ArrayList<TypeQuestionClass> list;
    ApnarProshnoAdapter apnarProshnoAdapter;




    public ApnarProsnoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_apnar_prosno, container, false);

        apnar_proshno_recyclerView = view.findViewById(R.id.apnarProshnoRecylerView);
       // apnar_proshno_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        apnar_proshno_recyclerView.setLayoutManager(layoutManager);

         list = new ArrayList<TypeQuestionClass>();
        reference = FirebaseDatabase.getInstance().getReference().child("Question");



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    TypeQuestionClass p = dataSnapshot1.getValue(TypeQuestionClass.class);
                    list.add(p);
                }
                apnarProshnoAdapter = new ApnarProshnoAdapter(getContext(),list);
                apnar_proshno_recyclerView.setAdapter(apnarProshnoAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Opps......", Toast.LENGTH_SHORT).show();
            }
        });



    return view;
    }

}
