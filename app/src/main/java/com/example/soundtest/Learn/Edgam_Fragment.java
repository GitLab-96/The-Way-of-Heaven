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
public class Edgam_Fragment extends Fragment {

    private ImageSwitcher topSwitcheridgam,leftSwitcheridgam,rightSwitcheridgam,middleSwitcheridgam;
    private ImageButton previousBtn,replayBtn,nextBtn,micButtnIdgam,compareButtnIdgam;
    private TextView userVoiceTextIdgam;
    TextSwitcher textSwitcherIdgamPronunciation;
    MediaPlayer idgamMedia,goodToast,badToast;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private int currenthorkot = 0;
    int position  = -1;

    int[] idgamTopImage = {
            R.drawable.maiyashau,
            R.drawable.rosulullohi,
            R.drawable.miowalin,
            R.drawable.mannashau,
            R.drawable.mirrobbika,
            R.drawable.jamiulladaina,
    };

    int[] idgamRightImage = {
            R.drawable.maiyashau,
            R.drawable.maiyashau,
            R.drawable.maiyashau,
            R.drawable.mannashau,
            R.drawable.mannashau,
            R.drawable.mannashau,
    };
    int[] idgamMidleImage = {
            R.drawable.book11,
            R.drawable.rosulullohi,
            R.drawable.rosulullohi,
            R.drawable.book11,
            R.drawable.mirrobbika,
            R.drawable.mirrobbika,

    };
    int[] idgamLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.miowalin,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jamiulladaina,
    };
    String[] presetpronunciation = {
            "من يشاء",
            "رسل من الله",
            "من وال",
            "من نشاء",
            "من ربك",
            "جميع لدينا",

    };

    int [] idgamsound={R.raw.maiyashau,R.raw.rosulumminallohi,R.raw.miowalin,R.raw.mannashau,
            R.raw.mirrobbika,R.raw.jamiulladaina,
    };

    public Edgam_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edgam_, container, false);


        previousBtn = view.findViewById(R.id.idgamPreviousBtn);
        replayBtn = view.findViewById(R.id.idgamRepeatBtn);
        nextBtn = view.findViewById(R.id.idgamNextBtn);
        topSwitcheridgam = view.findViewById(R.id.idgamimageSwitherTop);
        leftSwitcheridgam = view.findViewById(R.id.idgamimageSwitherLeft);
        middleSwitcheridgam = view.findViewById(R.id.idgamimageSwitherMiddle);
        rightSwitcheridgam = view.findViewById(R.id.idgamimageSwitherRight);
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
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcheridgam.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcheridgam.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcheridgam.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcheridgam.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcheridgam.setBackgroundResource(R.drawable.book11);
                return imageView;
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
                    topSwitcheridgam.setBackgroundResource(idgamTopImage[position]);
                    rightSwitcheridgam.setBackgroundResource(idgamRightImage[position]);
                    middleSwitcheridgam.setBackgroundResource(idgamMidleImage[position]);
                    leftSwitcheridgam.setBackgroundResource(idgamLeftImage[position]);
                    textSwitcherIdgamPronunciation.setText(presetpronunciation[position]);
                    try {
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
                    topSwitcheridgam.setBackgroundResource(idgamTopImage[position]);
                    rightSwitcheridgam.setBackgroundResource(idgamRightImage[position]);
                    middleSwitcheridgam.setBackgroundResource(idgamMidleImage[position]);
                    leftSwitcheridgam.setBackgroundResource(idgamLeftImage[position]);
                    textSwitcherIdgamPronunciation.setText(presetpronunciation[position]);

                    try {

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
