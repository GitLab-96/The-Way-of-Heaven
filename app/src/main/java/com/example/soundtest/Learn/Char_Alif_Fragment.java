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

/**
 * A simple {@link Fragment} subclass.
 */
public class Char_Alif_Fragment extends Fragment {


    private TextSwitcher top_Switcher_char_alif,left_Switcher_char_alif,right_Switcher_char_alif,middle_Switcher_char_alif;
    private TextSwitcher textSwitcherCharAlifModd;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButton;
    private TextView userVoiceTextCharAlif;
    MediaPlayer CharAlifMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    String[] charAlifTopImage = {
            "حٰم٘",
            "ال٘مّ٘",
            "على الأرا٘ئِكِ",
            "مِنٛ دَا٘بَّةٍ",
            "مَنٛ يَّشَا٘ئُ",

    };

    String[] charAlifRightImage = {
            "حٰم٘",
            "حٰم٘",
            "حٰم٘",

            "مِنٛ دَا٘بَّةٍ",
            "مِنٛ دَا٘بَّةٍ",
            "مِنٛ دَا٘بَّةٍ",
    };
    String[] charAlifMidleImage = {
            "",
            "ال٘مّ٘",
            "ال٘مّ٘",

             "",
            "مَنٛ يَّشَا٘ئُ",
            "مَنٛ يَّشَا٘ئُ",
    };
    String[] charAlifLeftImage = {
            "",
            "",
            "على الأرا٘ئِكِ",

            "",
            "",
            "مَنٛ يَّشَا٘ئُ",

    };
    String[] presetpronunciationModd = {
            "حاميم",
            "الف لام ميم",
            "على الاراٸك",
            "وما من دابه",
            "يغفر لمن يشاء",
            "",
    };


    int [] charAlifsound={R.raw.hameeeem,R.raw.aliflaaaammeeeem,R.raw.alalaraaaiki,R.raw.wamamindaaaabbatin,
            R.raw.yagfirulimaiyashaaaaau,
    };



    public Char_Alif_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_char__alif_, container, false);


        previousBtn = view.findViewById(R.id.charAlifIPreviousBtn);
        replayBtn = view.findViewById(R.id.charAlifIRepeatBtn);
        nextBtn = view.findViewById(R.id.charAlifINextBtn);
        top_Switcher_char_alif = view.findViewById(R.id.charAlifTextSwitherTop);
        left_Switcher_char_alif = view.findViewById(R.id.charAlifTextSwitherLeft);
        middle_Switcher_char_alif = view.findViewById(R.id.charAlifTextSwitherMiddle);
        right_Switcher_char_alif = view.findViewById(R.id.charAlifTextSwitherRight);
        micButton = view.findViewById(R.id.micBtnCharAlifModd);
        compareButton = view.findViewById(R.id.compareBtnCharAlifModd);
        userVoiceTextCharAlif = view.findViewById(R.id.userVoiceTextCharalif);
        textSwitcherCharAlifModd = view.findViewById(R.id.textSwitcherCharAlifmoddPronunciation);



        CharAlifMedia = MediaPlayer.create(getContext(),charAlifsound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherCharAlifModd.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        top_Switcher_char_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        right_Switcher_char_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middle_Switcher_char_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        left_Switcher_char_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });


        compareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherCharAlifModd.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTextCharAlif.getText().toString();

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

                if(position<charAlifTopImage.length-1){

                    position = position+1;
                    top_Switcher_char_alif.setText(charAlifTopImage[position]);
                    right_Switcher_char_alif.setText(charAlifRightImage[position]);
                    middle_Switcher_char_alif.setText(charAlifMidleImage[position]);
                    left_Switcher_char_alif.setText(charAlifLeftImage[position]);

                    textSwitcherCharAlifModd.setText(presetpronunciationModd[position]);

                    try {
                        CharAlifMedia.stop();
                        CharAlifMedia = MediaPlayer.create(getContext(),charAlifsound[currenthorkot]);
                        currenthorkot++;
                        CharAlifMedia.start();
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
                    top_Switcher_char_alif.setText(charAlifTopImage[position]);
                    right_Switcher_char_alif.setText(charAlifRightImage[position]);
                    middle_Switcher_char_alif.setText(charAlifMidleImage[position]);
                    left_Switcher_char_alif.setText(charAlifLeftImage[position]);

                    textSwitcherCharAlifModd.setText(presetpronunciationModd[position]);
                    try {
                        CharAlifMedia.stop();
                        currenthorkot--;
                        MediaPlayer.create(getContext(),charAlifsound[currenthorkot]);
                        CharAlifMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CharAlifMedia == null){
                    CharAlifMedia = MediaPlayer.create(getContext(),charAlifsound[currenthorkot]);

                }
                CharAlifMedia.start();
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
                    userVoiceTextCharAlif.setText(result.get(0));
                }
                break;
            }
        }
    }
}
