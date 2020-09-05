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

    private ImageSwitcher top_Switcher_tin_alif,left_Switcher_tin_alif,right_Switcher_tin_alif,middle_Switcher_tin_alif;
    private TextSwitcher textSwitcherTinAlifModd;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButton;
    private TextView userVoiceTextTinAlif;
    MediaPlayer TinAlifMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    int[] tinAlifTopImage = {
            R.drawable.laaailaha,
            R.drawable.illaaaaiblisa,
            R.drawable.maaaagna,

            R.drawable.gafuuur,
            R.drawable.rihiim,
            R.drawable.faqodjaaaj,


    };

    int[] tinAlifRightImage = {
            R.drawable.laaailaha,
            R.drawable.laaailaha,
            R.drawable.laaailaha,

            R.drawable.gafuuur,
            R.drawable.gafuuur,
            R.drawable.gafuuur,
    };
    int[] tinAlifMidleImage = {
            R.drawable.book11,
            R.drawable.illaaaaiblisa,
            R.drawable.illaaaaiblisa,

            R.drawable.book11,
            R.drawable.rihiim,
            R.drawable.rihiim,

    };
    int[] tinAlifLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.maaaagna,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.faqodjaaaj,
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
        top_Switcher_tin_alif = view.findViewById(R.id.tinAlifImageSwitherTop);
        left_Switcher_tin_alif = view.findViewById(R.id.tinAlifImageSwitherLeft);
        middle_Switcher_tin_alif = view.findViewById(R.id.tinAlifImageSwitherMiddle);
        right_Switcher_tin_alif = view.findViewById(R.id.tinAlifImageSwitherRight);
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
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                top_Switcher_tin_alif.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        right_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                right_Switcher_tin_alif.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middle_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middle_Switcher_tin_alif.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        left_Switcher_tin_alif.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                left_Switcher_tin_alif.setBackgroundResource(R.drawable.book11);
                return imageView;
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
                    top_Switcher_tin_alif.setBackgroundResource(tinAlifTopImage[position]);
                    right_Switcher_tin_alif.setBackgroundResource(tinAlifRightImage[position]);
                    middle_Switcher_tin_alif.setBackgroundResource(tinAlifMidleImage[position]);
                    left_Switcher_tin_alif.setBackgroundResource(tinAlifLeftImage[position]);

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
                    top_Switcher_tin_alif.setBackgroundResource(tinAlifTopImage[position]);
                    right_Switcher_tin_alif.setBackgroundResource(tinAlifRightImage[position]);
                    middle_Switcher_tin_alif.setBackgroundResource(tinAlifMidleImage[position]);
                    left_Switcher_tin_alif.setBackgroundResource(tinAlifLeftImage[position]);

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
