package com.example.soundtest.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

public class TomijHorof extends AppCompatActivity {

    private ImageSwitcher tomijImageSwitcherOne,tomijImageSwitcherTwoZero,tomijImageSwitcherTwoOne;
    private TextSwitcher tomijTextSwitcherOne,tomijTextSwitcherTwo;
    private ImageButton tomijpreviousBttn,tomijnextBttn,tomijrepeatButtn;
    MediaPlayer tomijhorofmedia;
    private int currenthorof=0;

    int[] tomijhorof = {
            R.drawable.tmijhha_ha,
            R.drawable.tomijtoa_ta,
            R.drawable.tomijjoa_jal,
            R.drawable.tomijsoad_seen,
            R.drawable.tomijjeem_jha,
            R.drawable.tomijkof_kaf,
    };

    int [] tomijhorofSound={
            R.raw.tomij_ha_hha,
            R.raw.tomij_toa_taa,
            R.raw.tomij_jowa_jal,
            R.raw.tomij_soad_seen,
            R.raw.tomij_jeem_jha,
            R.raw.tomij_kof_kaf};


    int[] tomijhorofTwoZero = {
            R.drawable.ha,
            R.drawable.toa,
            R.drawable.jowa,
            R.drawable.soad,
            R.drawable.ja,
            R.drawable.kof,
    };

    int[] tomijhorofTwoOne = {
            R.drawable.hha,
            R.drawable.taa,
            R.drawable.jal,
            R.drawable.seen,
            R.drawable.zim,
            R.drawable.kaf,
    };
    String[] makhrazTwoZero = {
            " ه = হলকের শুরু হইতে উচ্চারিত হয়।",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ت",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ذ",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = س",
            "জিহ্বার মধ্যখান হইতে উচ্চারিত হয়। = ج",
            "জিহ্বার গোঁড়া থেকে একটু আগে বাড়াইয়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ك",


    };

    String[] makhrazTwoOne = {

            "হলকের মধ্যখান হইতে উচ্চারিত হয়। = ح",
            "জিহ্বার আগা সামনে উপরের দুই দাঁতের গোঁড়ার সাথে লাগাইয়া। = ط",
            "জিহ্বার আগা সামনে উপরে দুই দাঁতের আগার সাথে লাগাইয়া। = ظ",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ص",
            "িহ্বার আগা সামনে নিচের দুই দাঁতের আগার সাথে লাগাইয়া। = ز",
            "জিহ্বার গোঁড়া তারবরাবর উপরে তালুর সংগে লাগাইয়া = ق",


    };



    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomij_horof);

        init();

        ButtonClick();

        tomijTextSwitcherOne.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        tomijTextSwitcherTwo.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        tomijImageSwitcherOne.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        tomijImageSwitcherTwoZero.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        tomijImageSwitcherTwoOne.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
    }

    private void ButtonClick() {

        tomijnextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((position<tomijhorof.length-1)&& (position<makhrazTwoZero.length-1)){

                    position = position+1;
                    tomijImageSwitcherOne.setBackgroundResource(tomijhorof[position]);
                    tomijImageSwitcherTwoZero.setBackgroundResource(tomijhorofTwoZero[position]);
                    tomijImageSwitcherTwoOne.setBackgroundResource(tomijhorofTwoOne[position]);

                    tomijTextSwitcherOne.setText(makhrazTwoZero[position]);
                    tomijTextSwitcherTwo.setText(makhrazTwoOne[position]);
                    try {
                        tomijhorofmedia = MediaPlayer.create(TomijHorof.this,tomijhorofSound[currenthorof]);
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
                    tomijImageSwitcherOne.setBackgroundResource(tomijhorof[position]);
                    tomijImageSwitcherTwoZero.setBackgroundResource(tomijhorofTwoZero[position]);
                    tomijImageSwitcherTwoOne.setBackgroundResource(tomijhorofTwoOne[position]);
                    try {
                        MediaPlayer.create(TomijHorof.this,tomijhorofSound[currenthorof]);

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
                    tomijhorofmedia = MediaPlayer.create(TomijHorof.this,tomijhorofSound[currenthorof]);

                }
                tomijhorofmedia.start();

            }
        });
    }

    private void init() {

        tomijImageSwitcherOne = findViewById(R.id.tomijimageSwither1);
        tomijImageSwitcherTwoZero = findViewById(R.id.tomijimageSwither2_0);
        tomijImageSwitcherTwoOne = findViewById(R.id.tomijimageSwither2_1);
        tomijTextSwitcherOne = findViewById(R.id.textSwitcher1st);
        tomijTextSwitcherTwo = findViewById(R.id.textSwitcher2nd);
        tomijpreviousBttn = findViewById(R.id.tomijpreviousBtn);
        tomijrepeatButtn =findViewById(R.id.tomijRepeatBtn);
        tomijnextBttn = findViewById(R.id.tomijnextBtn);

    }
}
