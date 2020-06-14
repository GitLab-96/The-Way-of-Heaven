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
public class Bodol_Fragment extends Fragment {
    private ImageSwitcher topSwitcherBodol,leftSwitcherBodol,rightSwitcherBodol,middleSwitcherBodol;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer bodolMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] bodolTopImage = {
            R.drawable.baamodd,
            R.drawable.buumodd,
            R.drawable.beemodd,
            R.drawable.baakharamodd,
            R.drawable.baakharajermodd,
            R.drawable.baaultapeshmodd,
    };

    int[] bodolRightImage = {
            R.drawable.baamodd,
            R.drawable.baamodd,
            R.drawable.baamodd,
            R.drawable.baakharamodd,
            R.drawable.baakharamodd,
            R.drawable.baakharamodd,
    };
    int[] bodolMidleImage = {
            R.drawable.book11,
            R.drawable.buumodd,
            R.drawable.buumodd,
            R.drawable.book11,
            R.drawable.baakharajermodd,
            R.drawable.battshakolkolah,
    };
    int[] bodolLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.beemodd,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.baaultapeshmodd,
    };


    int [] bodolsound={R.raw.baamadd,R.raw.buumadd,R.raw.beemadd,R.raw.baakharajobormadd,
            R.raw.baakharajermadd,R.raw.baaultapeshmadd,
    };

    public Bodol_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bodol_, container, false);
        previousBtn = view.findViewById(R.id.bodolPreviousBtn);
        replayBtn = view.findViewById(R.id.bodolRepeatBtn);
        nextBtn = view.findViewById(R.id.bodolNextBtn);
        topSwitcherBodol = view.findViewById(R.id.bodolimageSwitherTop);
        leftSwitcherBodol = view.findViewById(R.id.bodolimageSwitherLeft);
        middleSwitcherBodol = view.findViewById(R.id.bodolimageSwitherMiddle);
        rightSwitcherBodol = view.findViewById(R.id.bodolimageSwitherRight);


        bodolMedia = MediaPlayer.create(getContext(),bodolsound[currenthorkot]);



        topSwitcherBodol.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        rightSwitcherBodol.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        middleSwitcherBodol.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        leftSwitcherBodol.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<bodolTopImage.length-1){

                    position = position+1;
                    topSwitcherBodol.setBackgroundResource(bodolTopImage[position]);
                    rightSwitcherBodol.setBackgroundResource(bodolRightImage[position]);
                    middleSwitcherBodol.setBackgroundResource(bodolMidleImage[position]);
                    leftSwitcherBodol.setBackgroundResource(bodolLeftImage[position]);

                    try {
                        bodolMedia = MediaPlayer.create(getContext(),bodolsound[currenthorkot]);
                        currenthorkot++;
                        bodolMedia.start();
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
                    topSwitcherBodol.setBackgroundResource(bodolTopImage[position]);
                    rightSwitcherBodol.setBackgroundResource(bodolRightImage[position]);
                    middleSwitcherBodol.setBackgroundResource(bodolMidleImage[position]);
                    leftSwitcherBodol.setBackgroundResource(bodolLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),bodolsound[currenthorkot]);
                        bodolMedia.start();
                    }catch (Exception e){

                    }
                }
            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bodolMedia == null){
                    bodolMedia = MediaPlayer.create(getContext(),bodolsound[currenthorkot]);
                }
                bodolMedia.start();
            }
        });

        return view;
    }

}
