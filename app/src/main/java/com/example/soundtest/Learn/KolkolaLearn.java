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


    private TextSwitcher topSwitcherkolkolah,leftSwitcherkolkolah,rightSwitcherkolkolah,middleSwitcherkolkolah;
    private TextSwitcher kolkolawordpronunciationTS;
    private ImageButton previousBtn,replayBtn,nextBtn,micBtn,compareBttn;
    TextView userVoiceText;
    MediaPlayer kolkolaMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    String[] kolkolaTopImage = {


            "اَقْ",
            "اَقْ",
            "اِقْ",
            "اِقْ",
            "اُقْ",
            "اُقْ",


            "بَطْ",
            "بَطْ",
            "بِطْ",
            "بِطْ",
            "نُطْ",
            "نُطْ",


            "حَبْ",
            "حَبْ",
            "اِبْ",
            "اِبْ",
            "اُبْ",
            "اُبْ",

            "اَجْ",
            "اَجْ",
            "اِجْ",
            "اِجْ",
            "اُجْ",
            "اُجْ",

            "حَدْ",
            "حَدْ",
            "اِدْ",
            "اِدْ",
            "خُدْ",
            "خُدْ",

    };

    String[] kolkolaRightImage = {

            "",
            "فَلَقْ",
            "فَلَقْ",
            "فَلَقْ",

            "",
            "بَطْشَةً",
            "بَطْشَةً",
            "بَطْشَةً",

            "",
            "حَبْلٌ",
            "حَبْلٌ",
            "حَبْلٌ",

            "",
            "اَجْرًا",
            "اَجْرًا",
            "اَجْرًا",

            "",
            "اَحَدْ",
            "اَحَدْ",
            "اَحَدْ",



    };
    String[] kolkolaMidleImage = {

            "",
            "",
            "مَشْرِقْ",
            "مَشْرِقْ",

            "",
            "",
            "بِطْرٍ",
            "بِطْرٍ",

            "",
            "",
            "اِبْلِيْسَ",
            "اِبْلِيْسَ",

            "",
            "",
            "اِجْعَلْ",
            "اِجْعَلْ",

            "",
            "",
            "اِدْرِيْسُ",
            "اِدْرِيْسُ",


    };
    String[] kolkolaLeftImage = {
            "",
            "",
            "",
            "اُقْسِمُ",

            "",
            "",
            "",
            "نُطْفَةٍ",

            "",
            "",
            "",
            "اُبْدِئُ",

            "",
            "",
            "",
            "اُجْرِيْ",

            "",
            "",
            "",
            "خُدْرِيْ",


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
        topSwitcherkolkolah =  view.findViewById(R.id.kolkolatextSwitherTop);
        leftSwitcherkolkolah = view.findViewById(R.id.kolkolatextSwitherLeft);
        middleSwitcherkolkolah = view.findViewById(R.id.kolkolatextSwitherMiddle);
        rightSwitcherkolkolah = view.findViewById(R.id.kolkolatextSwitherRight);
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
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        rightSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middleSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        leftSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
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
                    topSwitcherkolkolah.setText(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setText(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setText(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setText(kolkolaLeftImage[position]);
                    kolkolawordpronunciationTS.setText(presetpronunciation[position]);

                    try {
                        kolkolaMedia.stop();
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
                    topSwitcherkolkolah.setText(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setText(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setText(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setText(kolkolaLeftImage[position]);
                    kolkolawordpronunciationTS.setText(presetpronunciation[position]);

                    try {
                        kolkolaMedia.stop();
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
