package com.example.soundtest.Learn;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class Ek_alif_Fragment extends Fragment {

    private TextSwitcher topSwitchertobaye,leftSwitchertobaye,rightSwitchertobaye,middleSwitchertobaye;
    private TextSwitcher textSwitcherEkAlifModd;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButton;
    private TextView userVoiceTextEkalif;
    MediaPlayer tobayeMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    String[] tobayeTopImage = {


            "بَا",
            "بَا",
            "بُوْ",
            "بُوْ",
            "بِيْ",
            "بِيْ",
            "آ",
            "آ",
            "أ",
            "أ",
            "أ",
            "أ",


    };

    String[] tobayeRightImage = {

            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",



    };
    String[] tobayeMidleImage = {

            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",

    };
    String[] tobayeLeftImage = {

            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "نُوْحِيْهَا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",
            "أمَنَ",
            "آوْمِنَ",
            "اِيْمَانًا",
    };
    String[] presetpronunciationModd = {
            "",
            "مصباح",
            "كبﮃرة",
            "ان تبوءا",
            "",
            "امن",
            "الف",
            "الموءدة",
    };


    int [] tobayesound={R.raw.baamadd,R.raw.buumadd,R.raw.beemadd,R.raw.baakharajobormadd,
            R.raw.baakharajermadd,R.raw.baaultapeshmadd,
    };


    public Ek_alif_Fragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ek_alif_, container, false);


        previousBtn = view.findViewById(R.id.tobayePreviousBtn);
        replayBtn = view.findViewById(R.id.tobayeRepeatBtn);
        nextBtn = view.findViewById(R.id.tobayeNextBtn);
        topSwitchertobaye = view.findViewById(R.id.tobayetextSwitherTop);
        leftSwitchertobaye = view.findViewById(R.id.tobayetextSwitherLeft);
        middleSwitchertobaye = view.findViewById(R.id.tobayetextSwitherMiddle);
        rightSwitchertobaye = view.findViewById(R.id.tobayetextSwitherRight);
        micButton = view.findViewById(R.id.micBtnAkAlifModd);
        compareButton = view.findViewById(R.id.compareBtnEkAlifModd);
        userVoiceTextEkalif = view.findViewById(R.id.userVoiceTextEkalif);
        textSwitcherEkAlifModd = view.findViewById(R.id.textSwitcherekalifmoddPronunciation);



        tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherEkAlifModd.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        topSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        rightSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middleSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        leftSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });


        compareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherEkAlifModd.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTextEkalif.getText().toString();

                if (sentanceOnee.equals(sentenceTwoo) ) {

                    goodToast.start();

                }
                else {

                    badToast.start();
                }
            }
        });
        micButton.setOnClickListener(new View.OnClickListener() {
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
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<tobayeTopImage.length-1){

                    position = position+1;
                    topSwitchertobaye.setText(tobayeTopImage[position]);
                    rightSwitchertobaye.setText(tobayeRightImage[position]);
                    middleSwitchertobaye.setText(tobayeMidleImage[position]);
                    leftSwitchertobaye.setText(tobayeLeftImage[position]);

                    textSwitcherEkAlifModd.setText(presetpronunciationModd[position]);

                    try {
                        tobayeMedia.stop();
                        tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);
                        currenthorkot++;
                        tobayeMedia.start();
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
                    topSwitchertobaye.setText(tobayeTopImage[position]);
                    rightSwitchertobaye.setText(tobayeRightImage[position]);
                    middleSwitchertobaye.setText(tobayeMidleImage[position]);
                    leftSwitchertobaye.setText(tobayeLeftImage[position]);

                    textSwitcherEkAlifModd.setText(presetpronunciationModd[position]);

                    try {
                        tobayeMedia.stop();
                        currenthorkot--;
                        MediaPlayer.create(getContext(),tobayesound[currenthorkot]);
                        tobayeMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tobayeMedia == null){
                    tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);

                }
                tobayeMedia.start();
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
                    userVoiceTextEkalif.setText(result.get(0));
                }
                break;
            }
        }
    }


}
