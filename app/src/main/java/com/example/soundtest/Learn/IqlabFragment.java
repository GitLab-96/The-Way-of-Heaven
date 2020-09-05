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
public class IqlabFragment extends Fragment {

    private ImageSwitcher topSwitcheriqlab,leftSwitcheriqlab,rightSwitcheriqlab,middleSwitcheriqlab;
    private ImageButton previousBtn,replayBtn,nextBtn,micButtnIqlab,compareButtnIqlab;
    private TextView userVoiceTextIqlab;
    TextSwitcher textSwitcherIqlabPronunciation;
    MediaPlayer iqlabMedia,goodToast,badToast;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private int currenthorkot = 0;
    int position  = -1;

    int[] iqlabTopImage = {
            R.drawable.mimmbadi,
            R.drawable.samiumbadi,
            R.drawable.lanasfambinnasiah,

            R.drawable.hadisimbadahu,
            R.drawable.rojumbaid,
            R.drawable.khabirambasiran,

            R.drawable.laumbajanna,
    };

    int[] iqlabRightImage = {
            R.drawable.mimmbadi,
            R.drawable.mimmbadi,
            R.drawable.mimmbadi,

            R.drawable.hadisimbadahu,
            R.drawable.hadisimbadahu,
            R.drawable.hadisimbadahu,

            R.drawable.hadisimbadahu,



    };
    int[] iqlabMidleImage = {
            R.drawable.book11,
            R.drawable.samiumbadi,
            R.drawable.samiumbadi,

            R.drawable.book11,
            R.drawable.rojumbaid,
            R.drawable.rojumbaid,

            R.drawable.hadisimbadahu,


    };
    int[] iqlabLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.lanasfambinnasiah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.khabirambasiran,

            R.drawable.hadisimbadahu,
    };
    String[] presetpronunciation = {
            "من بعدي",
            "سميع بصيرا",
            "لنسفعا  باالناصيه",
            "حديث بعده",
            "رجع بعيد",
            "خبيرا بصيرا",
            "لينبذن",

    };

    int [] iqlabsound={R.raw.mimbadi,R.raw.samiumbasira,R.raw.lanasfambinnasiati,R.raw.hadisimbadahu,
            R.raw.rojumdaidun,R.raw.khabiranbasiran,  R.drawable.laumbajanna,
    };


    public IqlabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_iqlab, container, false);


        previousBtn = view.findViewById(R.id.iqlabPreviousBtn);
        replayBtn = view.findViewById(R.id.iqlabRepeatBtn);
        nextBtn = view.findViewById(R.id.iqlabNextBtn);
        topSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherTop);
        leftSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherLeft);
        middleSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherMiddle);
        rightSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherRight);
        micButtnIqlab = view.findViewById(R.id.micBtnIqlab);
        compareButtnIqlab = view.findViewById(R.id.compareBtnIqlab);
        userVoiceTextIqlab = view.findViewById(R.id.userVoiceTextIqlab);
        textSwitcherIqlabPronunciation = view.findViewById(R.id.textSwitcherPronunciationIqlab);


        iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherIqlabPronunciation.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        topSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });



        micButtnIqlab.setOnClickListener(new View.OnClickListener() {
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

        compareButtnIqlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherIqlabPronunciation.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTextIqlab.getText().toString();

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

                if(position<iqlabTopImage.length-1){

                    position = position+1;
                    topSwitcheriqlab.setBackgroundResource(iqlabTopImage[position]);
                    rightSwitcheriqlab.setBackgroundResource(iqlabRightImage[position]);
                    middleSwitcheriqlab.setBackgroundResource(iqlabMidleImage[position]);
                    leftSwitcheriqlab.setBackgroundResource(iqlabLeftImage[position]);
                    textSwitcherIqlabPronunciation.setText(presetpronunciation[position]);
                    try {
                        iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);
                        currenthorkot++;
                        iqlabMedia.start();
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
                    topSwitcheriqlab.setBackgroundResource(iqlabTopImage[position]);
                    rightSwitcheriqlab.setBackgroundResource(iqlabRightImage[position]);
                    middleSwitcheriqlab.setBackgroundResource(iqlabMidleImage[position]);
                    leftSwitcheriqlab.setBackgroundResource(iqlabLeftImage[position]);
                    textSwitcherIqlabPronunciation.setText(presetpronunciation[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);
                        iqlabMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (iqlabMedia == null){
                    iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);

                }
                iqlabMedia.start();
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
                    userVoiceTextIqlab.setText(result.get(0));
                }
                break;
            }
        }
    }

}
