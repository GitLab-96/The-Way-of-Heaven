package com.example.soundtest.Learn;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    MediaPlayer horofmedia,goodToast,badToast;
    ImageSwitcher imageSwitcher,juktoImageSwitcherright,juktoImageSwitchermiddle,juktoImageSwitcherleft;
    TextSwitcher textSwitchermakhraz,textSwitcherHoroh;
    private int currenthorof=0;


    int[] horof = {
            R.drawable.alif,
            R.drawable.ba,
            R.drawable.taa,
            R.drawable.sa,
            R.drawable.kha,
            R.drawable.ha,
            R.drawable.zim,
            R.drawable.dal,
            R.drawable.jal,
            R.drawable.ra,
            R.drawable.ja,
            R.drawable.seen,
            R.drawable.sheen,
            R.drawable.soad,
            R.drawable.doad,
            R.drawable.toa,
            R.drawable.jowa,
            R.drawable.ain,
            R.drawable.gain,
            R.drawable.fa,
            R.drawable.kof,
            R.drawable.kaf,
            R.drawable.laaam,
            R.drawable.meem,
            R.drawable.nun,
            R.drawable.wao,
            R.drawable.hha,
            R.drawable.hamjah,
            R.drawable.ya,
    };
    int[] juktoHorofleft = {
            R.drawable.juktoalifend,
            R.drawable.juktobaaend,
            R.drawable.juktotaaend,
            R.drawable.juktosaaend,
            R.drawable.juktojeemend,
            R.drawable.juktohaaend,
            R.drawable.juktokhaaend,
            R.drawable.juktodalend,
            R.drawable.juktojalend,
            R.drawable.juktoraend,
            R.drawable.juktojhaend,
            R.drawable.juktoseenend,
            R.drawable.juktoshenend,
            R.drawable.juktosowadend,
            R.drawable.juktodowadend,
            R.drawable.juktotowaend,
            R.drawable.juktojowaend,
            R.drawable.juktoainend,
            R.drawable.juktogainend,
            R.drawable.juktofaaend,
            R.drawable.juktokofend,
            R.drawable.juktokafend,
            R.drawable.juktolamend,
            R.drawable.juktomeemend,
            R.drawable.juktonunend,
            R.drawable.juktoowaoend,
            R.drawable.juktohaaend,
            R.drawable.juktohamjah,
            R.drawable.juktoeyaend,
    };
    int[] juktoHorofmiddle = {
            R.drawable.juktoalifmiddle,
            R.drawable.juktobaamiddle,
            R.drawable.juktotaamiddle,
            R.drawable.juktosaamiddle,
            R.drawable.juktojeemmiddle,
            R.drawable.juktohaamiddle,
            R.drawable.juktokhaamiddle,
            R.drawable.juktodalmiddle,
            R.drawable.juktojalmiddle,
            R.drawable.juktoramiddl,
            R.drawable.juktojhamiddle,
            R.drawable.juktoseenmiddle,
            R.drawable.juktoshenmiddle,
            R.drawable.juktosowadmiddle,
            R.drawable.juktodowadmiddle,
            R.drawable.juktotowamiddle,
            R.drawable.juktojowamiddle,
            R.drawable.juktoainmiddle,
            R.drawable.juktogainmiddle,
            R.drawable.juktofaamiddle,
            R.drawable.juktokofmiddle,
            R.drawable.juktokafmiddle,
            R.drawable.juktolammiddle,
            R.drawable.juktomeemmiddle,
            R.drawable.juktonunmiddle,
            R.drawable.juktoowao,
            R.drawable.juktohamiddle,
            R.drawable.juktohamjah,
            R.drawable.juktoeyamiddle,
    };
    int[] juktoHorofright = {
            R.drawable.juktoalifstart,
            R.drawable.juktobaastart,
            R.drawable.juktotaastart,
            R.drawable.juktosaastart,
            R.drawable.juktojeemstart,
            R.drawable.juktohaastart,
            R.drawable.juktokhaastart,
            R.drawable.juktodalmiddle,
            R.drawable.juktojalstart,
            R.drawable.juktorastart,
            R.drawable.juktojhastart,
            R.drawable.juktoseenstart,
            R.drawable.juktoshenstart,
            R.drawable.juktosowadstart,
            R.drawable.juktodowadstart,
            R.drawable.juktotowastart,
            R.drawable.juktojowastart,
            R.drawable.juktoainstart,
            R.drawable.juktogainstart,
            R.drawable.juktofaastart,
            R.drawable.juktokofstart,
            R.drawable.juktokafstart,
            R.drawable.juktolamstart,
            R.drawable.juktomeemstart,
            R.drawable.juktonunstart,
            R.drawable.juktoowao,
            R.drawable.juktohaastart,
            R.drawable.juktohamjah,
            R.drawable.juktoeyastart,
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
        imageSwitcher = view.findViewById(R.id.imageSwither);
        textSwitchermakhraz = view.findViewById(R.id.textSwitcherMakhraz);
        textSwitcherHoroh = view.findViewById(R.id.textSwitcherhorofPronunciation);
        userVoiceConvert = view.findViewById(R.id.userVoiceText);
        juktoImageSwitcherleft = view.findViewById(R.id.juktoImageSwitherleft);
        juktoImageSwitchermiddle = view.findViewById(R.id.juktoImageSwithermiddle);
        juktoImageSwitcherright = view.findViewById(R.id.juktoImageSwitherright);
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

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                imageSwitcher.setBackgroundResource(R.drawable.alif);
                return imageView;
            }
        });

        juktoImageSwitcherleft.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                juktoImageSwitcherleft.setBackgroundResource(R.drawable.juktoalifend);
                return imageView;
            }
        });
        juktoImageSwitchermiddle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                juktoImageSwitcherleft.setBackgroundResource(R.drawable.juktoalifmiddle);
                return imageView;
            }
        });
        juktoImageSwitcherright.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                juktoImageSwitcherleft.setBackgroundResource(R.drawable.juktoalifstart);
                return imageView;
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
                    imageSwitcher.setBackgroundResource(horof[position]);
                    juktoImageSwitcherleft.setBackgroundResource(juktoHorofleft[position]);
                    juktoImageSwitchermiddle.setBackgroundResource(juktoHorofmiddle[position]);
                    juktoImageSwitcherright.setBackgroundResource(juktoHorofright[position]);
                    textSwitchermakhraz.setText(makhraz[position]);
                    textSwitcherHoroh.setText(presetpronunciation[position]);
                    try {
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
                    imageSwitcher.setBackgroundResource(horof[position]);
                    juktoImageSwitcherleft.setBackgroundResource(juktoHorofleft[position]);
                    juktoImageSwitchermiddle.setBackgroundResource(juktoHorofmiddle[position]);
                    juktoImageSwitcherright.setBackgroundResource(juktoHorofright[position]);

                    try {

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

                ChangeSeekbar();
            }
        });

    }

}
