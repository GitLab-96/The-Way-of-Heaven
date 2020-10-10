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
public class WajibLearn extends Fragment {
    private ImageSwitcher topSwitcherOwajib, leftSwitcherOwajib, rightSwitcherOwajib, middleSwitcherOwajib;
    private TextSwitcher textSwitcherWajib;
    private ImageButton previousBtn, replayBtn, nextBtn,micBtn,compareBtn;
    MediaPlayer OwajibMedia,goodToast,badToast;
    private TextView userVoiceConvert;
    private int currenthorkot = 0;
    int position = -1;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    int[] OwajibTopImage = {
            R.drawable.anna,
            R.drawable.inna,
            R.drawable.unna,

            R.drawable.amma,
            R.drawable.imma,
            R.drawable.umma,

            R.drawable.innama,
            R.drawable.falamma,
            R.drawable.fehinna,

            R.drawable.wajannatin,
            R.drawable.innakum,
            R.drawable.mujjhammilu,

            R.drawable.walamma,
            R.drawable.amma,
            R.drawable.summa,

            R.drawable.mimma,
            R.drawable.jahannama,
            R.drawable.ummuka,
    };

    int[] OwajibRightImage = {
            R.drawable.anna,
            R.drawable.anna,
            R.drawable.anna,

            R.drawable.amma,
            R.drawable.amma,
            R.drawable.amma,

            R.drawable.innama,
            R.drawable.innama,
            R.drawable.innama,

            R.drawable.wajannatin,
            R.drawable.wajannatin,
            R.drawable.wajannatin,

            R.drawable.walamma,
            R.drawable.walamma,
            R.drawable.walamma,

            R.drawable.mimma,
            R.drawable.mimma,
            R.drawable.mimma,

    };
    int[] OwajibMidleImage = {
            R.drawable.book11,
            R.drawable.inna,
            R.drawable.inna,

            R.drawable.book11,
            R.drawable.imma,
            R.drawable.imma,

            R.drawable.book11,
            R.drawable.falamma,
            R.drawable.falamma,

            R.drawable.book11,
            R.drawable.innakum,
            R.drawable.innakum,

            R.drawable.book11,
            R.drawable.aamma,
            R.drawable.aamma,

            R.drawable.book11,
            R.drawable.jahannama,
            R.drawable.jahannama,

    };
    int[] OwajibLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.unna,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.umma,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.fehinna,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.mujjhammilu,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.summa,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ummuka,

    };
    int[] Owajibsound = {R.raw.anna, R.raw.inna, R.raw.unna, R.raw.amma,
            R.raw.imma, R.raw.umma, R.raw.innama, R.raw.falamma,
            R.raw.fihinna, R.raw.owajannatin, R.raw.innakum, R.raw.mujjammilu,
            R.raw.walamma, R.raw.aamma, R.raw.summa, R.raw.mimma,
            R.raw.jahannama, R.raw.ummuka,
    };

    String[] presetpronunciationwajib = {
            "ان",
            "ان",
            "ان",
            "ام",
            "ام",
            "ام",
            "انما",
            "فلما",
            "فىهن",
            "وجنات",
            "انكم",
            "مزمل",
            "ولما",
            "عم",
            "ثم",
            "مما",
            "جهنم",
            "امك",

    };


    public WajibLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wajib_learn, container, false);

        previousBtn = view.findViewById(R.id.owajibpreviousBtn);
        replayBtn = view.findViewById(R.id.owajibRepeatBtn);
        nextBtn = view.findViewById(R.id.owajibNextBtn);
        topSwitcherOwajib =  view.findViewById(R.id.owajibimageSwither);
        leftSwitcherOwajib = view.findViewById(R.id.owajibimageSwither2_0);
        middleSwitcherOwajib = view.findViewById(R.id.owajibimageSwither2_1);
        rightSwitcherOwajib = view.findViewById(R.id.owajibimageSwither2_2);
        micBtn = view.findViewById(R.id.wajibmicBtn);
        compareBtn = view.findViewById(R.id.wajibcompareBtn);
        userVoiceConvert = view.findViewById(R.id.wajibuserVoiceText);
        textSwitcherWajib = view.findViewById(R.id.wajibPronunciationTS);
        OwajibMedia = MediaPlayer.create(getContext(), Owajibsound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);



        textSwitcherWajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        topSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcherOwajib.setBackgroundResource(R.drawable.book11);
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
        compareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherWajib.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceConvert.getText().toString();

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

                if (position < OwajibTopImage.length - 1) {

                    position = position + 1;
                    topSwitcherOwajib.setBackgroundResource(OwajibTopImage[position]);
                    rightSwitcherOwajib.setBackgroundResource(OwajibRightImage[position]);
                    middleSwitcherOwajib.setBackgroundResource(OwajibMidleImage[position]);
                    leftSwitcherOwajib.setBackgroundResource(OwajibLeftImage[position]);
                    textSwitcherWajib.setText(presetpronunciationwajib[position]);

                    try {
                        OwajibMedia.stop();
                        OwajibMedia = MediaPlayer.create(getContext(), Owajibsound[currenthorkot]);
                        currenthorkot++;
                        OwajibMedia.start();
                    } catch (Exception e) {

                    }

                }

            }

        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position > 0) {

                    position = position - 1;
                    topSwitcherOwajib.setBackgroundResource(OwajibTopImage[position]);
                    rightSwitcherOwajib.setBackgroundResource(OwajibRightImage[position]);
                    middleSwitcherOwajib.setBackgroundResource(OwajibMidleImage[position]);
                    leftSwitcherOwajib.setBackgroundResource(OwajibLeftImage[position]);
                    textSwitcherWajib.setText(presetpronunciationwajib[position]);
                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(), Owajibsound[currenthorkot]);
                        OwajibMedia.start();
                    } catch (Exception e) {

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (OwajibMedia == null) {
                    OwajibMedia = MediaPlayer.create(getContext(), Owajibsound[currenthorkot]);

                }
                OwajibMedia.start();
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
                    userVoiceConvert.setText(result.get(0));
                }
                break;
            }
        }
    }

}
