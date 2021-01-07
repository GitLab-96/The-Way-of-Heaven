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
public class BarikFragment extends Fragment {
    private TextSwitcher topSwitcher_roBarik,leftSwitcher_roBarik,rightSwitcher_roBarik,middleSwitcher_roBarik;
    private TextSwitcher textSwitcherBarik;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButtn;
   private TextView userVoiceConvertBarik;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer roBarikMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;

    String[] roBarikTopImage = {
            "اَمٛرِ اللّٰهِ",
            "فَبَشِّرٛهُمٛ",
            "مِنٛ غَيٛرِ",
            "وَيَسِّرٛلِيٛ",
            "اَمٛرِيٛ",
    };

    String[] roBarikRightImage = {
            "اَمٛرِ اللّٰهِ",
            "اَمٛرِ اللّٰهِ",
            "اَمٛرِ اللّٰهِ",
            "وَيَسِّرٛلِيٛ",
    };
    String[] roBarikMiddleImage = {
            "",
            "فَبَشِّرٛهُمٛ",
            "فَبَشِّرٛهُمٛ",
            "وَيَسِّرٛلِيٛ",
    };
    String[] roBarikLeftImage = {
            "",
            "",
            "مِنٛ غَيٛرِ",
            "وَيَسِّرٛلِيٛ",
    };

    String[] presetpronunciationBarik = {
            "امر الله",
            "فبشرهم  بعذاب",
            "من غير",
            "ويسرلي امري",

    };


    int [] roBariksound={R.raw.amrillahi,R.raw.fabassirhumbiajabin,R.raw.mingoiri,R.raw.wayassirliamri,};



    public BarikFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_barik, container, false);

        previousBtn = view.findViewById(R.id.roBarikPreviousBtn);
        replayBtn = view.findViewById(R.id.roBarikRepeatBtn);
        nextBtn = view.findViewById(R.id.roBarikNextBtn);
        micButton = view.findViewById(R.id.micBtnBarik);
        compareButtn = view.findViewById(R.id.compareBtnBarik);
        topSwitcher_roBarik = view.findViewById(R.id.roBariktextSwitherTop);
        leftSwitcher_roBarik = view.findViewById(R.id.roBariktextSwitherLeft);
        middleSwitcher_roBarik = view.findViewById(R.id.roBariktextSwitherMiddle);
        rightSwitcher_roBarik = view.findViewById(R.id.roBariktextSwitherRight);

        userVoiceConvertBarik = view.findViewById(R.id.userVoiceTextBarik);
        textSwitcherBarik = view.findViewById(R.id.textSwitcherBarikPronunciation);


        roBarikMedia = MediaPlayer.create(getContext(),roBariksound[currenthorkot]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        textSwitcherBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        topSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        rightSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        middleSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        leftSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        compareButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sentanceOne = (TextView) textSwitcherBarik.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceConvertBarik.getText().toString();

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

                if(position<roBarikTopImage.length-1){

                    position = position+1;
                    topSwitcher_roBarik.setText(roBarikTopImage[position]);
                    rightSwitcher_roBarik.setText(roBarikRightImage[position]);
                    middleSwitcher_roBarik.setText(roBarikMiddleImage[position]);
                    leftSwitcher_roBarik.setText(roBarikLeftImage[position]);
                    textSwitcherBarik.setText(presetpronunciationBarik[position]);

                    try {
                        roBarikMedia.stop();
                        roBarikMedia = MediaPlayer.create(getContext(),roBariksound[currenthorkot]);
                        currenthorkot++;
                        roBarikMedia.start();
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
                    topSwitcher_roBarik.setText(roBarikTopImage[position]);
                    rightSwitcher_roBarik.setText(roBarikRightImage[position]);
                    middleSwitcher_roBarik.setText(roBarikMiddleImage[position]);
                    leftSwitcher_roBarik.setText(roBarikLeftImage[position]);
                    textSwitcherBarik.setText(presetpronunciationBarik[position]);
                    try {
                        roBarikMedia.stop();
                        currenthorkot--;
                        MediaPlayer.create(getContext(),roBariksound[currenthorkot]);
                        roBarikMedia.start();
                    }catch (Exception e){

                    }

                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roBarikMedia == null){
                    roBarikMedia = MediaPlayer.create(getContext(),roBariksound[currenthorkot]);

                }
                roBarikMedia.start();
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
                    userVoiceConvertBarik.setText(result.get(0));
                }
                break;
            }
        }
    }

}
