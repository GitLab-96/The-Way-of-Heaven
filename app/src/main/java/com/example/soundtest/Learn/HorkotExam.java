package com.example.soundtest.Learn;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorkotExam extends Fragment {

    private ImageButton examNextBtn,examMicBtn;
    private static TextView your_marks;
    private TextView MCQ;
    private TextView oral;
    private ImageSwitcher imageSwitcherOralQuestion;
    private TextSwitcher textSwitchermultipleExam,textSwitcherPronunciation,answerTextSwitcher;
    private Typeface typeface;
    private RadioGroup radioGroup;
    private RadioButton option1,option2,option3,option4,option5,option6,option7,option8,option9,option10;
    private TextView userVoiceConvert;
    MediaPlayer goodToast,badToast;

    TextView textView1;

    String text=null;
    int position = -1;
    private int current_marks = 0;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;


    String[] multipleQuestion = {
            "হরকত কাকে বলে ?",
            "হরকত কয়টি ? ",
            "হরকতের উচ্চারণ কিভাবে করিতে হয় ? ",
            " তানভিন কাকে বলে ?",
            " তানভিনের ভিতরে কি লুকানো আছে ?",
            " কোনটি হরকত ?",
            " কোনটি তানভিন ?",
            " কোনটি যবর ?",
            " কোনটি যের ?",
            " কোনটি পেশ ?",
    };
    String[] presetMultipleAnswer = {
            "এক যবর , এক যের , এক পেশ কে ।",
            " ৩ টি।",
            " তারাতারি ",
            "দুই যবর, দুই যের , দুই পেশ কে ",
            "নুন আছে ",
            "এক যের",
            "দুই পেশ",
            "(ﹹ)",
            "(ﹷ)",
            "(ﹻ)",
    };

    int[] horof = {
            R.drawable.basao,
            R.drawable.dakhola,
            R.drawable.hasada,
            R.drawable.jaala,
            R.drawable.jahaba,
            R.drawable.wajada,
            R.drawable.wahaba,
            R.drawable.sabako,
            R.drawable.walad,
            R.drawable.najaa,

    };
    String[] presetpronunciation = {
            "بسطہ",
            "دخل",
            "حسدا",
            "جعل",
            "ذهب",
            "وجد",
            "وهب",
            "سبق",
            "ولد",
            "نزع",
    };


    public HorkotExam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horkot_exam, container, false);


        examNextBtn = view.findViewById(R.id.examNextBttn);
        examMicBtn = view.findViewById(R.id.examMicBtn);
        imageSwitcherOralQuestion = view.findViewById(R.id.imageSwitcherOralQuestion);
        textSwitchermultipleExam = view.findViewById(R.id.multipleQuestionSwitcer);
        textSwitcherPronunciation = view.findViewById(R.id.testSwitcherPronunciation);
        answerTextSwitcher = view.findViewById(R.id.multipleAnsTS);
        your_marks = view.findViewById(R.id.your_marks);
        MCQ = view.findViewById(R.id.multiplechoicetest);
        oral = view.findViewById(R.id.oralexam);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"alexbrush_regular.ttf");
        MCQ.setTypeface(typeface);
        oral.setTypeface(typeface);
        userVoiceConvert = view.findViewById(R.id.userVoice);

        radioGroup = view.findViewById(R.id.radioGroup);
        option1 = view.findViewById(R.id.option1);
        option2 = view.findViewById(R.id.option2);
        option3 = view.findViewById(R.id.option3);
        option4 = view.findViewById(R.id.option4);
        option5 = view.findViewById(R.id.option5);
        option6 = view.findViewById(R.id.option6);
        option7 = view.findViewById(R.id.option7);
        option8 = view.findViewById(R.id.option8);
        option9 = view.findViewById(R.id.option9);
        option10 = view.findViewById(R.id.option10);


        textView1=view.findViewById(R.id.selectedItemtextView);

        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        RadioButtonClick();
        SwitcherTask();

        ButtonClick();







        return view;
    }

    private void ButtonClick() {

        examNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if((position<multipleQuestion.length-1)){

                    position = position+1;
                    String SelectTV = textView1.getText().toString();

                    TextView MCQAnswr = (TextView) answerTextSwitcher.getCurrentView();
                    String mcq_answer = MCQAnswr.getText().toString();
                    Toast.makeText(getContext(), ""+SelectTV, Toast.LENGTH_SHORT).show();
                    TextView sentanceOne = (TextView) textSwitcherPronunciation.getCurrentView();
                    String sentanceOnee = sentanceOne.getText().toString();
                    String sentenceTwoo = userVoiceConvert.getText().toString();

                    if (SelectTV.equals(mcq_answer) && sentanceOnee.equals(sentenceTwoo)) {

                        current_marks = current_marks+2;
                        your_marks.setText(""+current_marks);
                        goodToast.start();

                    }
                    else if (SelectTV.equals(mcq_answer)){

                        current_marks = current_marks+1;
                        your_marks.setText(""+current_marks);
                        goodToast.start();
                    }
                    else if (sentanceOnee.equals(sentenceTwoo)){

                        current_marks = current_marks+1;
                        your_marks.setText(""+current_marks);
                        goodToast.start();
                    }
                    else {
                        if (current_marks>0){
                            current_marks = current_marks-1;
                            your_marks.setText(""+current_marks);
                            badToast.start();
                        }
                    }
                    textSwitchermultipleExam.setText(multipleQuestion[position]);
                    answerTextSwitcher.setText(presetMultipleAnswer[position]);
                    textSwitcherPronunciation.setText(presetpronunciation[position]);
                    imageSwitcherOralQuestion.setBackgroundResource(horof[position]);
                }
            }
        });
        examMicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ar-JO");

                try {
                    startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
                }catch (Exception e){

                }
            }
        });


    }

    private void SwitcherTask() {

        imageSwitcherOralQuestion.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                imageSwitcherOralQuestion.setBackgroundResource(R.drawable.seen);
                return imageView;
            }
        });

        textSwitchermultipleExam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.START);
                textView.setText("আরবি হরফ কয়টি ?");
                return textView;
            }
        });

        answerTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.START);
                textView.setText("29");
                return textView;
            }
        });

        textSwitcherPronunciation.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.START);
                textView.setText("আরবি হরফ কয়টি ?");
                return textView;
            }
        });

    }

    private void RadioButtonClick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.option1:
                        text = option1.getText().toString();

                        break;
                    case R.id.option2:
                        text = option2.getText().toString();

                        break;
                    case R.id.option3:
                        text = option3.getText().toString();

                        break;
                    case R.id.option4:
                        text = option4.getText().toString();

                        break;
                    case R.id.option5:
                        text = option5.getText().toString();

                        break;
                    case R.id.option6:
                        text = option6.getText().toString();

                        break;
                    case R.id.option7:
                        text = option7.getText().toString();

                        break;
                    case R.id.option8:
                        text = option8.getText().toString();

                        break;
                    case R.id.option9:
                        text = option9.getText().toString();

                        break;
                    case R.id.option10:
                        text = option10.getText().toString();

                        break;

                    default:
                        break;
                }


                textView1.setText(text);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case  REQUEST_CODE_SPEECH_INPUT:{

                if(resultCode == RESULT_OK && null!= data){

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userVoiceConvert.setText(result.get(0));
                }
                break;
            }
        }
    }


}
