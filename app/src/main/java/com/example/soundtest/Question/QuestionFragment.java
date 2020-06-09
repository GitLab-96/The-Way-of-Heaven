package com.example.soundtest.Question;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soundtest.Learn.AllahAccessAdapter;
import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private TabLayout questionTabLayout;
    private ViewPager quetionviewPager;
    private QuestionAccessAdapter questionAccessAdapter;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        questionTabLayout = view.findViewById(R.id.question_main_tabs);
        quetionviewPager = view.findViewById(R.id.questionViewPager);
        questionAccessAdapter = new QuestionAccessAdapter(getChildFragmentManager());
        quetionviewPager.setAdapter(questionAccessAdapter);
        questionTabLayout.setupWithViewPager(quetionviewPager);



   return view;
    }

}
