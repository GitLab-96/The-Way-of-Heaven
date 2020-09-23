package com.example.soundtest.Salah;


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
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsFragment extends Fragment {

    private TextSwitcher masalaTextSwitcher,masalaTypeTextSwitcher;
    private ImageButton nextBtn,preBtn,playButtn,pauseButtn;

    private TextView textView;
    private ImageSwitcher imageSwitcher;

    private int currenthorof=0;
    MediaPlayer horofmedia,rukurage;

    int position = -1;


    String[] masalah = {
            "হাত উঠানো সুন্নাত",
            "তাকবিরে তাহরিমা আল্লাহু আকবর বলা ফরজ।",
            "হাত বাধা সুন্নাত",
            "সানা পড়া সুন্নাত",
            "আউজুবিল্লাহ পড়া সুন্নাত",
            "িসমিল্লাহ পড়া সুন্নাত ",
            "সূরা এ ফাতেহা পুরা পড়া ওয়াজিব। ",
            "সূরা এ ফাতেহার পর আমিন বলা সুন্নাত",
            "সুরার শুরুতে বিসমিল্লাহ পড়া মুস্তাহাব।",
            "সূরা মিলানো ওয়াজিব",
            "কেরাত পড়া ফরজ ",
            "",
            "রুকুতে জাইবার সময় আল্লাহু আকবার বলা সুন্নাত ",
            "রুকু করা ফরজ ",
            "রুকুতে দেরি করা ওয়াজিব ",
            "রুকুতে থাকিয়া সুবহানা রাব্বিয়াল আজিম, তিনবার বলা সুন্নাত",
            "রুকু হইতে উঠিবার সময় সামিয়াল্লাহু লিমান হামিদাহ বলা সুন্নাত।",
            "রুকু হইতে সোজা হইয়া খাড়া হইয়া দেরি করা ওয়াজিব।",
            "",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে দেরি করা ওয়াজিব ",
            "সেজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "সেজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত। ",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে দেরি করা ওয়াজিব ",
            "েজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত ",
            "েজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত।",
            "সেজদা হইতে সোজা হইয়া খাঁড়া হওয়া ওয়াজিব। ",
            "",
            "হাত বাধা সুন্নাত ",
            "বিসমিল্লাহ পড়া সুন্নাত ",
            "সূরা এ ফাতেহা পুরা পড়া ওয়াজিব। ",
            "সূরা এ ফাতেহার পর আমিন বলা সুন্নাত ",
            "সুরার শুরুতে বিসমিল্লাহ পড়া মুস্তাহাব। ",
            "সূরা মিলানো ওয়াজিব",
            "েরাত পড়া ফরজ ",
            "",
            "রুকুতে জাইবার সময় আল্লাহু আকবার বলা সুন্নাত ",
            "রুকু করা ফরজ ",
            "রুকুতে দেরি করা ওয়াজিব ",
            "রুকুতে থাকিয়া সুবহানা রাব্বিয়াল আজিম, তিনবার বলা সুন্নাত",
            "রুকু হইতে উঠিবার সময় সামিয়াল্লাহু লিমান হামিদাহ বলা সুন্নাত। ",
            "রুকু হইতে সোজা হইয়া খাড়া হইয়া দেরি করা ওয়াজিব। ",
            "",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে দেরি করা ওয়াজিব ",
            "সেজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "সেজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত। ",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে দেরি করা ওয়াজিব ",
            "েজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "েজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত।",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "",
            "আখেরি বৈঠক ফরয ",
            "আত্তাহিয়্যাতু পড়া ওয়াজিব ",
            "দুরুদ শরিফ পড়া সুন্নাত ",
            "দোয়া এ মাসুরা পড়া সুন্নাত",
            "আসসালামু আলাইকুম বলিয়া নামাজ শেষ করা ওয়াজিব"
    };

    String[] masalahType = {
            "হপ্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুর আগে ১১ টি মাসালাহ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুর আগে ৭ টি মাসালাহ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে রুকুতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে প্রথম সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "দ্বিতীয় রাকাতে দ্বিতীয় সেজদাতে ৬ টি মাসালাহ ",
            "আখেরি বৈঠকে ৫ টি মাসালাহ ",
            "আখেরি বৈঠকে ৫ টি মাসালাহ ",
            "আখেরি বৈঠকে ৫ টি মাসালাহ ",
            "আখেরি বৈঠকে ৫ টি মাসালাহ ",
            "আখেরি বৈঠকে ৫ টি মাসালাহ ",

    };

    int imageList[]={R.drawable.hatuthangarls,R.drawable.hatuthangarls,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,

            R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.sojahoiyadaranogirl,R.drawable.sojahoiyadaranogirl,R.drawable.sojahoiyadaranogirl,

            R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,
            R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,

            R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,R.drawable.hatbadhagils,

            R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.rukugirl,R.drawable.sojahoiyadaranogirl,

            R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,
            R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdahgirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,

            R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,R.drawable.sejdayboshagirls,R.drawable.salam1girl};

    int [] horofSound={R.raw.hatuthanosunnat,R.raw.allohuakbarforojmarge,R.raw.hatbadhasunnot,R.raw.sanamarge,
            R.raw.aujubillahmarge,R.raw.bismillahsunnatmarge,R.raw.fatehamarge,R.raw.aminmarge,R.raw.bismillahmustahabmarge,
            R.raw.ikhlasmarge,R.raw.keratporaforoj,

            R.raw.prothomrakaterukute6ti,R.raw.rukutejaibarsomoymarge,R.raw.rukukoraforoj,R.raw.rukutederikorawajib,R.raw.rukutethakiyamarge,R.raw.rukuhoiteuthibarsomoymarge,R.raw.rukuhoitesojahoiyakharahowawajib,

            R.raw.prothomrakatprothomsejdah,R.raw.sejdatejaibarsomoymarge,R.raw.sezdakoraforoj,R.raw.sezdatederiwajib,R.raw.sejdatethakiamarge,R.raw.sejdahhoiteuthibarsomoymarge,R.raw.sejdahoiteboisiaderiwajib,
            R.raw.prothomrakate2sazdate,R.raw.sejdatejaibarsomoymarge,R.raw.sezdakoraforoj,R.raw.sezdatederiwajib,  R.raw.sejdatethakiamarge,R.raw.sejdahhoiteuthibarsomoymarge,R.raw.sejdahoitekharahowawajib,

            R.raw.diyiorakaterukurage,R.raw.hatbadhasunnot,R.raw.bismillahsunnatmarge,R.raw.fatehamarge,R.raw.bismillahmustahabmarge,R.raw.nasmarge,R.raw.keratporaforoj,

            R.raw.ditiorakateprothomsajdate,R.raw.sejdatejaibarsomoymarge,R.raw.sezdakoraforoj,R.raw.sezdatederiwajib,R.raw.sejdatethakiamarge,R.raw.sejdahhoiteuthibarsomoymarge,R.raw.sejdahoiteboisiaderiwajib,
            R.raw.ditiorakateditiosajdate,R.raw.sejdatejaibarsomoymarge,R.raw.sezdakoraforoj,R.raw.sezdatederiwajib,R.raw.sejdatethakiamarge,R.raw.sejdahhoiteuthibarsomoymarge,R.raw.sejdahoiteboisiaderiwajib,


            R.raw.akheriboithoke,R.raw.akheriboithokforoj,R.raw.tashahhudmarge,R.raw.durudmarge,R.raw.masuramarge,R.raw.salammarge,

    };



    public GirlsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_girls, container, false);


        masalaTextSwitcher=view.findViewById(R.id.textSwitcherGirls);
        masalaTypeTextSwitcher = view.findViewById(R.id.masalahTypeTSGirls);
        nextBtn = view.findViewById(R.id.nextBtnGirls);
        playButtn = view.findViewById(R.id.playBtnsalahGirls);
        pauseButtn = view.findViewById(R.id.pauseBtnsalahGirlas);
        preBtn = view.findViewById(R.id.preBtnGirls);
        imageSwitcher = view.findViewById(R.id.imageSwitcherGirls);

        rukurage = MediaPlayer.create(getContext(),R.raw.firsteleven);
        horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);


        rukurage.start();

        masalaTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                textView = new TextView(getContext());
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        masalaTypeTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                textView = new TextView(getContext());
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });



        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                imageSwitcher.setBackgroundResource(R.drawable.hatuthangarls);
                return imageView;
            }
        });
        pauseButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pauseButtn.setVisibility(View.INVISIBLE);
                playButtn.setVisibility(View.VISIBLE);
                if (horofmedia == null){
                    horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);
                    horofmedia.stop();
                }

            }
        });
        playButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pauseButtn.setVisibility(View.VISIBLE);
                playButtn.setVisibility(View.INVISIBLE);

                if (horofmedia == null){

                    horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);

                    horofmedia.start();
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<masalah.length-1){

                    position = position+1;
                    imageSwitcher.setBackgroundResource(imageList[position]);
                    masalaTextSwitcher.setText(masalah[position]);
                    masalaTypeTextSwitcher.setText(masalahType[position]);

                    try {
                        horofmedia = MediaPlayer.create(getContext(),horofSound[currenthorof]);
                        currenthorof++;
                        horofmedia.start();
                    }catch (Exception e){
                    }

                }

            }
        });

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0){

                    position = position-1;
                    masalaTextSwitcher.setText(masalah[position]);
                    masalaTypeTextSwitcher.setText(masalahType[position]);
                    imageSwitcher.setBackgroundResource(imageList[position]);



                    try {

                        currenthorof--;
                        MediaPlayer.create(getContext(),horofSound[currenthorof]);
                        horofmedia.start();
                    }catch (Exception e){


                    }


                }

            }
        });






    return view;
    }

}
