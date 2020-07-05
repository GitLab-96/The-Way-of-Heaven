package com.example.soundtest.Question;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.soundtest.Learn.AllahAccessAdapter;
import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private EditText typeQusetionET;
    private ImageView sendQuestionBttn;
    private TabLayout questionTabLayout;
    private ViewPager quetionviewPager;
    private QuestionAccessAdapter questionAccessAdapter;
    private String currentUserID;
    public FirebaseAuth mAuth;
    private DatabaseReference questionRef;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        questionRef= FirebaseDatabase.getInstance().getReference("Question");
        questionTabLayout = view.findViewById(R.id.question_main_tabs);
        quetionviewPager = view.findViewById(R.id.questionViewPager);
        questionAccessAdapter = new QuestionAccessAdapter(getChildFragmentManager());
        quetionviewPager.setAdapter(questionAccessAdapter);
        questionTabLayout.setupWithViewPager(quetionviewPager);
        typeQusetionET = view.findViewById(R.id.typeQuestionET);
        sendQuestionBttn = view.findViewById(R.id.sendQuestionBttn);
        mAuth=FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();

        sendQuestionBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String setUserQuestion = typeQusetionET.getText().toString();

                String setUserAnswer = typeQusetionET.getText().toString();

                if (TextUtils.isEmpty(setUserQuestion)) {

                    Toast.makeText(getContext(), "Please Write your User Question First...", Toast.LENGTH_SHORT).show();
                }

                else {


                    String key = questionRef.push().getKey();
                    TypeQuestionClass typeQuestionClass = new TypeQuestionClass(setUserQuestion,setUserAnswer);

                    questionRef.child(key).setValue(typeQuestionClass);


                }

                typeQusetionET.setText("");
            }
        });



   return view;
    }

}
