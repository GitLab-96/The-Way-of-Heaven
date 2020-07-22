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
public class IqlabFragment extends Fragment {

    private ImageSwitcher topSwitcheriqlab,leftSwitcheriqlab,rightSwitcheriqlab,middleSwitcheriqlab;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer iqlabMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] iqlabTopImage = {
            R.drawable.mimmbadi,
            R.drawable.samiumbadi,
            R.drawable.lanasfambinnasiah,

            R.drawable.hadisimbadahu,
            R.drawable.rojumbaid,
            R.drawable.khabirambasiran,

            R.drawable.laumbajanna,
    };

    int[] iqlabRightImage = {
            R.drawable.mimmbadi,
            R.drawable.mimmbadi,
            R.drawable.mimmbadi,

            R.drawable.hadisimbadahu,
            R.drawable.hadisimbadahu,
            R.drawable.hadisimbadahu,

            R.drawable.hadisimbadahu,



    };
    int[] iqlabMidleImage = {
            R.drawable.book11,
            R.drawable.samiumbadi,
            R.drawable.samiumbadi,

            R.drawable.book11,
            R.drawable.rojumbaid,
            R.drawable.rojumbaid,

            R.drawable.hadisimbadahu,


    };
    int[] iqlabLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.lanasfambinnasiah,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.khabirambasiran,

            R.drawable.hadisimbadahu,
    };


    int [] iqlabsound={R.raw.mimbadi,R.raw.samiumbasira,R.raw.lanasfambinnasiati,R.raw.hadisimbadahu,
            R.raw.rojumdaidun,R.raw.khabiranbasiran,  R.drawable.laumbajanna,
    };


    public IqlabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_iqlab, container, false);


        previousBtn = view.findViewById(R.id.iqlabPreviousBtn);
        replayBtn = view.findViewById(R.id.iqlabRepeatBtn);
        nextBtn = view.findViewById(R.id.iqlabNextBtn);
        topSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherTop);
        leftSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherLeft);
        middleSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherMiddle);
        rightSwitcheriqlab = view.findViewById(R.id.iqlabimageSwitherRight);


        iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);



        topSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        rightSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        middleSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });
        leftSwitcheriqlab.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcheriqlab.setBackgroundResource(R.drawable.book11);
                return imageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<iqlabTopImage.length-1){

                    position = position+1;
                    topSwitcheriqlab.setBackgroundResource(iqlabTopImage[position]);
                    rightSwitcheriqlab.setBackgroundResource(iqlabRightImage[position]);
                    middleSwitcheriqlab.setBackgroundResource(iqlabMidleImage[position]);
                    leftSwitcheriqlab.setBackgroundResource(iqlabLeftImage[position]);

                    try {
                        iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);
                        currenthorkot++;
                        iqlabMedia.start();
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
                    topSwitcheriqlab.setBackgroundResource(iqlabTopImage[position]);
                    rightSwitcheriqlab.setBackgroundResource(iqlabRightImage[position]);
                    middleSwitcheriqlab.setBackgroundResource(iqlabMidleImage[position]);
                    leftSwitcheriqlab.setBackgroundResource(iqlabLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);
                        iqlabMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (iqlabMedia == null){
                    iqlabMedia = MediaPlayer.create(getContext(),iqlabsound[currenthorkot]);

                }
                iqlabMedia.start();
            }
        });









        return view;
    }

}
