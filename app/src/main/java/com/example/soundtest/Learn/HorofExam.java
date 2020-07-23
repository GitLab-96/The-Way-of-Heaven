package com.example.soundtest.Learn;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorofExam extends Fragment {

    private ImageButton examNextBtn,examMicBtn;
    private TextView your_marks;
    ImageSwitcher imageSwitcherOralQuestion;
    TextSwitcher textSwitchermultipleExam,textSwitcherOralQuestion;

    public HorofExam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_horof_exam, container, false);


        examNextBtn = view.findViewById(R.id.examNextBttn);
        examMicBtn = view.findViewById(R.id.examMicBtn);
        imageSwitcherOralQuestion = view.findViewById(R.id.imageSwitcherOralQuestion);
        textSwitchermultipleExam = view.findViewById(R.id.multipleQuestionSwitcer);
        textSwitcherOralQuestion = view.findViewById(R.id.textSwitcherOralQuestion);
        your_marks = view.findViewById(R.id.your_marks);

        textSwitchermultipleExam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.LEFT);
                textView.setText("আরবি হরফ কয়টি ?");
                return textView;
            }
        });

        textSwitcherOralQuestion.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.LEFT);
                textView.setText("নিচের হরফটির নাম কি ?");
                return textView;
            }
        });

        imageSwitcherOralQuestion.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));

                imageSwitcherOralQuestion.setBackgroundResource(R.drawable.ba);
                return imageView;
            }
        });



    return view;
    }

}
