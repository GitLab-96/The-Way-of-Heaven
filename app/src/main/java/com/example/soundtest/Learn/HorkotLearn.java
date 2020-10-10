package com.example.soundtest.Learn;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorkotLearn extends Fragment {
    private ImageSwitcher topSwitcher,leftSwitcher,rightSwitcher,middleSwitcher;
    private TextSwitcher jobortextSwitcher,jertextSwitcher,peshtextSwitcher;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer horkotMedia;
    private int currenthorkot = 0;
    int position  = -1;

    int[] horkotTopImage = {
            R.drawable.alifjobor,
            R.drawable.alifjer,
            R.drawable.alifpesh,
            R.drawable.bajobor,
            R.drawable.bajer,
            R.drawable.bapesh,
            R.drawable.tajobor,
            R.drawable.tajer,
            R.drawable.tapesh,
            R.drawable.shajobor,
            R.drawable.shajer,
            R.drawable.shapesh,
            R.drawable.jeemjobor,
            R.drawable.jeemjer,
            R.drawable.jeempesh,
            R.drawable.hajobor,
            R.drawable.hajer,
            R.drawable.hapesh,
            R.drawable.khajobor,
            R.drawable.khajer,
            R.drawable.khapesh,
            R.drawable.daljobor,
            R.drawable.daljer,
            R.drawable.dalpesh,
            R.drawable.jaljobor,
            R.drawable.jaljer,
            R.drawable.jalpesh,
            R.drawable.rajobor,
            R.drawable.rajer,
            R.drawable.rapesh,
            R.drawable.jhajobor,
            R.drawable.jhajer,
            R.drawable.jhapesh,
            R.drawable.seenjobor,
            R.drawable.seenjer,
            R.drawable.seenpesh,
            R.drawable.sheenjobor,
            R.drawable.sheenjer,
            R.drawable.sheenpesh,
            R.drawable.soadjobor,
            R.drawable.soadjer,
            R.drawable.soadpesh,
            R.drawable.doadjobor,
            R.drawable.doadjer,
            R.drawable.doadpesh,
            R.drawable.toajobor,
            R.drawable.toajer,
            R.drawable.toapesh,
            R.drawable.joajobor,
            R.drawable.joajer,
            R.drawable.joapesh,
            R.drawable.ainjobor,
            R.drawable.ainjer,
            R.drawable.ainpesh,
            R.drawable.gainjobor,
            R.drawable.gainjer,
            R.drawable.gainpesh,
            R.drawable.fajobor,
            R.drawable.fajer,
            R.drawable.fapesh,
            R.drawable.kofjobor,
            R.drawable.kofjer,
            R.drawable.kofpesh,
            R.drawable.kafjobor,
            R.drawable.kafjer,
            R.drawable.kafpesh,
            R.drawable.lamjobor,
            R.drawable.lamjer,
            R.drawable.lampesh,
            R.drawable.meemjobor,
            R.drawable.meemjer,
            R.drawable.meempesh,
            R.drawable.nunjobor,
            R.drawable.nunjer,
            R.drawable.nunpesh,
            R.drawable.owaojobor,
            R.drawable.owaojer,
            R.drawable.owaopesh,
            R.drawable.hhajobor,
            R.drawable.hhajer,
            R.drawable.hhapesh,
            R.drawable.eyajobor,
            R.drawable.eyajer,
            R.drawable.eyapesh,
    };

    int[] horkotRightImage = {
            R.drawable.alifjobor,
            R.drawable.alifjobor,
            R.drawable.alifjobor,
            R.drawable.bajobor,
            R.drawable.bajobor,
            R.drawable.bajobor,
            R.drawable.tajobor,
            R.drawable.tajobor,
            R.drawable.tajobor,
            R.drawable.shajobor,
            R.drawable.shajobor,
            R.drawable.shajobor,
            R.drawable.jeemjobor,
            R.drawable.jeemjobor,
            R.drawable.jeemjobor,
            R.drawable.hajobor,
            R.drawable.hajobor,
            R.drawable.hajobor,
            R.drawable.khajobor,
            R.drawable.khajobor,
            R.drawable.khajobor,
            R.drawable.daljobor,
            R.drawable.daljobor,
            R.drawable.daljobor,
            R.drawable.jaljobor,
            R.drawable.jaljobor,
            R.drawable.jaljobor,
            R.drawable.rajobor,
            R.drawable.rajobor,
            R.drawable.rajobor,
            R.drawable.jhajobor,
            R.drawable.jhajobor,
            R.drawable.jhajobor,
            R.drawable.seenjobor,
            R.drawable.seenjobor,
            R.drawable.seenjobor,
            R.drawable.sheenjobor,
            R.drawable.sheenjobor,
            R.drawable.sheenjobor,
            R.drawable.soadjobor,
            R.drawable.soadjobor,
            R.drawable.soadjobor,
            R.drawable.doadjobor,
            R.drawable.doadjobor,
            R.drawable.doadjobor,
            R.drawable.toajobor,
            R.drawable.toajobor,
            R.drawable.toajobor,
            R.drawable.joajobor,
            R.drawable.joajobor,
            R.drawable.joajobor,
            R.drawable.ainjobor,
            R.drawable.ainjobor,
            R.drawable.ainjobor,
            R.drawable.gainjobor,
            R.drawable.gainjobor,
            R.drawable.gainjobor,
            R.drawable.fajobor,
            R.drawable.fajobor,
            R.drawable.fajobor,
            R.drawable.kofjobor,
            R.drawable.kofjobor,
            R.drawable.kofjobor,
            R.drawable.kafjobor,
            R.drawable.kafjobor,
            R.drawable.kafjobor,
            R.drawable.lamjobor,
            R.drawable.lamjobor,
            R.drawable.lamjobor,
            R.drawable.meemjobor,
            R.drawable.meemjobor,
            R.drawable.meemjobor,
            R.drawable.nunjobor,
            R.drawable.nunjobor,
            R.drawable.nunjobor,
            R.drawable.owaojobor,
            R.drawable.owaojobor,
            R.drawable.owaojobor,
            R.drawable.hhajobor,
            R.drawable.hhajobor,
            R.drawable.hhajobor,
            R.drawable.eyajobor,
            R.drawable.eyajobor,
            R.drawable.eyajobor,
    };
    int[] horkotMidleImage = {
            R.drawable.book11,
            R.drawable.alifjer,
            R.drawable.alifjer,
            R.drawable.book11,
            R.drawable.bajer,
            R.drawable.bajer,
            R.drawable.book11,
            R.drawable.tajer,
            R.drawable.tajer,
            R.drawable.book11,
            R.drawable.shajer,
            R.drawable.shajer,
            R.drawable.book11,
            R.drawable.jeemjer,
            R.drawable.jeemjer,
            R.drawable.book11,
            R.drawable.hajer,
            R.drawable.hajer,
            R.drawable.book11,
            R.drawable.khajer,
            R.drawable.khajer,
            R.drawable.book11,
            R.drawable.daljer,
            R.drawable.daljer,
            R.drawable.book11,
            R.drawable.jaljer,
            R.drawable.jaljer,
            R.drawable.book11,
            R.drawable.rajer,
            R.drawable.rajer,
            R.drawable.book11,
            R.drawable.jhajer,
            R.drawable.jhajer,
            R.drawable.book11,
            R.drawable.seenjer,
            R.drawable.seenjer,
            R.drawable.book11,
            R.drawable.sheenjer,
            R.drawable.sheenjer,
            R.drawable.book11,
            R.drawable.soadjer,
            R.drawable.soadjer,
            R.drawable.book11,
            R.drawable.doadjer,
            R.drawable.doadjer,
            R.drawable.book11,
            R.drawable.toajer,
            R.drawable.toajer,
            R.drawable.book11,
            R.drawable.joajer,
            R.drawable.joajer,
            R.drawable.book11,
            R.drawable.ainjer,
            R.drawable.ainjer,
            R.drawable.book11,
            R.drawable.gainjer,
            R.drawable.gainjer,
            R.drawable.book11,
            R.drawable.fajer,
            R.drawable.fajer,
            R.drawable.book11,
            R.drawable.kofjer,
            R.drawable.kofjer,
            R.drawable.book11,
            R.drawable.kafjer,
            R.drawable.kafjer,
            R.drawable.book11,
            R.drawable.lamjer,
            R.drawable.lamjer,
            R.drawable.book11,
            R.drawable.meemjer,
            R.drawable.meemjer,
            R.drawable.book11,
            R.drawable.nunjer,
            R.drawable.nunjer,
            R.drawable.book11,
            R.drawable.owaojer,
            R.drawable.owaojer,
            R.drawable.book11,
            R.drawable.hhajer,
            R.drawable.hhajer,
            R.drawable.book11,
            R.drawable.eyajer,
            R.drawable.eyajer,
    };
    int[] horkotLeftImage = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.alifpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.bapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.tapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.shapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jeempesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.hapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.khapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.dalpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jalpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.rapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jhapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.seenpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.sheenpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.soadpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.doadpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.toapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.joapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.ainpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.gainpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.fapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.kofpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.kafpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.lampesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.meempesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.nunpesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.owaopesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.hhapesh,
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.eyapesh,
    };
    String[] HorkotSpacificationjobor = {
            " আলিফ যবর 'আ'",
            " আলিফ যবর 'আ'",
            " আলিফ যবর 'আ'",
            " বা যবর 'বা'",
            " বা যবর 'বা'",
            " বা যবর 'বা''",
            " তা যবর 'তা'",
            " তা যবর 'তা'",
            " তা যবর 'তা'",
            " ছা যবর 'ছা'",
            " ছা যবর 'ছা'",
            " ছা যবর 'ছা'",
    };
    String[] HorkotSpacificationjer = {

            "",
            " আলিফ যের 'ই'",
            " আলিফ যের 'ই'",
            "",
            " বা যের 'বি'",
            " বা যের 'বি'",
            "",
            " তা যের 'তি'",
            " তা যের 'তি'",
            "",
            " ছা যের 'ছি'",
            " ছা যের 'ছি'",

    };
    String[] HorkotSpacificationpesh = {

            "",
            "",
            " আলিফ পেশ 'উ'",
            "",
            "",
            " বা পেশ 'বু'",
            "",
            "",
            " তা পেশ 'তু'",
            "",
            "",
            " ছা পেশ 'ছু'",
    };
    int [] horkotSound={R.raw.alifjobor,R.raw.alifjer,R.raw.alifpesh,R.raw.bajobor,R.raw.bajer,R.raw.bapesh,R.raw.tajobor,
            R.raw.tajobor,R.raw.tapesh,R.raw.sajobor,R.raw.sajer,R.raw.sapesh};



    public HorkotLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_horkot_learn, container, false);
        previousBtn = view.findViewById(R.id.previousBtn);
        replayBtn = view.findViewById(R.id.replayBtn);
        nextBtn = view.findViewById(R.id.tomijnextBtn);
        topSwitcher =  view.findViewById(R.id.topImageSwitcher);
        leftSwitcher = view.findViewById(R.id.leftImageSwitcher);
        middleSwitcher = view.findViewById(R.id.midleImageSwitcher);
        rightSwitcher = view.findViewById(R.id.rightImageSwitcher);
        jobortextSwitcher = view.findViewById(R.id.jobor_spacificationTS);
        jertextSwitcher = view.findViewById(R.id.jer_spacificationTS);
        peshtextSwitcher = view.findViewById(R.id.pesh_spacificationTS);
        horkotMedia = MediaPlayer.create(getContext(),horkotSound[currenthorkot]);

        jobortextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(25);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText(" আলিফ যবর 'আ'");
                return textView;
            }
        });
        jertextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(25);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText("আলিফ যের 'ই'");
                return textView;
            }
        });
        peshtextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(25);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText("আলিফ পেশ 'উ'");
                return textView;
            }
        });

        topSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                topSwitcher.setBackgroundResource(R.drawable.alifjobor);
                return imageView;
            }
        });

        rightSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                rightSwitcher.setBackgroundResource(R.drawable.alifjobor);
                return imageView;
            }
        });
        middleSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                middleSwitcher.setBackgroundResource(R.drawable.alifjer);
                return imageView;
            }
        });
        leftSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                leftSwitcher.setBackgroundResource(R.drawable.alifpesh);
                return imageView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<horkotTopImage.length-1){

                    position = position+1;
                    topSwitcher.setBackgroundResource(horkotTopImage[position]);
                    rightSwitcher.setBackgroundResource(horkotRightImage[position]);
                    middleSwitcher.setBackgroundResource(horkotMidleImage[position]);
                    leftSwitcher.setBackgroundResource(horkotLeftImage[position]);

                    jobortextSwitcher.setText(HorkotSpacificationjobor[position]);
                    jertextSwitcher.setText(HorkotSpacificationjer[position]);
                    peshtextSwitcher.setText(HorkotSpacificationpesh[position]);

                    try {
                        horkotMedia.stop();
                        horkotMedia = MediaPlayer.create(getContext(),horkotSound[currenthorkot]);
                        currenthorkot++;
                        horkotMedia.start();
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
                    topSwitcher.setBackgroundResource(horkotTopImage[position]);
                    rightSwitcher.setBackgroundResource(horkotRightImage[position]);
                    middleSwitcher.setBackgroundResource(horkotMidleImage[position]);
                    leftSwitcher.setBackgroundResource(horkotLeftImage[position]);

                    jobortextSwitcher.setText(HorkotSpacificationjobor[position]);
                    jertextSwitcher.setText(HorkotSpacificationjer[position]);
                    peshtextSwitcher.setText(HorkotSpacificationpesh[position]);

                    try {
                        horkotMedia.stop();
                        currenthorkot--;
                        MediaPlayer.create(getContext(),horkotSound[currenthorkot]);
                        horkotMedia.start();
                    }catch (Exception e){

                    }


                }

            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (horkotMedia == null){
                    horkotMedia = MediaPlayer.create(getContext(),horkotSound[currenthorkot]);

                }
                horkotMedia.start();
            }
        });


        return view;
    }

}
