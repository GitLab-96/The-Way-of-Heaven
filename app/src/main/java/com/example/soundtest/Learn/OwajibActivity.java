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

public class OwajibActivity extends AppCompatActivity {
    private ImageSwitcher topSwitcherOwajib, leftSwitcherOwajib, rightSwitcherOwajib, middleSwitcherOwajib;
    private ImageButton previousBtn, replayBtn, nextBtn;
    MediaPlayer OwajibMedia;
    private int currenthorkot = 0;
    int position = -1;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owajib);

        init();

        OwajibMedia = MediaPlayer.create(OwajibActivity.this, Owajibsound[currenthorkot]);


        topSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcherOwajib.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcherOwajib.setBackgroundResource(R.drawable.book11);
                return imageView;
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

                    try {
                        OwajibMedia = MediaPlayer.create(OwajibActivity.this, Owajibsound[currenthorkot]);
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

                    try {

                        currenthorkot--;
                        MediaPlayer.create(OwajibActivity.this, Owajibsound[currenthorkot]);
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
                    OwajibMedia = MediaPlayer.create(OwajibActivity.this, Owajibsound[currenthorkot]);

                }
                OwajibMedia.start();
            }
        });


    }
    private void init() {

        previousBtn = findViewById(R.id.owajibpreviousBtn);
        replayBtn = findViewById(R.id.owajibRepeatBtn);
        nextBtn = findViewById(R.id.owajibNextBtn);
        topSwitcherOwajib =  findViewById(R.id.owajibimageSwither);
        leftSwitcherOwajib = findViewById(R.id.owajibimageSwither2_0);
        middleSwitcherOwajib = findViewById(R.id.owajibimageSwither2_1);
        rightSwitcherOwajib = findViewById(R.id.owajibimageSwither2_2);

    }
}


