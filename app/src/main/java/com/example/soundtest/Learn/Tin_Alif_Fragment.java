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
public class Tin_Alif_Fragment extends Fragment {

    private TextSwitcher top_Switcher_tin_alif,left_Switcher_tin_alif,right_Switcher_tin_alif,middle_Switcher_tin_alif;
    private TextSwitcher textSwitcherTinAlifModd;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButton;
    private TextView userVoiceTextTinAlif;
    MediaPlayer TinAlifMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    String[] tinAlifTopImage = {
            "لآاِلَاهَ",
            "اِلّااِبْلِيْسَ",
            "غَفُوْرٌ٠",

            "رَحِيْمِ٠",
            "فَقَدفَازْ٠",
            "غَفُوْرٌ٠",


    };

    String[] tinAlifRightImage = {
            "لآاِلَاهَ",
            "اِلّااِبْلِيْسَ",
            "غَفُوْرٌ٠",

            "رَحِيْمِ٠",
            "فَقَدفَازْ٠",
            "غَفُوْرٌ٠",
    };
    String[] tinAlifMidleImage = {
            "",
            "اِلّااِبْلِيْسَ",
            "غَفُوْرٌ٠",

            "",
            "فَقَدفَازْ٠",
            "غَفُوْرٌ٠",


    };
    String[] tinAlifLeftImage = {
            "",
            "",
            "غَفُوْرٌ٠",

            "",
            "",
            "غَفُوْرٌ٠",

    };
    String[] presetpronunciationModd = {
            "لا اله",
            "الا ابليس",
            "ما اغني",
            "غفور",
            "رحيم",
            "فقد فاز",
    };


    int [] tinAlifsound={R.raw.laaailaha,R.raw.illaaaiblisa,R.raw.maaagna,R.raw.gofuuur,
            R.raw.rohim,R.raw.fakodfaaaj,
    };




    public Tin_Alif_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tin__alif_, container, false);


        previousBtn = view.findViewById(R.id.tinAlifIPreviousBtn);
        replayBtn = view.findViewById(R.id.tinAlifIRepeatBtn);
        nextBtn = view.findViewById(R.id.tinAlifINextBtn);
        top_Switcher_tin_alif = view.findViewById(R.id.tinAlifTextSwitherTop);
        left_Switcher_tin_alif = view.findViewById(R.id.tinAlifTextSwitherLeft);
        middle_Switcher_tin_alif = view.findViewById(R.id.tinAlifTextSwitherMiddle);
        right_Switcher_tin_alif = view.findViewById(R.id.tinAlifTextSwitherRight);
        micButton = view.findViewById(R.id.micBtnTinAlifModd);
        compareButton = view.findViewById(R.id.compareBtnTinAlifModd);
        userVoiceTextTinAlif = view.findViewById(R.id.userVoiceTextTinalif);
        textSwitcherTinAlifModd = view.findViewById(R.id.textSwitcherTinAlifmoddPronunciation);



        TinAlifMedia = MediaPlayer.create(getContext(),tinAlifsound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherTinAlifModd.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        top_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        right_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middle_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        left_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
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

                TextView sentanceOne = (TextView) textSwitcherTinAlifModd.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTextTinAlif.getText().toString();

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

                if(position<tinAlifTopImage.length-1){

                    position = position+1;
                    top_Switcher_tin_alif.setText(tinAlifTopImage[position]);
                    right_Switcher_tin_alif.setText(tinAlifRightImage[position]);
                    middle_Switcher_tin_alif.setText(tinAlifMidleImage[position]);
                    left_Switcher_tin_alif.setText(tinAlifLeftImage[position]);

                    textSwitcherTinAlifModd.setText(presetpronunciationModd[position]);

                    try {
                        TinAlifMedia = MediaPlayer.create(getContext(),tinAlifsound[currenthorkot]);
                        currenthorkot++;
                        TinAlifMedia.start();
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
                    top_Switcher_tin_alif.setText(tinAlifTopImage[position]);
                    right_Switcher_tin_alif.setText(tinAlifRightImage[position]);
                    middle_Switcher_tin_alif.setText(tinAlifMidleImage[position]);
                    left_Switcher_tin_alif.setText(tinAlifLeftImage[position]);

                    textSwitcherTinAlifModd.setText(presetpronunciationModd[position]);
                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),tinAlifsound[currenthorkot]);
                        TinAlifMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TinAlifMedia == null){
                    TinAlifMedia = MediaPlayer.create(getContext(),tinAlifsound[currenthorkot]);

                }
                TinAlifMedia.start();
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
                    userVoiceTextTinAlif.setText(result.get(0));
                }
                break;
            }
        }
    }

}
