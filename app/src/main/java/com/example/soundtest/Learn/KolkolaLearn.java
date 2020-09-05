package com.example.soundtest.Learn;


import android.content.Intent;
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
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class KolkolaLearn extends Fragment {


    private ImageSwitcher topSwitcherkolkolah,leftSwitcherkolkolah,rightSwitcherkolkolah,middleSwitcherkolkolah;
    private TextSwitcher kolkolawordpronunciationTS;
    private ImageButton previousBtn,replayBtn,nextBtn,micBtn,compareBttn;
    TextView userVoiceText;
    MediaPlayer kolkolaMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    int[] kolkolaTopImage = {
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,

            R.drawable.attkolkolah,
            R.drawable.attkolkolah,
            R.drawable.attkolkolah,
            R.drawable.attkolkolah,

            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,

            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,

            R.drawable.addkolkolah,
            R.drawable.addkolkolah,
            R.drawable.addkolkolah,
            R.drawable.addkolkolah,

    };

    int[] kolkolaRightImage = {
            R.drawable.book11,
            R.drawable.falakkkolkolkolah,
            R.drawable.falakkkolkolkolah,
            R.drawable.falakkkolkolkolah,

            R.drawable.book11,
            R.drawable.nuttfakolkolah,
            R.drawable.nuttfakolkolah,
            R.drawable.nuttfakolkolah,

            R.drawable.book11,
            R.drawable.hablunkolkolah,
            R.drawable.hablunkolkolah,
            R.drawable.hablunkolkolah,

            R.drawable.book11,
            R.drawable.fajrenkolkolah,
            R.drawable.fajrenkolkolah,
            R.drawable.fajrenkolkolah,

            R.drawable.book11,
            R.drawable.ahaddkolkolah,
            R.drawable.ahaddkolkolah,
            R.drawable.ahaddkolkolah,

    };
    int[] kolkolaMidleImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.mashriqqkolkolah,
            R.drawable.mashriqqkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.battshakolkolah,
            R.drawable.battshakolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.hatobbkolkolah,
            R.drawable.hatobbkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ajjrankolkolah,
            R.drawable.ajjrankolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.somadkolkolah,
            R.drawable.somadkolkolah,





    };
    int[] kolkolaLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ukksimukolkoah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.nuttfakolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.wakobkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jhazratunkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.eyalidkolkolah,

    };
    int [] kolkolasound={R.raw.iqqkolkolah,R.raw.falaqq,R.raw.mashriqq,R.raw.ukksimu,
            R.raw.attkolkolah,R.raw.nuttfatin,R.raw.battsha,R.raw.nuttfatin,
            R.raw.habbkolkola,R.raw.hablun,R.raw.hatobb,R.raw.owakobb,
            R.raw.ajjkolkola,R.raw.fajjre,R.raw.ajjrun,R.raw.jazratun,
            R.raw.jiddkolkola,R.raw.ahadd,R.raw.somadd,R.raw.eyalidd,
    };
    String[] presetpronunciation = {
            "",
            "فلقہ",
            "مشرق",
            "اقسم",
            "",
            "نطفة",
            "بطشة",
            "حبل",
            "",
            "حطب",
            "وقب",
            "فجر",
            "",
            "اجر",
            "زجرة",
            "احد",
            "",
            "صمد",
            "ىلد",
            "",


    };



    public KolkolaLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_kolkola_learn, container, false);

        previousBtn = view.findViewById(R.id.kolkolapreviousBtn);
        replayBtn = view.findViewById(R.id.kolkolaRepeatBtn);
        nextBtn = view.findViewById(R.id.kolkolaNextBtn);
        micBtn = view.findViewById(R.id.micBtnkolkolalearn);
        compareBttn = view.findViewById(R.id.compareBtnkolkolalearn);
        userVoiceText = view.findViewById(R.id.userVoiceText);
        topSwitcherkolkolah =  view.findViewById(R.id.kolkolaimageSwitherTop);
        leftSwitcherkolkolah = view.findViewById(R.id.kolkolaimageSwitherLeft);
        middleSwitcherkolkolah = view.findViewById(R.id.kolkolaimageSwitherMiddle);
        rightSwitcherkolkolah = view.findViewById(R.id.kolkolaimageSwitherRight);
        kolkolawordpronunciationTS = view.findViewById(R.id.textSwitcherkoloklaPronunciation);

        kolkolaMedia = MediaPlayer.create(getContext(),kolkolasound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);



        kolkolawordpronunciationTS.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        topSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcherkolkolah.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcherkolkolah.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcherkolkolah.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcherkolkolah.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        micBtn.setOnClickListener(new View.OnClickListener() {
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
        compareBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sentanceOne = (TextView) kolkolawordpronunciationTS.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceText.getText().toString();

                if (sentanceOnee.equals(sentenceTwoo) ) {

                    goodToast.start();

                }
                else {

                    badToast.start();
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<kolkolaTopImage.length-1){

                    position = position+1;
                    topSwitcherkolkolah.setBackgroundResource(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setBackgroundResource(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setBackgroundResource(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setBackgroundResource(kolkolaLeftImage[position]);
                    kolkolawordpronunciationTS.setText(presetpronunciation[position]);

                    try {
                        kolkolaMedia = MediaPlayer.create(getContext(),kolkolasound[currenthorkot]);
                        currenthorkot++;
                        kolkolaMedia.start();
                    }catch (Exception e){

                    }

                }

            }

        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position>0){

                    position = position-1;
                    topSwitcherkolkolah.setBackgroundResource(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setBackgroundResource(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setBackgroundResource(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setBackgroundResource(kolkolaLeftImage[position]);
                    kolkolawordpronunciationTS.setText(presetpronunciation[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),kolkolasound[currenthorkot]);
                        kolkolaMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (kolkolaMedia == null){
                    kolkolaMedia = MediaPlayer.create(getContext(),kolkolasound[currenthorkot]);

                }
                kolkolaMedia.start();
            }
        });



    return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case  REQUEST_CODE_SPEECH_INPUT:{

                if(resultCode == RESULT_OK && null!= data){

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userVoiceText.setText(result.get(0));
                }
                break;
            }
        }
    }

}
