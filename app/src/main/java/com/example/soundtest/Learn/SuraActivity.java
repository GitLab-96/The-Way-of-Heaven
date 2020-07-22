package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;

public class SuraActivity extends AppCompatActivity {
    private ImageSwitcher suraImageSwitcher,uccharonImageSwitcher,orthoImageSwitcher;
    private TextSwitcher textSwitcherFatehaTYPING    ;
    private ImageButton suraPrevious,suraNext,suraReplay,suraMic,suracomapre;
    private TextView userVoiceTV;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer fatehamedia,goodToast,badToast;
    private int currentayat=0;
    private SeekBar seekBar;
    private Runnable runnable;
    private Handler handler;


    int[] fateha = {
            R.drawable.bismillah,
            R.drawable.alhamdulillah,
            R.drawable.arrahman,
            R.drawable.malikieaomiddin,
            R.drawable.eiyakanabudu,
            R.drawable.ehdinassiratal,
            R.drawable.siratollajina,
            R.drawable.gairilmagdubialaihim,
            R.drawable.oladdallin,

    };

    int[] fatehauccharon = {
            R.drawable.bismillahbanglauccharon,
            R.drawable.alhamdulillahbanglauccharon,
            R.drawable.arrahmanbanglauccharon,
            R.drawable.malikibanglauccharon,
            R.drawable.eiiakanabudu,
            R.drawable.ihdinassiratalbanglauccharon,
            R.drawable.siratallajinabanglauccharon,
            R.drawable.gairilmagdubialaihimbanglauccharon,
            R.drawable.waladdallinbanglauccharon,

    };

    int[] fatehaortho = {
            R.drawable.bismillahbanglaortho,
            R.drawable.alhamdulillhabanglaortho,
            R.drawable.arrahmanbanglaortho,
            R.drawable.malikibanglaortho,
            R.drawable.eiiakabanglaortho,
            R.drawable.ehdinasbanglaortho,
            R.drawable.siratallajinabanglaortho,
            R.drawable.gairilbanglaortho,
            R.drawable.oladdallinbanglaortho,

    };


    int [] fatehamp3={R.raw.bismillahir,R.raw.alhamdulillah,R.raw.arrahmanir,R.raw.malikieao,R.raw.eiyakabudu,R.raw.ehdinassiratal,R.raw.siratallajina,
            R.raw.gairilmagduni,R.raw.oladdallin};

    String[] fatehapronunciation = {
            "بسم الله الرحمن الرحيم",
            "الحمد لله رب العالمين",
            "الرحمن الرحيم",
            "مالك يوم الدين",
            "اياك نعبد واياك نستعين",
            "اهدنا الصراط المستقيم",
            "صراط الذين أنعمت عليهم",
            "غير المغضوب عليهم",
            "ولا الضالين",
    };
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);

        init();

        buttonClick();

        fatehamedia = MediaPlayer.create(SuraActivity.this,fatehamp3[currentayat]);
        goodToast = MediaPlayer.create(SuraActivity.this,R.raw.masha_allah2);
        badToast = MediaPlayer.create(SuraActivity.this,R.raw.try_again);


        fatehamedia.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                seekBar.setMax(fatehamedia.getDuration());
                fatehamedia.start();
                ChangeSeekbar();
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser){

                    fatehamedia.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        suraImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                suraImageSwitcher.setBackgroundResource(R.drawable.bismillah);
                return imageView;
            }
        });

        uccharonImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                uccharonImageSwitcher.setBackgroundResource(R.drawable.bismillahbanglauccharon);
                return imageView;
            }
        });

        orthoImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                orthoImageSwitcher.setBackgroundResource(R.drawable.bismillahbanglaortho);
                return imageView;
            }
        });

        textSwitcherFatehaTYPING.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });



    }

    private void ChangeSeekbar() {
        seekBar.setProgress(fatehamedia.getCurrentPosition());

        if (fatehamedia.isPlaying()){

            runnable = new Runnable() {
                @Override
                public void run() {
                    ChangeSeekbar();
                }
            };

            handler.postDelayed(runnable,1000);
        }




    }


    private void buttonClick() {

       suraNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<fateha.length-1) {

                    position = position + 1;
                    suraImageSwitcher.setBackgroundResource(fateha[position]);
                    uccharonImageSwitcher.setBackgroundResource(fatehauccharon[position]);
                    orthoImageSwitcher.setBackgroundResource(fatehaortho[position]);
                    textSwitcherFatehaTYPING.setText(fatehapronunciation[position]);

                    try {
                        fatehamedia = MediaPlayer.create(SuraActivity.this,fatehamp3[currentayat]);
                        currentayat++;
                        fatehamedia.start();
                    }catch (Exception e){


                    }

                }
                ChangeSeekbar();

                }

        });

        suraReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fatehamedia == null){
                    fatehamedia = MediaPlayer.create(SuraActivity.this,fatehamp3[currentayat]);

                }
                fatehamedia.start();
                ChangeSeekbar();
            }
        });

        suraPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position>0){

                    position = position-1;
                    suraImageSwitcher.setBackgroundResource(fateha[position]);
                    uccharonImageSwitcher.setBackgroundResource(fatehauccharon[position]);
                    orthoImageSwitcher.setBackgroundResource(fatehaortho[position]);
                    textSwitcherFatehaTYPING.setText(fatehapronunciation[position]);

                    try {
                        MediaPlayer.create(SuraActivity.this,fatehamp3[currentayat]);

                        currentayat--;
                        fatehamedia.start();
                    }catch (Exception e){


                    }

                }
                ChangeSeekbar();

                }
        });
        suraMic.setOnClickListener(new View.OnClickListener() {
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

        suracomapre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sentanceOne = (TextView) textSwitcherFatehaTYPING.getCurrentView();



                String sentanceOnee = sentanceOne.getText().toString();
                String sentenceTwoo = userVoiceTV.getText().toString();

                if (sentanceOnee.equals(sentenceTwoo) ) {

                    Toast.makeText(SuraActivity.this, "Equal", Toast.LENGTH_SHORT).show();
                    goodToast.start();

                }
                else {

                    Toast.makeText(SuraActivity.this, "NotEqual", Toast.LENGTH_SHORT).show();
                    badToast.start();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case  REQUEST_CODE_SPEECH_INPUT:{

                if(resultCode == RESULT_OK && null!= data){

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userVoiceTV.setText(result.get(0));
                }
                break;
            }
        }
    }

    private void init() {
        suraImageSwitcher = findViewById(R.id.suraimageSwither);
        uccharonImageSwitcher = findViewById(R.id.imageSwitcherBanglaUccharon);
        orthoImageSwitcher = findViewById(R.id.imageSwitcherBanglaOrtho);
        textSwitcherFatehaTYPING = findViewById(R.id.presetTextSwitcher);
        suraPrevious = findViewById(R.id.surapreviousBtn);
        suraNext = findViewById(R.id.suranextBtn);
        suraReplay = findViewById(R.id.surareplayBtn);
        suraMic = findViewById(R.id.suramicBtn);
        suracomapre = findViewById(R.id.suracompareBtn);
        userVoiceTV = findViewById(R.id.userVoiceTV);
        seekBar = findViewById(R.id.suraSeekBar);
        handler = new Handler();


    }
}