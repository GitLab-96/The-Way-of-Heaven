package com.example.soundtest.Learn;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.speech.RecognizerIntent;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorofLearn extends Fragment {

    private ImageButton previousBtn,nextBtn,playBtn,micBtn,compareBttn;
    private TextView userVoiceConvert;
    private SeekBar seekBar;
    private Runnable runnable;
    private Handler handler;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    int pausecurrentpossition;

    TextSwitcher juktoTextSwitcherright,juktoTextSwitchermiddle,juktoTextSwitcherleft;
    TextSwitcher textSwitchermakhraz,textSwitcherHoroh,textSwitcher;
    private int currenthorof=0;
    MediaPlayer horofmedia,goodToast,badToast;


    String[] horof = {
            "ا",
            "ب",
            "ت",
            "ث",
            "ج",
            "ح",
            "خ",
            "د",
            "ذ",
            "ر",
            "ز",
            "س",
            "ش",
            "ص",
            "ض",
            "ط",
            "ظ",
            "ع",
            "غ",
            "ف",
            "ق",
            "ك",
            "ل",
            "م",
            "ن",
            "و",
            "ه",
            "ﺀ",
            "ي",
    };



    String[] juktoHorofleft = {
            "ﺎ",
            "ﺐ",
            "ﺖ",
            "ﺚ",
            "ﺞ",
            "ﺢ",
            "ﺦ",
            "ﺪ",
            "ﺬ",
            "ﺮ",
            "ﺰ",
            "ﺲ",
            "ﺶ",
            "ﺺ",
            "ﺽ",
            "ﻄ",
            "ﻆ",
            "ﻊ",
            "ﻎ",
            "ﻒ",
            "ﻖ",
            "ﻚ",
            "ﻞ",
            "ﻢ",
            "ﻦ",
            "ﻮ",
            "ﻪ",
            "ﺉ",
            "ﻰ",
    };
    String[] juktoHorofmiddle = {
            "ﺎ",
            "ﺒ",
            "ﺘ",
            "ﺜ",
            "ﺠ",
            "ﺤ",
            "ﺨ",
            "ﺪ",
            "ﺬ",
            "ﺮ",
            "ﺰ",
            "ﺴ",
            "ﺸ",
            "ﺼ",
            "ﻀ",
            "ﻄ",
            "ﻈ",
            "ﻌ",
            "ﻐ",
            "ﻔ",
            "ﻘ",
            "ﻜ",
            "ﻠ",
            "ﻤ",
            "ﻨ",
            "ﻮ",
            "ﻬ",
            "ﺌ",
            "ﻴ",
    };
    String[] juktoHorofright = {
            "ا",
            "ﺑ",
            "ﺗ",
            "ﺛ",
            "ﺟ",
            "ﺣ",
            "ﺧ",
            "د",
            "ذ",
            "ر",
            "ز",
            "ﺳ",
            "ﺷ",
            "ﺻ",
            "ﺿ",
            "ﻃ",
            "ﻇ",
            "ﻋ",
            "ﻏ",
            "ﻓ",
            "ﻗ",
            "ﻛ",
            "ﻟ",
            "ﻣ",
            "ﻧ",
            "و",
            "ﻫ",
            "ﺋ",
            "ﻳ",
    };

    int position = -1;

    String[] makhraz = {
            "হলকের শুরু হইতে উচ্চারিত হয়।",
            "দুই ঠোঁট হইতে উচ্চারিত হয়। ",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। ",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়। ",
            "হলকের মধ্যখান হইতে উচ্চারিত হয়। ",
            "হলকের শেষ হইতে উচ্চারিত হয়।",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া।",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের আগার সাথে লাগাইয়া।",
            "জিহ্বার আগার উল্টাপীঠ তারবরাবর উপরে তালুর সংগে লাগাইয়া ",
            "জিহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া।",
            "জিহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া।",
            "হলকের মধ্যখান হইতে উচ্চারিত হয়।",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া।",
            "জিহ্বার আগার কিনারা উপরে মাড়ির দাঁতের গোঁড়ার সংগে লাগাইয়া",
            "িহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া।",
            "হলকের মধ্যখান হইতে উচ্চারিত হয়।",
            "হলকের শেষ হইতে উচ্চারিত হয়।",
            "নিচের ঠোঁটের পেট,সামনের উপরের দুই দাঁতের আগার সঙ্গে লাগাইয়া",
            "জিহ্বার গোঁড়া তারবরাবর উপরে তালুর সংগে লাগাইয়া ",
            "জিহ্বার গোঁড়া থেকে একটু আগে বাড়াইয়া তারবরাবর উপরে তালুর সংগে লাগাইয়া",
            "জিহ্বার আগা সামনের উপরের দুই দাঁতের গোঁড়ার সংগে লাগাইয়া",
            "দুই ঠোঁট হইতে উচ্চারিত হয়।",
            "জিহ্বার আগা সামনের উপরের দুই দাঁতের গোঁড়ার সংগে লাগাইয়া",
            "দুই ঠোঁট হইতে উচ্চারিত হয়।",
            "হলকের শুরু হইতে উচ্চারিত হয়",
            "হলকের শুরু হইতে উচ্চারিত হয়",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়।",
    };

    String[] presetpronunciation = {
            "الف",
            "باء",
            "تاء",
            "ثاء",
            "جيم",
            "حاء",
            "خاء",
            "دال",
            "ذال",
            "راء",
            "زاء",
            "سين",
            "شين",
            "صاد",
            "ضاد",
            "طاء",
            "ظاء",
            "عين",
            "غين",
            "فاء",
            "قاف",
            "كاف",
            "لام",
            "ميم",
            "نون",
            "واو",
            "هاء",
            "همزة",
            "ياء",
    };

    int [] horofSound={R.raw.alif,R.raw.ba,R.raw.ta,R.raw.sa,R.raw.jeem,R.raw.ha,R.raw.kha,
            R.raw.dal,R.raw.jal,R.raw.ro,R.raw.jha,R.raw.seen,R.raw.sheen,R.raw.swad,R.raw.doad,
            R.raw.toa,R.raw.jowa,R.raw.ain,R.raw.gain,R.raw.faa,R.raw.kof,R.raw.kaf,R.raw.laam,
            R.raw.meem,R.raw.noon,R.raw.wao,R.raw.haa,R.raw.hamzah,R.raw.ya};

    public HorofLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_horof_learn, container, false);



        previousBtn = view.findViewById(R.id.previousBtn);
        nextBtn = view.findViewById(R.id.nextBtn);
        playBtn = view.findViewById(R.id.playBtn);
        micBtn = view.findViewById(R.id.micBtn);
        textSwitcher = view.findViewById(R.id.textSwither);
        textSwitchermakhraz = view.findViewById(R.id.textSwitcherMakhraz);
        textSwitcherHoroh = view.findViewById(R.id.textSwitcherhorofPronunciation);
        userVoiceConvert = view.findViewById(R.id.userVoiceText);
        juktoTextSwitcherleft = view.findViewById(R.id.juktoTextSwitherleft);
        juktoTextSwitchermiddle = view.findViewById(R.id.juktoTextSwithermiddle);
        juktoTextSwitcherright = view.findViewById(R.id.juktoTextSwitherright);
        compareBttn = view.findViewById(R.id.compareBtn);
        handler = new Handler();
        seekBar = view.findViewById(R.id.outSeekBar);


        buttonclick();
        horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);

        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);

        horofmedia.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                seekBar.setMax(horofmedia.getDuration());
                horofmedia.start();
                ChangeSeekbar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser){

                    horofmedia.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        textSwitchermakhraz.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        textSwitcherHoroh.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(200);
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setText("ا");
                return textView;
            }
        });

        juktoTextSwitcherleft.setFactory(new ViewSwitcher.ViewFactory() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View makeView() {

                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setText("ﺎ");
                return textView;
            }
        });
        juktoTextSwitchermiddle.setFactory(new ViewSwitcher.ViewFactory() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View makeView() {

                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setText("ﺎ");
                return textView;
            }
        });
        juktoTextSwitcherright.setFactory(new ViewSwitcher.ViewFactory() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View makeView() {

                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setText("ا");
                return textView;
            }
        });

    return view;
    }

    private void ChangeSeekbar() {

        seekBar.setProgress(horofmedia.getCurrentPosition());

        if (horofmedia.isPlaying()){

            runnable = new Runnable() {
                @Override
                public void run() {
                    ChangeSeekbar();
                }
            };

            handler.postDelayed(runnable,1000);
        }

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

    private void buttonclick() {

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

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((position<horof.length-1)&& (position<makhraz.length-1)){

                    position = position+1;
                    textSwitcher.setText(horof[position]);


                    juktoTextSwitcherleft.setText(juktoHorofleft[position]);
                    juktoTextSwitchermiddle.setText(juktoHorofmiddle[position]);
                    juktoTextSwitcherright.setText(juktoHorofright[position]);

                    textSwitchermakhraz.setText(makhraz[position]);
                    textSwitcherHoroh.setText(presetpronunciation[position]);
                    try {
                        horofmedia.stop();
                        horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);
                        currenthorof++;
                        horofmedia.start();
                    }catch (Exception e){
                    }

                }
                ChangeSeekbar();

            }

        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position>0){

                    position = position-1;
                    textSwitchermakhraz.setText(makhraz[position]);
                    textSwitcherHoroh.setText(presetpronunciation[position]);
                    textSwitcher.setText(horof[position]);

                    juktoTextSwitcherleft.setText(juktoHorofleft[position]);
                    juktoTextSwitchermiddle.setText(juktoHorofmiddle[position]);
                    juktoTextSwitcherright.setText(juktoHorofright[position]);

                    try {
                        horofmedia.stop();
                        currenthorof--;
                        MediaPlayer.create(getContext(),horofSound[currenthorof]);
                        horofmedia.start();
                    }catch (Exception e){


                    }


                }
                ChangeSeekbar();
            }
        });

        compareBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sentanceOne = (TextView) textSwitcherHoroh.getCurrentView();

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

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (horofmedia == null){
                    horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);

                }
                horofmedia.start();
            }
        });

    }

}
