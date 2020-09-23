package com.example.soundtest.Learn;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurahLearn extends Fragment {
    private ImageSwitcher suraImageSwitcher,uccharonImageSwitcher,orthoImageSwitcher;
    private TextSwitcher textSwitcherFatehaTYPING    ;
    private ImageButton suraPrevious,suraNext,suraReplay,suraMic,suracomapre;
    private TextView userVoiceTV,suraName;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer fatehamedia,feelmedia,goodToast,badToast;
    private int currentayat=0;
    private SeekBar seekBar;
    private Runnable runnable;
    private Handler handler;

    Spinner spinner;




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
    int[]  feel = {
            R.drawable.bismillah,
            R.drawable.alamtarokaifa,
            R.drawable.alamyajal,
            R.drawable.waarsalaalaihim,
            R.drawable.tarmihimbihijaroh,
            R.drawable.fajaalahumkaasfimmakul,

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
    int[] feeluccharon = {
            R.drawable.bismillahbanglauccharon,
            R.drawable.fiilpronunciation1,
            R.drawable.fiilpronunciation2,
            R.drawable.fiilpronunciation3,
            R.drawable.fiilpronunciation4,
            R.drawable.fiilpronunciation5,

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
    int[] feelaortho = {
            R.drawable.bismillahbanglaortho,
            R.drawable.fiil1ortho,
            R.drawable.fiil2ortho,
            R.drawable.fiil3ortho,
            R.drawable.fiil5ortho,
            R.drawable.fiil6ortho,
    };


    int [] fatehamp3={R.raw.bismillahir,R.raw.alhamdulillah,R.raw.arrahmanir,R.raw.malikieao,R.raw.eiyakabudu,R.raw.ehdinassiratal,R.raw.siratallajina,
            R.raw.gairilmagduni,R.raw.oladdallin};

    int [] feelamp3={R.raw.bismillahir,R.raw.alamtaroksifa,R.raw.alamyajalkaidahum,R.raw.waarsalaalihimtoiran,R.raw.tarmihimbihijarotim,R.raw.fajaalahumkaasfimmm,};

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

    String[] feelpronunciation = {
            "بسم الله الرحمن الرحيم",
            "الم تر كيف فعل ربك باصاب الفيل",
            "الم يجعل كيدهم في تضليل",
            "وارسل عليهم طيرا ابابيل",
            "ترميهم بحجارة من سجيل",
            "فجعلهم كعصف ماكول",
    };
    int position_array = -1;


    public SurahLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surah_learn, container, false);
        suraImageSwitcher = view.findViewById(R.id.suraimageSwither);
        uccharonImageSwitcher = view.findViewById(R.id.imageSwitcherBanglaUccharon);
        orthoImageSwitcher = view.findViewById(R.id.imageSwitcherBanglaOrtho);
        textSwitcherFatehaTYPING = view.findViewById(R.id.presetTextSwitcher);
        suraPrevious = view.findViewById(R.id.surapreviousBtn);
        suraNext = view.findViewById(R.id.suranextBtn);
        suraReplay = view.findViewById(R.id.surareplayBtn);
        suraMic = view.findViewById(R.id.suramicBtn);
        suracomapre = view.findViewById(R.id.suracompareBtn);
        userVoiceTV = view.findViewById(R.id.userVoiceTV);
        seekBar = view.findViewById(R.id.suraSeekBar);
        handler = new Handler();
        suraName = view.findViewById(R.id.suraName);

        spinner= view.findViewById(R.id.surahSpinner);

        selectSura();





        fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);
        feelmedia =  MediaPlayer.create(getContext(),feelamp3[currentayat]);
        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);


        fatehamedia.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                seekBar.setMax(fatehamedia.getDuration());
                fatehamedia.start();
                ChangeSeekbar();
            }
        });

        feelmedia.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                seekBar.setMax(feelmedia.getDuration());
                feelmedia.start();
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
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                suraImageSwitcher.setBackgroundResource(R.drawable.bismillah);
                return imageView;
            }
        });

        uccharonImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                uccharonImageSwitcher.setBackgroundResource(R.drawable.bismillahbanglauccharon);
                return imageView;
            }
        });

        orthoImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                orthoImageSwitcher.setBackgroundResource(R.drawable.bismillahbanglaortho);
                return imageView;
            }
        });

        textSwitcherFatehaTYPING.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
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

                    Toast.makeText(getContext(), "Equal", Toast.LENGTH_SHORT).show();
                    goodToast.start();

                }
                else {

                    Toast.makeText(getContext(), "NotEqual", Toast.LENGTH_SHORT).show();
                    badToast.start();
                }
            }
        });






        return view;
    }

    private void selectSura() {

        final ArrayList<String> surahList = new ArrayList<>();

        surahList.add("Fateha");
        surahList.add("Feel"); surahList.add("Quraish"); surahList.add("Maun"); surahList.add("Kaosar"); surahList.add("Kafirun");
        surahList.add("Nasr"); surahList.add("Lahab"); surahList.add("Ikhlas"); surahList.add("Falaq"); surahList.add("Nas");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,surahList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String sura_name = surahList.get(position);

                if (sura_name=="Fateha"){
                    suraName.setText("সূরা ফাতেহা");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<fateha.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(fateha[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(fatehauccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(fatehaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(fatehapronunciation[position_array]);

                                try {
                                    fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);
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
                                fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);

                            }
                            fatehamedia.start();
                            ChangeSeekbar();
                        }
                    });

                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(fateha[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(fatehauccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(fatehaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(fatehapronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),fatehamp3[currentayat]);

                                    currentayat--;
                                    fatehamedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });

                }
                else if (sura_name=="Feel"){
                    suraName.setText("সূরা ফীল");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });

                }
                else if (sura_name=="Quraish"){

                    suraName.setText("সূরা কুরাইশ");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });

                }
                else if (sura_name=="Maun"){
                    suraName.setText("সূরা মাউন");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Kaosar"){
                    suraName.setText("সূরা কাওসার");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Kafirun"){
                    suraName.setText("সূরা কাফিরুন");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Nasr"){
                    suraName.setText("সূরা নাসর");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Lahab"){
                    suraName.setText("সূরা লাহাব");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Ikhlas"){
                    suraName.setText("সূরা ইখলাস");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Falaq"){
                    suraName.setText("সূরা ফালাক");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }
                else if (sura_name=="Nas"){
                    suraName.setText("সূরা নাস");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();
                            ChangeSeekbar();
                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setBackgroundResource(feel[position_array]);
                                uccharonImageSwitcher.setBackgroundResource(feeluccharon[position_array]);
                                orthoImageSwitcher.setBackgroundResource(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }
                            ChangeSeekbar();

                        }
                    });


                }


              }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        }else if(feelmedia.isPlaying()){

            runnable = new Runnable() {
                @Override
                public void run() {
                    ChangeSeekbar();
                }
            };

            handler.postDelayed(runnable,1000);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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




}
