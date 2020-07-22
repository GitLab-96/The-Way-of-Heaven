package com.example.soundtest.Learn;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TobayeFragment extends Fragment {
    private ImageSwitcher topSwitchertobaye,leftSwitchertobaye,rightSwitchertobaye,middleSwitchertobaye;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer tobayeMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] tobayeTopImage = {
            R.drawable.baamodd,
            R.drawable.buumodd,
            R.drawable.beemodd,
            R.drawable.baakharamodd,
            R.drawable.baakharajermodd,
            R.drawable.baaultapeshmodd,
    };

    int[] tobayeRightImage = {
            R.drawable.baamodd,
            R.drawable.baamodd,
            R.drawable.baamodd,
            R.drawable.baakharamodd,
            R.drawable.baakharamodd,
            R.drawable.baakharamodd,
    };
    int[] tobayeMidleImage = {
            R.drawable.book11,
            R.drawable.buumodd,
            R.drawable.buumodd,
            R.drawable.book11,
            R.drawable.baakharajermodd,
            R.drawable.battshakolkolah,
    };
    int[] tobayeLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.beemodd,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.baaultapeshmodd,
    };


    int [] tobayesound={R.raw.baamadd,R.raw.buumadd,R.raw.beemadd,R.raw.baakharajobormadd,
            R.raw.baakharajermadd,R.raw.baaultapeshmadd,
    };


    public TobayeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tobaye, container, false);


        previousBtn = view.findViewById(R.id.tobayePreviousBtn);
        replayBtn = view.findViewById(R.id.tobayeRepeatBtn);
        nextBtn = view.findViewById(R.id.tobayeNextBtn);
        topSwitchertobaye = view.findViewById(R.id.tobayeimageSwitherTop);
        leftSwitchertobaye = view.findViewById(R.id.tobayeimageSwitherLeft);
        middleSwitchertobaye = view.findViewById(R.id.tobayeimageSwitherMiddle);
        rightSwitchertobaye = view.findViewById(R.id.tobayeimageSwitherRight);


        tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);



        topSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitchertobaye.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitchertobaye.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitchertobaye.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitchertobaye.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitchertobaye.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<tobayeTopImage.length-1){

                    position = position+1;
                    topSwitchertobaye.setBackgroundResource(tobayeTopImage[position]);
                    rightSwitchertobaye.setBackgroundResource(tobayeRightImage[position]);
                    middleSwitchertobaye.setBackgroundResource(tobayeMidleImage[position]);
                    leftSwitchertobaye.setBackgroundResource(tobayeLeftImage[position]);

                    try {
                        tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);
                        currenthorkot++;
                        tobayeMedia.start();
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
                    topSwitchertobaye.setBackgroundResource(tobayeTopImage[position]);
                    rightSwitchertobaye.setBackgroundResource(tobayeRightImage[position]);
                    middleSwitchertobaye.setBackgroundResource(tobayeMidleImage[position]);
                    leftSwitchertobaye.setBackgroundResource(tobayeLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),tobayesound[currenthorkot]);
                        tobayeMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tobayeMedia == null){
                    tobayeMedia = MediaPlayer.create(getContext(),tobayesound[currenthorkot]);

                }
                tobayeMedia.start();
            }
        });



   return view;
    }

}
