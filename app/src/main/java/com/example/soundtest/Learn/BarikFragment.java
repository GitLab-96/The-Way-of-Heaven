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
    private ImageSwitcher topSwitcher_roBarik,leftSwitcher_roBarik,rightSwitcher_roBarik,middleSwitcher_roBarik;
    private TextSwitcher textSwitcherBarik;
    private ImageButton previousBtn,replayBtn,nextBtn,micButton,compareButtn;
   private TextView userVoiceConvertBarik;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer roBarikMedia,goodToast,badToast;
    private int currenthorkot = 0;
    int position  = -1;

    int[] roBarikTopImage = {
            R.drawable.amrillahi,
            R.drawable.fabassirhumbiajain,
            R.drawable.mingoiri,
            R.drawable.wayassirliamri,
    };

    int[] roBarikRightImage = {
            R.drawable.amrillahi,
            R.drawable.amrillahi,
            R.drawable.amrillahi,
            R.drawable.wayassirliamri,


    };
    int[] roBarikMiddleImage = {
            R.drawable.book11,
            R.drawable.fabassirhumbiajain,
            R.drawable.fabassirhumbiajain,
            R.drawable.wayassirliamri,


    };
    int[] roBarikLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.mingoiri,
            R.drawable.wayassirliamri,

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
        topSwitcher_roBarik = view.findViewById(R.id.roBarikimageSwitherTop);
        leftSwitcher_roBarik = view.findViewById(R.id.roBarikimageSwitherLeft);
        middleSwitcher_roBarik = view.findViewById(R.id.roBarikimageSwitherMiddle);
        rightSwitcher_roBarik = view.findViewById(R.id.roBarikimageSwitherRight);

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
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcher_roBarik.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcher_roBarik.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcher_roBarik.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcher_roBarik.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcher_roBarik.setBackgroundResource(R.drawable.book11);
                return imageView;
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
                    topSwitcher_roBarik.setBackgroundResource(roBarikTopImage[position]);
                    rightSwitcher_roBarik.setBackgroundResource(roBarikRightImage[position]);
                    middleSwitcher_roBarik.setBackgroundResource(roBarikMiddleImage[position]);
                    leftSwitcher_roBarik.setBackgroundResource(roBarikLeftImage[position]);
                    textSwitcherBarik.setText(presetpronunciationBarik[position]);

                    try {
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
                    topSwitcher_roBarik.setBackgroundResource(roBarikTopImage[position]);
                    rightSwitcher_roBarik.setBackgroundResource(roBarikRightImage[position]);
                    middleSwitcher_roBarik.setBackgroundResource(roBarikMiddleImage[position]);
                    leftSwitcher_roBarik.setBackgroundResource(roBarikLeftImage[position]);
                    textSwitcherBarik.setText(presetpronunciationBarik[position]);
                    try {

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
