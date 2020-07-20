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
public class PurFragment extends Fragment {
    private ImageSwitcher topSwitcher_roPur,leftSwitcher_roPur,rightSwitcher_roPur,middleSwitcher_roPur;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer roPurMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] roPurTopImage = {
            R.drawable.amara,
            R.drawable.rusulun,
            R.drawable.garkan,
            R.drawable.quranan,
    };

    int[] roPurRightImage = {
            R.drawable.amara,
            R.drawable.amara,
            R.drawable.amara,
            R.drawable.quranan,

    };
    int[] roPurMidleImage = {
            R.drawable.book11,
            R.drawable.rusulun,
            R.drawable.rusulun,
            R.drawable.quranan,
    };
    int[] roPurLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.garkan,
            R.drawable.quranan,
    };


    int [] roPursound={R.raw.amaro,R.raw.rusulun,R.raw.gorkon,R.raw.quraanun,

    };


    public PurFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pur, container, false);



        previousBtn = view.findViewById(R.id.roMotaPreviousBtn);
        replayBtn = view.findViewById(R.id.roMotaRepeatBtn);
        nextBtn = view.findViewById(R.id.roMotaNextBtn);
        topSwitcher_roPur = view.findViewById(R.id.roMotaimageSwitherTop);
        leftSwitcher_roPur = view.findViewById(R.id.roMotaimageSwitherLeft);
        middleSwitcher_roPur = view.findViewById(R.id.roMotaimageSwitherMiddle);
        rightSwitcher_roPur = view.findViewById(R.id.roMotaimageSwitherRight);


        roPurMedia = MediaPlayer.create(getContext(),roPursound[currenthorkot]);



        topSwitcher_roPur.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        rightSwitcher_roPur.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        middleSwitcher_roPur.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        leftSwitcher_roPur.setFactory(new ViewSwitcher.ViewFactory() {
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

                if(position<roPurTopImage.length-1){

                    position = position+1;
                    topSwitcher_roPur.setBackgroundResource(roPurTopImage[position]);
                    rightSwitcher_roPur.setBackgroundResource(roPurRightImage[position]);
                    middleSwitcher_roPur.setBackgroundResource(roPurMidleImage[position]);
                    leftSwitcher_roPur.setBackgroundResource(roPurLeftImage[position]);

                    try {
                        roPurMedia = MediaPlayer.create(getContext(),roPursound[currenthorkot]);
                        currenthorkot++;
                        roPurMedia.start();
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
                    topSwitcher_roPur.setBackgroundResource(roPurTopImage[position]);
                    rightSwitcher_roPur.setBackgroundResource(roPurRightImage[position]);
                    middleSwitcher_roPur.setBackgroundResource(roPurMidleImage[position]);
                    leftSwitcher_roPur.setBackgroundResource(roPurLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),roPursound[currenthorkot]);
                        roPurMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roPurMedia == null){
                    roPurMedia = MediaPlayer.create(getContext(),roPursound[currenthorkot]);

                }
                roPurMedia.start();
            }
        });








        return view;

    }

}
