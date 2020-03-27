package com.example.soundtest.Salah;


import android.os.Bundle;

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
public class BoysFragment extends Fragment {


    private TextSwitcher textSwitcher;
    private ImageButton nextBtn,preBtn;
    private int stringIndex=0;
    private TextView textView;
    private ImageSwitcher imageSwitcher;


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
            "রুকুতে জাইবার সময় আল্লাহু আকবার বলা সুন্নাত ",
            "রুকু করা ফরজ ",
            "রুকুতে দেরি করা ওয়াজিব ",
            "রুকুতে থাকিয়া সুবহানা রাব্বিয়াল আজিম, তিনবার বলা সুন্নাত",
            "রুকু হইতে উঠিবার সময় সামিয়াল্লাহু লিমান হামিদাহ বলা সুন্নাত।",
            "রুকু হইতে সোজা হইয়া খাড়া হইয়া দেরি করা ওয়াজিব।",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "সেজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত। ",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "েজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত ",
            "েজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত।",
            "সেজদা হইতে সোজা হইয়া খাঁড়া হওয়া ওয়াজিব। ",
            "হাত বাধা সুন্নাত ",
            "বিসমিল্লাহ পড়া সুন্নাত ",
            "সূরা এ ফাতেহা পুরা পড়া ওয়াজিব। ",
            "সূরা এ ফাতেহার পর আমিন বলা সুন্নাত ",
            "সুরার শুরুতে বিসমিল্লাহ পড়া মুস্তাহাব। ",
            "সূরা মিলানো ওয়াজিব",
            "েরাত পড়া ফরজ ",
            "রুকুতে জাইবার সময় আল্লাহু আকবার বলা সুন্নাত ",
            "রুকু করা ফরজ ",
            "রুকুতে দেরি করা ওয়াজিব ",
            "রুকুতে থাকিয়া সুবহানা রাব্বিয়াল আজিম, তিনবার বলা সুন্নাত",
            "রুকু হইতে উঠিবার সময় সামিয়াল্লাহু লিমান হামিদাহ বলা সুন্নাত। ",
            "রুকু হইতে সোজা হইয়া খাড়া হইয়া দেরি করা ওয়াজিব। ",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "সেজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "সেজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত। ",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "সেজদাতে জাইবার সময় আল্লাহু আকবর বলা সুন্নাত। ",
            "সেজদা করা ফরজ। ",
            "েজদাতে থাকিয়া সুবহানা রাব্বিয়াল আলা,তিনবার বলা সুন্নাত",
            "েজদা হইতে উঠিবার সময় আল্লাহু আকবার বলা সুন্নাত।",
            "সেজদা হইতে সোজা হইয়া বসিয়া দেরি করা ওয়াজিব। ",
            "আখেরি বৈঠক ফরয ",
            "আত্তাহিয়্যাতু পড়া ওয়াজিব ",
            "দুরুদ শরিফ পড়া সুন্নাত ",
            "দোয়া এ মাসুরা পড়া সুন্নাত",
            "আসসালামু আলাইকুম বলিয়া নামাজ শেষ করা ওয়াজিব"
    };
    int imageList[]={R.drawable.hatuthanboys,R.drawable.hatuthanboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.rukuboys,R.drawable.rukuboys,R.drawable.rukuboys,R.drawable.shojadaranoboys,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboshaboy,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.hatbadhaboys,R.drawable.rukuboys,R.drawable.rukuboys,R.drawable.rukuboys,R.drawable.shojadaranoboys,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboshaboy,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboys,R.drawable.sejdahboshaboy,R.drawable.sejdahboshaboy,R.drawable.sejdahboshaboy,R.drawable.sejdahboshaboy,R.drawable.salamboys};



    public BoysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_boys, container, false);


        textSwitcher=view.findViewById(R.id.textSwitcher);
        nextBtn = view.findViewById(R.id.nextBtn);
        preBtn = view.findViewById(R.id.preBtn);
        imageSwitcher = view.findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView= new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT
                ));
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageList[0]);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stringIndex==masalah.length-1){
                    stringIndex = 0;
                    textSwitcher.setText(masalah[stringIndex]);
                    imageSwitcher.setImageResource(imageList[stringIndex]);
                }
                else {

                    textSwitcher.setText(masalah[++stringIndex]);
                    imageSwitcher.setImageResource(imageList[++stringIndex]);
                }

            }
        });

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --stringIndex;
                if(stringIndex>0){
                    stringIndex = stringIndex-1;
                    textSwitcher.setText(masalah[stringIndex]);
                    imageSwitcher.setImageResource(imageList[stringIndex]);
                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                textView = new TextView(getContext());
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        textSwitcher.setText(masalah[stringIndex]);




        return view;
    }

}
