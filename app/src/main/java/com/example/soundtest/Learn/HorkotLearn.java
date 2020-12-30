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
    private TextSwitcher topSwitcher,leftSwitcher,rightSwitcher,middleSwitcher;
    private TextSwitcher jobortextSwitcher,jertextSwitcher,peshtextSwitcher;
    private ImageButton previousBtn,replayBtn,nextBtn;
    MediaPlayer horkotMedia;
    private int currenthorkot = 0;
    int position  = -1;

    String[] horkotTopImage = {

            "اَ",
            "اِ",
            "اُ",
            "بَ",
            "بِ",
            "بُ",
            "تَ",
            "تِ",
            "تُ",
            "ثَ",
            "ثِ",
            "ثُ",
            "جَ",
            "جِ",
            "جُ",
            "حَ",
            "حُ",
            "خَ",
            "خِ",
            "خُ",
            "دَ",
            "دِ",
            "دُ",
            "ذَ",
            "ذِ",
            "ذُ",
            "رَ",
            "رِ",
            "رُ",
            "زَ",
            "زِ",
            "زُ",
            "سَ",
            "سِ",
            "سُ",
            "شَ",
            "شِ",
            "شُ",
            "صَ",
            "صِ",
            "صُ",
            "ضَ",
            "ضِ",
            "ضُ",
            "طَ",
            "طِ",
            "طُ",
            "ظَ",
            "ظِ",
            "ظُ",
            "عَ",
            "عِ",
            "عُ",
            "غَ",
            "غِ",
            "غُ",
            "فَ",
            "فِ",
            "فُ",
            "قَ",
            "قِ",
            "قُ",
            "كَ",
            "كِ",
            "كُ",
            "لَ",
            "لِ",
            "لُ",
            "مَ",
            "مِ",
            "مُ",
            "نَ",
            "نِ",
            "نُ",
            "وَ",
            "وِ",
            "وُ",
            "ہَ",
            "ہِ",
            "ہُ",
            "ءَ",
            "ءِ",
            "ءُ",
            "ىَ",
            "ىِ",
            "ىُ",

    };

    String[] horkotRightImage = {
            "اَ",
            "اَ",
            "اَ",

            "بَ",
            "بَ",
            "بَ",

            "تَ",
            "تَ",
            "تَ",

            "ثَ",
            "ثَ",
            "ثَ",

            "جَ",
            "جَ",
            "جَ",

            "حَ",
            "حَ",
            "حَ",

            "خَ",
            "خَ",
            "خَ",

            "دَ",
            "دَ",
            "دَ",

            "ذَ",
            "ذَ",
            "ذَ",

            "رَ",
            "رَ",
            "رَ",

            "زَ",
            "زَ",
            "زَ",

            "سَ",
            "سَ",
            "سَ",

            "شَ",
            "شَ",
            "شَ",

            "صَ",
            "صَ",
            "صَ",

            "ضَ",
            "ضَ",
            "ضَ",

            "طَ",
            "طَ",
            "طَ",

            "ظَ",
            "ظَ",
            "ظَ",

            "عَ",
            "عَ",
            "عَ",

            "غَ",
            "غَ",
            "غَ",

            "فَ",
            "فَ",
            "فَ",

            "قَ",
            "قَ",
            "قَ",

            "كَ",
            "كَ",
            "كَ",

            "لَ",
            "لَ",
            "لَ",

            "مَ",
            "مَ",
            "مَ",

            "نَ",
            "نَ",
            "نَ",

            "وَ",
            "وَ",
            "وَ",

            "ہَ",
            "ہَ",
            "ہَ",

            "ءَ",
            "ءَ",
            "ءَ",

            "ىَ",
            "ىَ",
            "ىَ",
    };
    String[] horkotMidleImage = {
            "",
            "اِ",
            "اِ",

            "",
            "بِ",
            "بِ",

            "",
            "تِ",
            "تِ",

            "",
            "ثِ",
            "ثِ",

            "",
            "جِ",
            "جِ",

            "",
            "حِ",
            "حِ",

            "",
            "خِ",
            "خِ",

            "",
            "دِ",
            "دِ",

            "",
            "ذِ",
            "ذِ",

            "",
            "رِ",
            "رِ",

            "",
            "زِ",
            "زِ",

            "",
            "سِ",
            "سِ",

            "",
            "شِ",
            "شِ",
            "",
            "صِ",
            "صِ",
            "",
            "ضِ",
            "ضِ",
            "",
            "طِ",
            "طِ",
            "",
            "ظِ",
            "ظِ",
            "",
            "عِ",
            "عِ",
            "",
            "غِ",
            "غِ",
            "",
            "فِ",
            "فِ",
            "",
            "قِ",
            "قِ",
            "",
            "كِ",
            "كِ",
            "",
            "لِ",
            "لِ",
            "",
            "مِ",
            "مِ",
            "",
            "نِ",
            "نِ",
            "",
            "وِ",
            "وِ",
            "",
            "ہِ",
            "ہِ",
            "",
            "ءِ",
            "ءِ",
            "",
            "ىِ",
            "ىِ",
    };
    String[] horkotLeftImage = {
            "",
            "",
            "اُ",
            "",
            "",
            "بُ",
            "",
            "",
            "تُ",
            "",
            "",
            "ثُ",
            "",
            "",
            "جُ",
            "",
            "",
            "حُ",
            "",
            "",
            "خُ",
            "",
            "",
            "دُ",
            "",
            "",
            "ذُ",
            "",
            "",
            "رُ",
            "",
            "",
            "زُ",
            "",
            "",
            "سُ",
            "",
            "",
            "شُ",
            "",
            "",
            "صُ",
            "",
            "",
            "ضُ",
            "",
            "",
            "طُ",
            "",
            "",
            "ظُ",
            "",
            "",
            "عُ",
            "",
            "",
            "غُ",
            "",
            "",
            "فُ",
            "",
            "",
            "قُ",
            "",
            "",
            "كُ",
            "",
            "",
            "لُ",
            "",
            "",
            "مُ",
            "",
            "",
            "نُ",
            "",
            "",
            "وُ",
            "",
            "",
            "ہُ",
            "",
            "",
            "ءُ",
            "",
            "",
            "ىُ",
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
            R.raw.tajobor,R.raw.tapesh,R.raw.sajobor,R.raw.sajer,R.raw.sapesh,R.raw.alifjer,R.raw.alifpesh,R.raw.bajobor,R.raw.bajer,R.raw.bapesh,R.raw.tajobor,
            R.raw.tajobor,R.raw.tapesh,R.raw.sajobor,R.raw.sajer,R.raw.sapesh,R.raw.alifjer,R.raw.alifpesh,R.raw.bajobor,R.raw.bajer,R.raw.bapesh,R.raw.tajobor,
            R.raw.tajobor,R.raw.tapesh,R.raw.sajobor,R.raw.sajer,R.raw.sapesh,R.raw.alifjer,R.raw.alifpesh,R.raw.bajobor,R.raw.bajer,R.raw.bapesh,R.raw.tajobor,
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
        topSwitcher =  view.findViewById(R.id.topTextSwitcher);
        leftSwitcher = view.findViewById(R.id.leftTextSwitcher);
        middleSwitcher = view.findViewById(R.id.midleTextSwitcher);
        rightSwitcher = view.findViewById(R.id.rightTextSwitcher);
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
                TextView textView = new TextView(getContext());
                textView.setTextSize(150);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText("اَ");
                return textView;
            }
        });

        rightSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText(" اَ");
                return textView;
            }
        });
        middleSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText("");
                return textView;
            }
        });
        leftSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(100);
                textView.setTextColor(getResources().getColor(R.color.blackColor));
                textView.setGravity(Gravity.CENTER);
                textView.setText("");
                return textView;
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<horkotTopImage.length-1){

                    position = position+1;
                    topSwitcher.setText(horkotTopImage[position]);
                    rightSwitcher.setText(horkotRightImage[position]);
                    middleSwitcher.setText(horkotMidleImage[position]);
                    leftSwitcher.setText(horkotLeftImage[position]);

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
                    topSwitcher.setText(horkotTopImage[position]);
                    rightSwitcher.setText(horkotRightImage[position]);
                    middleSwitcher.setText(horkotMidleImage[position]);
                    leftSwitcher.setText(horkotLeftImage[position]);

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
