package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;
import java.util.Locale;

public class Horof extends AppCompatActivity {

    private Button previousBtn,nextBtn,playBtn,pauseBtn,stopBtn,micBtn;
    private TextView userVoiceConvert;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    int pausecurrentpossition;
    MediaPlayer horofmedia;
    ImageSwitcher imageSwitcher,juktoImageSwitcher;
    TextSwitcher textSwitcher;
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
            "হলকের শুরু হইতে উচ্চারিত হয়। ",
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

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
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
                    textSwitcher.setText(makhraz[position]);
                    try {
                        horofmedia = MediaPlayer.create(Horof.this,horofSound[currenthorof]);
                        currenthorof++;
                        horofmedia.start();
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
                    textSwitcher.setText(makhraz[position]);
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


    }


    private void init() {

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        stopBtn = findViewById(R.id.stopBtn);
        micBtn = findViewById(R.id.micBtn);
        imageSwitcher = findViewById(R.id.imageSwither);
        textSwitcher = findViewById(R.id.textSwitcher);
        userVoiceConvert = findViewById(R.id.userVoiceText);
        juktoImageSwitcher = findViewById(R.id.juktoImageSwither);
    }
}
