package com.example.soundtest.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

public class KolkolahActivity extends AppCompatActivity {

    private ImageSwitcher topSwitcherkolkolah,leftSwitcherkolkolah,rightSwitcherkolkolah,middleSwitcherkolkolah;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer kolkolaMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] kolkolaTopImage = {
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,
            R.drawable.akkkolkola,

            R.drawable.attkolkolah,
            R.drawable.attkolkolah,
            R.drawable.attkolkolah,
            R.drawable.attkolkolah,

            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,
            R.drawable.abbkolkolah,

            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,
            R.drawable.ajjkolkolah,

            R.drawable.addkolkolah,
            R.drawable.addkolkolah,
            R.drawable.addkolkolah,
            R.drawable.addkolkolah,

    };

    int[] kolkolaRightImage = {
            R.drawable.book11,
            R.drawable.falakkkolkolkolah,
            R.drawable.falakkkolkolkolah,
            R.drawable.falakkkolkolkolah,

            R.drawable.book11,
            R.drawable.nuttfakolkolah,
            R.drawable.nuttfakolkolah,
            R.drawable.nuttfakolkolah,

            R.drawable.book11,
            R.drawable.hablunkolkolah,
            R.drawable.hablunkolkolah,
            R.drawable.hablunkolkolah,

            R.drawable.book11,
            R.drawable.fajrenkolkolah,
            R.drawable.fajrenkolkolah,
            R.drawable.fajrenkolkolah,

            R.drawable.book11,
            R.drawable.ahaddkolkolah,
            R.drawable.ahaddkolkolah,
            R.drawable.ahaddkolkolah,

    };
    int[] kolkolaMidleImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.mashriqqkolkolah,
            R.drawable.mashriqqkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.battshakolkolah,
            R.drawable.battshakolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.hatobbkolkolah,
            R.drawable.hatobbkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ajjrankolkolah,
            R.drawable.ajjrankolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.somadkolkolah,
            R.drawable.somadkolkolah,





    };
    int[] kolkolaLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ukksimukolkoah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.nuttfakolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.wakobkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jhazratunkolkolah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.eyalidkolkolah,

    };
    int [] kolkolasound={R.raw.iqqkolkolah,R.raw.falaqq,R.raw.mashriqq,R.raw.ukksimu,
                         R.raw.attkolkolah,R.raw.nuttfatin,R.raw.battsha,R.raw.nuttfatin,
                        R.raw.habbkolkola,R.raw.hablun,R.raw.hatobb,R.raw.owakobb,
                        R.raw.ajjkolkola,R.raw.fajjre,R.raw.ajjrun,R.raw.jazratun,
                        R.raw.jiddkolkola,R.raw.ahadd,R.raw.somadd,R.raw.eyalidd,
                };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkolah);


        init();

        kolkolaMedia = MediaPlayer.create(KolkolahActivity.this,kolkolasound[currenthorkot]);



        topSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        rightSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        middleSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        leftSwitcherkolkolah.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<kolkolaTopImage.length-1){

                    position = position+1;
                    topSwitcherkolkolah.setBackgroundResource(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setBackgroundResource(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setBackgroundResource(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setBackgroundResource(kolkolaLeftImage[position]);

                    try {
                        kolkolaMedia = MediaPlayer.create(KolkolahActivity.this,kolkolasound[currenthorkot]);
                        currenthorkot++;
                        kolkolaMedia.start();
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
                    topSwitcherkolkolah.setBackgroundResource(kolkolaTopImage[position]);
                    rightSwitcherkolkolah.setBackgroundResource(kolkolaRightImage[position]);
                    middleSwitcherkolkolah.setBackgroundResource(kolkolaMidleImage[position]);
                    leftSwitcherkolkolah.setBackgroundResource(kolkolaLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(KolkolahActivity.this,kolkolasound[currenthorkot]);
                        kolkolaMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (kolkolaMedia == null){
                    kolkolaMedia = MediaPlayer.create(KolkolahActivity.this,kolkolasound[currenthorkot]);

                }
                kolkolaMedia.start();
            }
        });




    }
    private void init() {

        previousBtn = findViewById(R.id.kolkolapreviousBtn);
        replayBtn = findViewById(R.id.kolkolaRepeatBtn);
        nextBtn = findViewById(R.id.kolkolaNextBtn);
        topSwitcherkolkolah =  findViewById(R.id.kolkolaimageSwitherTop);
        leftSwitcherkolkolah = findViewById(R.id.kolkolaimageSwitherLeft);
        middleSwitcherkolkolah = findViewById(R.id.kolkolaimageSwitherMiddle);
        rightSwitcherkolkolah = findViewById(R.id.kolkolaimageSwitherRight);

    }
}
