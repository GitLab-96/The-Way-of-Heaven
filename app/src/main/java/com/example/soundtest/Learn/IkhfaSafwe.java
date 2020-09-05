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
public class IkhfaSafwe extends Fragment {


    private ImageSwitcher topSwitcheridgam,leftSwitcheridgam,rightSwitcheridgam,middleSwitcheridgam;
    private ImageButton previousBtn,replayBtn,nextBtn,micButtnIdgam,compareButtnIdgam;
    private TextView userVoiceTextIdgam;
    TextSwitcher textSwitcherIdgamPronunciation;
    MediaPlayer idgamMedia,goodToast,badToast;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private int currenthorkot = 0;
    int position  = -1;

    int[] idgamTopImage = {
            R.drawable.jannatintajri,
            R.drawable.unsa,
            R.drawable.minjuen,

            R.drawable.mindunillahi,
            R.drawable.naronjata,
            R.drawable.unjhila,

            R.drawable.minsijjilin,
            R.drawable.minsharri,
            R.drawable.ansolatihim,

            R.drawable.andoife,
            R.drawable.mantogo,
            R.drawable.yanjuruna,

            R.drawable.yatimanfawa,
            R.drawable.farrotminkoswarah,
            R.drawable.kiromankatibina,
    };


    int[] idgamRightImage = {
            R.drawable.jannatintajri,
            R.drawable.jannatintajri,
            R.drawable.jannatintajri,

            R.drawable.mindunillahi,
            R.drawable.mindunillahi,
            R.drawable.mindunillahi,

            R.drawable.minsijjilin,
            R.drawable.minsijjilin,
            R.drawable.minsijjilin,

            R.drawable.andoife,
            R.drawable.andoife,
            R.drawable.andoife,

            R.drawable.yatimanfawa,
            R.drawable.yatimanfawa,
            R.drawable.yatimanfawa,

    };
    int[] idgamMidleImage = {
            R.drawable.book11,
            R.drawable.unsa,
            R.drawable.unsa,

            R.drawable.book11,
            R.drawable.naronjata,
            R.drawable.naronjata,

            R.drawable.book11,
            R.drawable.minsharri,
            R.drawable.minsharri,

            R.drawable.book11,
            R.drawable.mantogo,
            R.drawable.mantogo,

            R.drawable.book11,
            R.drawable.farrotminkoswarah,
            R.drawable.farrotminkoswarah,

    };
    int[] idgamLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.minjuen,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.unjhila,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ansolatihim,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.yanjuruna,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.kiromankatibina,
    };

    String[] presetpronunciation = {
            "جنات تجري",
            "انثى",
            "من جوع",
            "من دون الله",
            "نارا ذات",
            "انزله",

            "من سجيل",
            "من شر",
            "عن صلاتهم",
            "عن ضيف",
            "من طغى",
            "ينظرون",

            "يتيما فاوى",
            "فررت من قسورہ",
            "كراما كاتبين",
    };

    int [] idgamsound={R.raw.jannatintazri,R.raw.unsa,R.raw.minjuin,R.raw.mindunillahi,
            R.raw.naronjata,R.raw.unjila,R.raw.minsijjilin,R.raw.minnsharri,R.raw.amminsolatihim,
            R.raw.annjoifi,R.raw.mantogo,R.raw.yanjuruna,R.raw.yatimanfaawa,R.raw.farrotminkoswarah,R.raw.kiromankatibina,
    };

    public IkhfaSafwe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ikhfa_safwe, container, false);



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
