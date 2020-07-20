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
public class AllahFragmentMota extends Fragment {

    private ImageSwitcher topSwitchermota,leftSwitchermota,rightSwitchermota,middleSwitchermota;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer motaMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] motaTopImage = {
            R.drawable.innalloha,

            R.drawable.kolallohu,

            R.drawable.samiallohu,

            R.drawable.hududullohi,

            R.drawable.uridullohu,

            R.drawable.kholkullohi,
    };

    int[] motaRightImage = {
            R.drawable.innalloha,
            R.drawable.innalloha,
            R.drawable.innalloha,


            R.drawable.hududullohi,
            R.drawable.baakharamodd,
            R.drawable.baakharamodd,
    };
    int[] motaMidleImage = {
            R.drawable.book11,
            R.drawable.kolallohu,
            R.drawable.kolallohu,

            R.drawable.book11,
            R.drawable.uridullohu,
            R.drawable.uridullohu,
    };
    int[] motaLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.samiallohu,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.kholkullohi,
    };


    int [] motasound={R.raw.innalloha,R.raw.kolallohu,R.raw.samiallohu,R.raw.hidullohi,
            R.raw.uridullohu,R.raw.kholqullahi,
    };
    public AllahFragmentMota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_allah_fragment_mota, container, false);


        previousBtn = view.findViewById(R.id.motaPreviousBtn);
        replayBtn = view.findViewById(R.id.motaRepeatBtn);
        nextBtn = view.findViewById(R.id.motaNextBtn);
        topSwitchermota = view.findViewById(R.id.motaimageSwitherTop);
        leftSwitchermota = view.findViewById(R.id.motaimageSwitherLeft);
        middleSwitchermota = view.findViewById(R.id.motaimageSwitherMiddle);
        rightSwitchermota = view.findViewById(R.id.motaimageSwitherRight);


        motaMedia = MediaPlayer.create(getContext(),motasound[currenthorkot]);



        topSwitchermota.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        rightSwitchermota.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        middleSwitchermota.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        leftSwitchermota.setFactory(new ViewSwitcher.ViewFactory() {
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

                if(position<motaTopImage.length-1){

                    position = position+1;
                    topSwitchermota.setBackgroundResource(motaTopImage[position]);
                    rightSwitchermota.setBackgroundResource(motaRightImage[position]);
                    middleSwitchermota.setBackgroundResource(motaMidleImage[position]);
                    leftSwitchermota.setBackgroundResource(motaLeftImage[position]);

                    try {
                        motaMedia = MediaPlayer.create(getContext(),motasound[currenthorkot]);
                        currenthorkot++;
                        motaMedia.start();
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
                    topSwitchermota.setBackgroundResource(motaTopImage[position]);
                    rightSwitchermota.setBackgroundResource(motaRightImage[position]);
                    middleSwitchermota.setBackgroundResource(motaMidleImage[position]);
                    leftSwitchermota.setBackgroundResource(motaLeftImage[position]);

                    try {

                        currenthorkot--;
                        MediaPlayer.create(getContext(),motasound[currenthorkot]);
                        motaMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (motaMedia == null){
                    motaMedia = MediaPlayer.create(getContext(),motasound[currenthorkot]);

                }
                motaMedia.start();
            }
        });


        return view;
    }

}
