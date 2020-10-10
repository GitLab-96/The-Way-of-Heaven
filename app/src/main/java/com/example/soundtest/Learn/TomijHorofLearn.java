package com.example.soundtest.Learn;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.speech.RecognizerIntent;
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

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomijHorofLearn extends Fragment {

    private ImageSwitcher tomijImageSwitcher,tomijImageSwitcherleft,tomijImageSwitcherright;
    private TextSwitcher tomijTextSwitcherOne,tomijTextSwitcherTwo,pronunciationTS;
    private ImageButton tomijpreviousBttn,tomijnextBttn,tomijrepeatButtn,compareBtn,micButtn;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer tomijhorofmedia,goodToast,badToast;
    private int currenthorof=0;

    TextView userVoiceConvert;



    String[] makhrazTwoZero = {
            " ه = হলকের শুরু হইতে উচ্চারিত হয়।",
            " ه = হলকের শুরু হইতে উচ্চারিত হয়।",
            " ه = হলকের শুরু হইতে উচ্চারিত হয়।",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ت",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ت",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ت",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ذ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ذ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ذ",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = س",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = س",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = س",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়। = ج",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়। = ج",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়। = ج",
            "জিহ্বার গোঁড়া থেকে একটু আগে বাড়াইয়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ك",
            "জিহ্বার গোঁড়া থেকে একটু আগে বাড়াইয়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ك",
            "জিহ্বার গোঁড়া থেকে একটু আগে বাড়াইয়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ك",


    };
    String[] makhrazTwoOne = {

            "হলকের মধ্যখান হইতে উচ্চারিত হয়। = ح",
            "হলকের মধ্যখান হইতে উচ্চারিত হয়। = ح",
            "হলকের মধ্যখান হইতে উচ্চারিত হয়। = ح",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ط",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ط",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ط",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ظ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ظ",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ظ",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ص",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ص",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ص",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ز",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ز",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ز",
            "জিহ্বার গোঁড়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ق",
            "জিহ্বার গোঁড়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ق",
            "জিহ্বার গোঁড়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ق",


    };

    String[] pronunciation = {

            "حاء",
            "حاء",
            "هاء",
            "طاء",
            "طاء",
            "تاء",
            "ظاء",
            "ظاء",
            "ذال",
            "صاد",
            "صاد",
            "سين",
            "زاء",
            "زاء",
            "جيم",
            "قاف",
            "قاف",
            "كاف",


    };



    int [] tomijhorofSound={
            R.raw.tomij_ha_hha,
            R.raw.ha,
            R.raw.haa,
            R.raw.tomij_toa_taa,
            R.raw.toa,
            R.raw.ta,
            R.raw.tomij_jowa_jal,
            R.raw.jowa,
            R.raw.jal,
            R.raw.tomij_soad_seen,
            R.raw.swad,
            R.raw.seen,
            R.raw.tomij_jeem_jha,
            R.raw.jeem,
            R.raw.jha,
            R.raw.tomij_kof_kaf,
            R.raw.kof,
            R.raw.kaf};

    int[] tomijhorof = {
            R.drawable.tmijhha_ha,
            R.drawable.tmijhha_ha,
            R.drawable.tmijhha_ha,
            R.drawable.tomijtoa_ta,
            R.drawable.tomijtoa_ta,
            R.drawable.tomijtoa_ta,
            R.drawable.tomijjoa_jal,
            R.drawable.tomijjoa_jal,
            R.drawable.tomijjoa_jal,
            R.drawable.tomijsoad_seen,
            R.drawable.tomijsoad_seen,
            R.drawable.tomijsoad_seen,
            R.drawable.tomijjeem_jha,
            R.drawable.tomijjeem_jha,
            R.drawable.tomijjeem_jha,
            R.drawable.tomijkof_kaf,
            R.drawable.tomijkof_kaf,
            R.drawable.tomijkof_kaf,
    };
    int[] tomijhorofTwoZero = {
            R.drawable.book11,
            R.drawable.ha,
            R.drawable.ha,

            R.drawable.book11,
            R.drawable.toa,
            R.drawable.toa,

            R.drawable.book11,
            R.drawable.jowa,
            R.drawable.jowa,

            R.drawable.book11,
            R.drawable.soad,
            R.drawable.soad,

            R.drawable.book11,
            R.drawable.ja,
            R.drawable.ja,

            R.drawable.book11,
            R.drawable.kof,
            R.drawable.kof,
    };

    int[] tomijhorofTwoOne = {
            R.drawable.book11,
            R.drawable.book11,
            R.drawable.hha,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.taa,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.jal,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.seen,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.zim,

            R.drawable.book11,
            R.drawable.book11,
            R.drawable.kaf,
    };







    int position = -1;

    public TomijHorofLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_tomij_horof_learn, container, false);


        tomijImageSwitcher = view.findViewById(R.id.TomijimageSwither);
        tomijImageSwitcherleft = view.findViewById(R.id.tomijImageSwitherleft);
        tomijImageSwitcherright = view.findViewById(R.id.tomijImageSwitherright);

        tomijTextSwitcherOne = view.findViewById(R.id.tomijtextSwitcherMakhrajOne);
        tomijTextSwitcherTwo = view.findViewById(R.id.tomijtextSwitcherMakhrajTwo);
        pronunciationTS = view.findViewById(R.id.pronunciationTS);

        tomijpreviousBttn = view.findViewById(R.id.tomijpreviousBtn);
        tomijrepeatButtn =view.findViewById(R.id.tomijplayBtn);
        tomijnextBttn = view.findViewById(R.id.tomijnextBtn);
        compareBtn = view.findViewById(R.id.tpmijcompareBtn);
        micButtn = view.findViewById(R.id.tomijmicBtn);

        userVoiceConvert = view.findViewById(R.id.userVoiceConvert);

        tomijhorofmedia = MediaPlayer.create(getContext(),tomijhorofSound[currenthorof]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);

        ButtonClick();

        tomijImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                tomijImageSwitcher.setBackgroundResource(R.drawable.tmijhha_ha);
                return imageView;
            }
        });

        tomijTextSwitcherOne.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        tomijTextSwitcherTwo.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        pronunciationTS.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });


        tomijImageSwitcherleft.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                tomijImageSwitcherleft.setBackgroundResource(R.drawable.ha);
                return imageView;
            }
        });

        tomijImageSwitcherright.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                tomijImageSwitcherright.setBackgroundResource(R.drawable.hha);
                return imageView;
            }
        });







   return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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

    private void ButtonClick() {

        micButtn.setOnClickListener(new View.OnClickListener() {
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

        compareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sentanceOne = (TextView) pronunciationTS.getCurrentView();

                String sentanceOnee = sentanceOne.getText().toString();

                String sentenceTwoo = userVoiceConvert.getText().toString();

                if (sentanceOnee.equals(sentenceTwoo) ) {

                    goodToast.start();

                }
                else {

                    badToast.start();
                }
            }
        });

        tomijnextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((position<tomijhorof.length-1)&& (position<makhrazTwoZero.length-1)){

                    position = position+1;
                    tomijImageSwitcher.setBackgroundResource(tomijhorof[position]);
                    tomijImageSwitcherleft.setBackgroundResource(tomijhorofTwoZero[position]);
                    tomijImageSwitcherright.setBackgroundResource(tomijhorofTwoOne[position]);

                    tomijTextSwitcherOne.setText(makhrazTwoZero[position]);
                    tomijTextSwitcherTwo.setText(makhrazTwoOne[position]);
                    pronunciationTS.setText(pronunciation[position]);

                    try {
                        tomijhorofmedia.stop();
                        tomijhorofmedia = MediaPlayer.create(getContext(),tomijhorofSound[currenthorof]);
                        currenthorof++;
                        tomijhorofmedia.start();
                    }catch (Exception e){

                    }
                }
            }
        });

        tomijpreviousBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position>0){

                    position = position-1;
                    tomijTextSwitcherOne.setText(makhrazTwoZero[position]);
                    tomijTextSwitcherTwo.setText(makhrazTwoOne[position]);
                    tomijImageSwitcher.setBackgroundResource(tomijhorof[position]);
                    tomijImageSwitcherleft.setBackgroundResource(tomijhorofTwoZero[position]);
                    tomijImageSwitcherright.setBackgroundResource(tomijhorofTwoOne[position]);
                    try {
                        MediaPlayer.create(getContext(),tomijhorofSound[currenthorof]);

                        currenthorof--;
                        tomijhorofmedia.start();
                    }catch (Exception e){


                    }


                }
            }
        });

        tomijrepeatButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tomijhorofmedia == null){
                    tomijhorofmedia = MediaPlayer.create(getContext(),tomijhorofSound[currenthorof]);

                }
                tomijhorofmedia.start();

            }
        });
    }

}
