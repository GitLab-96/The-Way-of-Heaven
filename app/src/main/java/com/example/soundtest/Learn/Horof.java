package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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
import java.util.Locale;

public class Horof extends AppCompatActivity {

    private ImageButton previousBtn,nextBtn,playBtn,micBtn,compareBttn;
    private TextView userVoiceConvert;
    private SeekBar seekBar;
    private Runnable runnable;
    private Handler handler;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    int pausecurrentpossition;
    MediaPlayer horofmedia,goodToast,badToast;
    ImageSwitcher imageSwitcher,juktoImageSwitcher;
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
    int[] juktoHorof = {
            R.drawable.juktoalif,
            R.drawable.juktobaa,
            R.drawable.juktotaa,
            R.drawable.juktosaa,
            R.drawable.juktojeem,
            R.drawable.juktohaaa,
            R.drawable.juktokhaa,
            R.drawable.juktodaal,
            R.drawable.juktojaal,
            R.drawable.juktora,
            R.drawable.juktojhaa,
            R.drawable.juktoseen,
            R.drawable.juktosheen,
            R.drawable.juktosoad,
            R.drawable.juktodowad,
            R.drawable.juktotowa,
            R.drawable.juktojowa,
            R.drawable.juktoain,
            R.drawable.juktogain,
            R.drawable.juktofaa,
            R.drawable.juktokof,
            R.drawable.juktokaff,
            R.drawable.juktolaam,
            R.drawable.juktomeem,
            R.drawable.juktonun,
            R.drawable.juktowao,
            R.drawable.juktohaa,
            R.drawable.juktohamjah,
            R.drawable.juktoeya,
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horof);

        init();
        buttonclick();
        horofmedia = MediaPlayer.create(Horof.this,horofSound[currenthorof]);
        goodToast = MediaPlayer.create(Horof.this,R.raw.masha_allah2);
        badToast = MediaPlayer.create(Horof.this,R.raw.try_again);

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
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        textSwitcherHoroh.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

        juktoImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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
                    juktoImageSwitcher.setBackgroundResource(juktoHorof[position]);
                    textSwitchermakhraz.setText(makhraz[position]);
                    textSwitcherHoroh.setText(presetpronunciation[position]);
                    try {
                        horofmedia = MediaPlayer.create(Horof.this,horofSound[currenthorof]);
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
                    juktoImageSwitcher.setBackgroundResource(juktoHorof[position]);

                    try {
                        MediaPlayer.create(Horof.this,horofSound[currenthorof]);

                        currenthorof--;
                        horofmedia.start();
                    }catch (Exception e){


                    }


                }
            }
        });

        compareBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sentanceOne = (TextView) textSwitcherHoroh.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceConvert.getText().toString();

                if (sentanceOnee.equals(sentenceTwoo) ) {

                    Toast.makeText(Horof.this, "Equal", Toast.LENGTH_SHORT).show();
                    goodToast.start();

                }
                else {

                    Toast.makeText(Horof.this, "NotEqual", Toast.LENGTH_SHORT).show();
               badToast.start();
                }
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (horofmedia == null){
                    horofmedia = MediaPlayer.create(Horof.this,horofSound[currenthorof]);

                }
                horofmedia.start();
            }
        });

    }

    private void init() {

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        playBtn = findViewById(R.id.playBtn);
        micBtn = findViewById(R.id.micBtn);
        imageSwitcher = findViewById(R.id.imageSwither);
        textSwitchermakhraz = findViewById(R.id.textSwitcherMakhraz);
        textSwitcherHoroh = findViewById(R.id.textSwitcherhorofPronunciation);
        userVoiceConvert = findViewById(R.id.userVoiceText);
        juktoImageSwitcher = findViewById(R.id.juktoImageSwither);
        compareBttn = findViewById(R.id.compareBtn);
        handler = new Handler();
        seekBar = findViewById(R.id.outSeekBar);
    }
}
