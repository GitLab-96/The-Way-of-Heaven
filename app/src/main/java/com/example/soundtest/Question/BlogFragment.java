package com.example.soundtest.Question;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.soundtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {

    private Button link1Bttn,link2Bttn,link3Bttn,link4Bttn,link5Bttn,link6Bttn,link7Bttn,link8Bttn,link9Bttn;
    private Intent intent,chooser;

    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blog, container, false);

        link1Bttn    =  view.findViewById(R.id.link1Btn);
        link2Bttn    =  view.findViewById(R.id.link2Btn);
        link3Bttn    =  view.findViewById(R.id.link3Btn);
        link4Bttn    =  view.findViewById(R.id.link4Btn);
        link5Bttn    =  view.findViewById(R.id.link5Btn);
        link6Bttn    =  view.findViewById(R.id.link6Btn);
        link7Bttn    =  view.findViewById(R.id.link7Btn);
        link8Bttn    =  view.findViewById(R.id.link8Btn);
        link9Bttn    =  view.findViewById(R.id.link9Btn);
        click();

  return view;
    }

    private void click() {

            link1Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://islamshikka.blogspot.com/p/blog-page_10.html"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link2Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://prootisruti.blogspot.com/2018/10/blog-post.html"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link3Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link4Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=quran+shikkha+bangla+tutorial+"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link5Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://islamshikka.blogspot.com/p/blog-page_10.html"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link6Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://prootisruti.blogspot.com/2018/10/blog-post.html"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link7Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });

            link8Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=quran+shikkha+bangla+tutorial+"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);

                }
            });
            link9Bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://quranwithbiggan.wordpress.com/2015/07/02/%E0%A6%B6%E0%A6%BF%E0%A6%B6%E0%A7%81-%E0%A6%93-%E0%A6%AC%E0%A7%9F%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%A6%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%81%E0%A6%B0%E0%A6%86%E0%A6%A8-%E0%A6%B6%E0%A6%BF%E0%A6%95/"));
                    chooser = Intent.createChooser(intent,"Youtube");
                    startActivity(chooser);
                }
            });
    }
}
