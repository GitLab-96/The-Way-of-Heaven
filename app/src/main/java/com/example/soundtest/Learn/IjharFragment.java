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
public class IjharFragment extends Fragment {


    private TextSwitcher topSwitcheridgam,leftSwitcheridgam,rightSwitcheridgam,middleSwitcheridgam;
    private ImageButton previousBtn,replayBtn,nextBtn,micButtnIdgam,compareButtnIdgam;
    private TextView userVoiceTextIdgam;
    TextSwitcher textSwitcherIdgamPronunciation;
    MediaPlayer idgamMedia,goodToast,badToast;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private int currenthorkot = 0;
    int position  = -1;

    String[] idgamTopImage = {
            "مَنٛ اَذِنَ",
            "يَنٛهى",
            "اَنٛعَمٛتَ",
            "عَلِيٛمٌ حَكِيٛمٌ",
            "عَذَابٌ غَلِيٛظٌ",
            "مِنٛ خَوٛفٍ",

    };

    String[] idgamRightImage = {
            "مَنٛ اَذِنَ",
            "مَنٛ اَذِنَ",
            "مَنٛ اَذِنَ",

            "عَلِيٛمٌ حَكِيٛمٌ",
            "عَلِيٛمٌ حَكِيٛمٌ",
            "عَلِيٛمٌ حَكِيٛمٌ",

    };
    String[] idgamMidleImage = {
            "",
            "يَنٛهى",
            "يَنٛهى",
            "",
            "عَذَابٌ غَلِيٛظٌ",
            "عَذَابٌ غَلِيٛظٌ",

    };
    String[] idgamLeftImage = {
            "",
            "",
            "اَنٛعَمٛتَ",
            "",
            "",
            "مِنٛ خَوٛفٍ",

    };
    String[] presetpronunciation = {
            "من  اذن",
            "ينها",
            "انعمت",
            "عليم حكيم",
            "عذاب غليظ",
            "من خوف",

    };

    int [] idgamsound={R.raw.manajina,R.raw.yanha,R.raw.anamta,R.raw.alimunhakimun,
            R.raw.ajabungolijun,R.raw.minkhaofin,
    };

    public IjharFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ijhar, container, false);


        previousBtn = view.findViewById(R.id.idgamPreviousBtn);
        replayBtn = view.findViewById(R.id.idgamRepeatBtn);
        nextBtn = view.findViewById(R.id.idgamNextBtn);
        topSwitcheridgam = view.findViewById(R.id.idgamtextSwitherTop);
        leftSwitcheridgam = view.findViewById(R.id.idgamtextSwitherLeft);
        middleSwitcheridgam = view.findViewById(R.id.idgamtextSwitherMiddle);
        rightSwitcheridgam = view.findViewById(R.id.idgamtextSwitherRight);
        micButtnIdgam = view.findViewById(R.id.micBtnidgam);
        compareButtnIdgam = view.findViewById(R.id.compareBtnidgam);
        userVoiceTextIdgam = view.findViewById(R.id.userVoiceTextidgam);
        textSwitcherIdgamPronunciation = view.findViewById(R.id.textSwitcherPronunciationidgam);


        idgamMedia = MediaPlayer.create(getContext(),idgamsound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherIdgamPronunciation.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        topSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        rightSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middleSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        leftSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });



        micButtnIdgam.setOnClickListener(new View.OnClickListener() {
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

        compareButtnIdgam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherIdgamPronunciation.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTextIdgam.getText().toString();

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

                if(position<idgamTopImage.length-1){

                    position = position+1;
                    topSwitcheridgam.setText(idgamTopImage[position]);
                    rightSwitcheridgam.setText(idgamRightImage[position]);
                    middleSwitcheridgam.setText(idgamMidleImage[position]);
                    leftSwitcheridgam.setText(idgamLeftImage[position]);
                    textSwitcherIdgamPronunciation.setText(presetpronunciation[position]);
                    try {
                        idgamMedia.stop();
                        idgamMedia = MediaPlayer.create(getContext(),idgamsound[currenthorkot]);
                        currenthorkot++;
                        idgamMedia.start();
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
                    topSwitcheridgam.setText(idgamTopImage[position]);
                    rightSwitcheridgam.setText(idgamRightImage[position]);
                    middleSwitcheridgam.setText(idgamMidleImage[position]);
                    leftSwitcheridgam.setText(idgamLeftImage[position]);
                    textSwitcherIdgamPronunciation.setText(presetpronunciation[position]);

                    try {
                        idgamMedia.stop();
                        currenthorkot--;
                        MediaPlayer.create(getContext(),idgamsound[currenthorkot]);
                        idgamMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (idgamMedia == null){
                    idgamMedia = MediaPlayer.create(getContext(),idgamsound[currenthorkot]);

                }
                idgamMedia.start();
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
                    userVoiceTextIdgam.setText(result.get(0));
                }
                break;
            }
        }
    }

}
