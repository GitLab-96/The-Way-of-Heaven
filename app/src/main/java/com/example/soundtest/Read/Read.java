package com.example.soundtest.Read;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.R;
import com.example.soundtest.Salah.BoysFragment;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView navigationView;



    private TextView displayTV,displayTV2;


    PDFView quranPdf;
    ScrollView scrollViewParaList;
    LinearLayout oneTV,twoTV,threeTV,fourTV,fiveTV,sixTV,sevenTV,eightTV,nineTV,tenTV,elevenTV,twoelveTV,thirtenTV,fourtenTV,fiftenTV,sixtenTV,seventenTV,
            eightenTV,nintenTV,twentyTV,twentyOneTV,twentyTwoTV,twentyThreeTV,twentyFourTV,twentyFiveTV,twentySixTV,twentySevenTV,twentyEightTV,twentyNineTV,thirty;


    ScrollView scrollViewList;
    LinearLayout fatehaTV,bakaraTV,imranTV,nisaTV,maidaTV,anamTV,arofTV,anfalTV,taobaTV,yunusTV,hudTV,yusufTV,rodTV,ibrahimTV,hijrTV,nahlTV,israilTV,
            kahafTV,maryamTV,tohaTV,ambiaTV,hajjTV,muminunTV,nurTV,furkonTV,shuaroTV,namlTV,kosasTV,ankabutTV,rumTV,loqmanTV,sajdahTV,ahjabTV,sabaTV,
            fatirTV,yasinTV,soffatTV,sowadTV,zhumarTV,muminTV,hamimsajdahTV,shuraTV,jhukhrufTV,dukhonTV,jasiahTV,ahkofTV,muhammadTV,fathTV,hujrotTV,kofTV,jariatTV,
            turTV,najmTV,komarTV,rohmanTV,wakiahTV,hadidTV,mujadalahTV,hashorTV,mumtahinahTV,soffTV,jumuahTV,munafiqunTV,tagobunTV,tolakTV,tahrimTV,mulkTV,kolamTV,
            hakkohTV,maarijTV,nuhTV,jinTV,mujjhammilTV,muddassirTV,qiyamahTV,dahrTV,mursalatTV,nabaTV,najiatTV,abasaTV,takbirTV,infitorTV,mutoffifinTV,inshikokTV,burujTV,
            torikTV,aalaTV,goshiahTV,fajriTV,baladTV,shamsTV,lailTV,duhaTV,alamnashrohTV,tinTV,alakTV,kodorTV,baiyenahTV,jiljalTV,adiatTV,kariahTV,takasurTV,
            asorTV,hmajahTV,filTV,kuraishTV,maunTV,kaosarTV,kafirunTV,nasrTV,lahabTV,ikhlasTV,falakTV,nasTV;


    boolean setOrientation = false;
    boolean setMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        ParaList();
        SuraList();

        displayTV = findViewById(R.id.displayTV);
        displayTV2 = findViewById(R.id.displayTV2);



        //Night Mode

        try {
            FileInputStream fileInputStream = openFileInput("nightMode.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line1;
            StringBuffer  stringBuffer= new StringBuffer();

            while ((line1 = bufferedReader.readLine()) !=null){
                stringBuffer.append(line1);
            }

            displayTV2.setText(stringBuffer.toString());
        }
        catch (FileNotFoundException e){

            e.printStackTrace();
        }
        catch (IOException e){

            e.printStackTrace();
        }

        String currentorientation = displayTV.getText().toString();
        String currentMode = displayTV2.getText().toString();

        if (currentorientation.equals("Horizontal ( Right to Left)"))
        {
            setOrientation = true;
        }
        if (currentMode.equals("Enabled")){

            setMode = true;
        }






        quranPdf.fromAsset("hifjquran.pdf")
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .pageFling(true)
                .pageSnap(true)
                .autoSpacing(true)
                .nightMode(setMode)
                .fitEachPage(true)
                .scrollHandle(new DefaultScrollHandle(this,true))
                .spacing(2).load();










        navigationView.setOnNavigationItemSelectedListener(naviCustomListView);
    }

    private void SuraList() {

        fatehaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(1)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        bakaraTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);


                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(2)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(setOrientation)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        imranTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(50)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        nisaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);


                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(77)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        maidaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(106)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        anamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(128)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        arofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(151)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        anfalTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(177)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        taobaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);

                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(187)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        yunusTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(208)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        hudTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(221)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        yusufTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(235)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        rodTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(249)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        ibrahimTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(255)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        hijrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(261)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        nahlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(267)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        israilTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(282)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });



        kahafTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(293)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        maryamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(305)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        tohaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(312)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        ambiaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(322)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hajjTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(331)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        muminunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(342)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        nurTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(350)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        furkonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(359)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        shuaroTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(365)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        namlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(376)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        kosasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(385)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        ankabutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(396)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        rumTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(404)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        loqmanTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(411)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        sajdahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(415)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        ahjabTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(418)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        sabaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(428)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        fatirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(434)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        yasinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(440)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        soffatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(445)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        sowadTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(452)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        zhumarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(458)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        muminTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(467)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hamimsajdahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(477)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });


        shuraTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(483)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        jhukhrufTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(489)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        dukhonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(495)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });


        jasiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(498)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        ahkofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(502)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        muhammadTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(506)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        fathTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(511)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hujrotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(515)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        kofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(518)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        jariatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(520)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        turTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(523)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        najmTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(526)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        komarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(528)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        rohmanTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(531)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        wakiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(535)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hadidTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(537)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        mujadalahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(542)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hashorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(545)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        mumtahinahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(549)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        soffTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(551)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        jumuahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(553)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        munafiqunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(554)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        tagobunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(556)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        tolakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(558)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        tahrimTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(560)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        mulkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(562)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        kolamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(564)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hakkohTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(567)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        maarijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(569)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        nuhTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(572)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        jinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(573)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        mujjhammilTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(576)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        muddassirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(578)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        qiyamahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(580)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        dahrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(582)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();;
            }
        });
        mursalatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(585)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        nabaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(586)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        najiatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(587)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        abasaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(589)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        takbirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(590)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        infitorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(591)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        mutoffifinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(592)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });



        inshikokTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(594)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        burujTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(595)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        torikTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(596)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        aalaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(597)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        goshiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(597)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        fajriTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(598)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        baladTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(600)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        shamsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(600)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        lailTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(601)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });


        alamnashrohTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(602)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        duhaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(602)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        tinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(603)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        alakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(603)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        kodorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(604)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        baiyenahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(604)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        jiljalTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(605)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        adiatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(605)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        kariahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(606)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        takasurTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(606)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        asorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(607)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        hmajahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(607)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        filTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(607)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        kuraishTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(608)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        maunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(608)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

        kaosarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(608)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        kafirunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(608)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });




        nasrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(609)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        lahabTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(609)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        ikhlasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(609)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        falakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(610)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        nasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(610)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });

    }

    private void ParaList() {


        oneTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(1)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();


            }
        });

        twoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(22)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        threeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(42)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        fourTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(62)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        fiveTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(82)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        sixTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(102)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        sevenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(122)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        eightTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(142)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        nineTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(162)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        tenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(182)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        elevenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(202)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        twoelveTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(222)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        thirtenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(242)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        fourtenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(262)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        fiftenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(282)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        sixtenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(302)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        seventenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(322)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });



        eightenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(342)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        nintenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(362)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(382)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyOneTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(402)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();
            }
        });
        twentyTwoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(422)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyThreeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(442)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyFourTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(462)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyFiveTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(482)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentySixTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(502)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentySevenTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(522)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyEightTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(542)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });
        twentyNineTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(562)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

        thirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewParaList.setVisibility(View.GONE);
                quranPdf.setVisibility(View.VISIBLE);
                quranPdf.fromAsset("hifjquran.pdf")
                        .defaultPage(586)
                        .enableAnnotationRendering(true)
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .pageFling(true)
                        .pageSnap(true)
                        .autoSpacing(true)
                        .nightMode(setMode)
                        .scrollHandle(new DefaultScrollHandle(Read.this,true))
                        .spacing(2).load();

            }
        });

    }


    private BottomNavigationView.OnNavigationItemSelectedListener naviCustomListView = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){

                case R.id.open_quran_Item:

                    getSupportActionBar().setTitle("      Quran");
                    quranPdf.setVisibility(View.VISIBLE);
                    scrollViewList.setVisibility(View.GONE);
                    scrollViewParaList.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.GONE);

                    break;

                case R.id.sura_Item:
                    getSupportActionBar().setTitle("      Sura List");
                    scrollViewParaList.setVisibility(View.GONE);
                    scrollViewList.setVisibility(View.VISIBLE);
                    quranPdf.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.GONE);

                    break;

                case R.id.para_Item:

                    getSupportActionBar().setTitle("      Para List");
                    frameLayout.setVisibility(View.GONE);
                    scrollViewList.setVisibility(View.GONE);
                    quranPdf.setVisibility(View.GONE);
                    scrollViewParaList.setVisibility(View.VISIBLE);
                    break;
                case R.id.bookmarks_Item:
                    getSupportActionBar().setTitle("      Please write arabic language");
                    scrollViewParaList.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.VISIBLE);
                    scrollViewList.setVisibility(View.GONE);
                    quranPdf.setVisibility(View.GONE);
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                   ft4.replace(R.id.framLayout,new BookMarks());
                    ft4.commit();
                    break;

            }

            return true;
        }
    };

    private void init() {
        quranPdf = findViewById(R.id.readQuranPDF);
        navigationView = findViewById(R.id.bottom_navigationread);
        frameLayout=findViewById(R.id.framLayout);

        //Sura List
        scrollViewList = findViewById(R.id.listScrolView);
        fatehaTV = findViewById(R.id.suraFateha);
        bakaraTV = findViewById(R.id.suraBakara);
        imranTV = findViewById(R.id.suraImran);
        nisaTV = findViewById(R.id.suraNisa);
        maidaTV = findViewById(R.id.suraMayeda);
        anamTV = findViewById(R.id.suraAnam);
        arofTV = findViewById(R.id.suraArof);
        anfalTV = findViewById(R.id.suraAnfal);
        taobaTV = findViewById(R.id.suraTaoba);
        yunusTV = findViewById(R.id.suraUnus);
        hudTV = findViewById(R.id.suraHud);
        yusufTV = findViewById(R.id.suraUsuf);
        rodTV = findViewById(R.id.suraRod);
        ibrahimTV = findViewById(R.id.suraIbrahim);
        hijrTV = findViewById(R.id.suraHijr);
        nahlTV = findViewById(R.id.suraNahl);
        israilTV = findViewById(R.id.suraIsrail);
        kahafTV = findViewById(R.id.surakahaf);
        maryamTV = findViewById(R.id.suramariam);
        tohaTV = findViewById(R.id.suratoha);
        ambiaTV = findViewById(R.id.suraambia);
        hajjTV = findViewById(R.id.surahajj);
        muminunTV = findViewById(R.id.suramuminun);
        nurTV = findViewById(R.id.suranur);
        furkonTV = findViewById(R.id.surafurkon);
        shuaroTV = findViewById(R.id.surashuaro);
        namlTV = findViewById(R.id.suranaml);
        kosasTV = findViewById(R.id.surakosas);
        ankabutTV = findViewById(R.id.suraankabut);
        rumTV = findViewById(R.id.surarum);
        loqmanTV = findViewById(R.id.suralukman);
        sajdahTV = findViewById(R.id.surasajdah);
        ahjabTV = findViewById(R.id.suraahjab);
        sabaTV = findViewById(R.id.surasaba);
        fatirTV = findViewById(R.id.surafatir);
        yasinTV = findViewById(R.id.surayasin);
        soffatTV = findViewById(R.id.surasoffat);
        sowadTV = findViewById(R.id.surasowad);
        zhumarTV = findViewById(R.id.surajhumar);
        muminTV = findViewById(R.id.suramumin);
        hamimsajdahTV = findViewById(R.id.surahamimsajdah);
        jhukhrufTV = findViewById(R.id.surajukhruf);
        shuraTV = findViewById(R.id.surashura);
        dukhonTV = findViewById(R.id.suradukhon);
        jasiahTV = findViewById(R.id.surajasiah);
        ahkofTV = findViewById(R.id.suraahkof);
        muhammadTV = findViewById(R.id.suramuhammad);
        fathTV = findViewById(R.id.surafath);
        hujrotTV = findViewById(R.id.surahujrot);
        kofTV = findViewById(R.id.surakoff);
        jariatTV = findViewById(R.id.surajariat);
        turTV = findViewById(R.id.suratur);
        najmTV = findViewById(R.id.suranajm);
        komarTV = findViewById(R.id.surakomar);
        rohmanTV = findViewById(R.id.surarohman);
        wakiahTV = findViewById(R.id.surawakiyah);
        hadidTV = findViewById(R.id.surahadid);
        mujadalahTV = findViewById(R.id.suramujadalah);
        hashorTV = findViewById(R.id.surahashr);
        mumtahinahTV = findViewById(R.id.suramumtahinah);
        soffTV = findViewById(R.id.surasoff);
        jumuahTV = findViewById(R.id.surajumuah);
        munafiqunTV = findViewById(R.id.suramunafikun);
        tagobunTV = findViewById(R.id.suratagobun);
        tolakTV = findViewById(R.id.suratolam);
        tahrimTV = findViewById(R.id.suratahrim);
        mulkTV = findViewById(R.id.suramulk);
        kolamTV =findViewById(R.id.surakolam);
        hakkohTV = findViewById(R.id.surahakkoh);
        maarijTV =findViewById(R.id.suramarij);
        nuhTV = findViewById(R.id.suranuh);
        jinTV = findViewById(R.id.surajin);
        mujjhammilTV = findViewById(R.id.suramujjhammil);
        muddassirTV = findViewById(R.id.suramuddhassir);
        qiyamahTV = findViewById(R.id.surakiamah);
        dahrTV = findViewById(R.id.suradahor);
        mursalatTV = findViewById(R.id.suramursalat);
        nabaTV = findViewById(R.id.suranaba);
        najiatTV = findViewById(R.id.suranajiat);
        abasaTV = findViewById(R.id.suraabasa);
        takbirTV = findViewById(R.id.suratakbir);
        infitorTV =findViewById(R.id.surainfitor);
        mutoffifinTV = findViewById(R.id.suramutoffifin);
        inshikokTV = findViewById(R.id.surainshikok);
        burujTV = findViewById(R.id.suraburuj);
        torikTV = findViewById(R.id.suratorik);
        aalaTV = findViewById(R.id.suraala);
        goshiahTV = findViewById(R.id.suragoshiat);
        fajriTV = findViewById(R.id.surafajri);
        baladTV = findViewById(R.id.surabalad);
        shamsTV = findViewById(R.id.surashams);
        lailTV = findViewById(R.id.suralaili);
        duhaTV = findViewById(R.id.suraduha);
        alamnashrohTV = findViewById(R.id.suraalamnashroh);
        tinTV = findViewById(R.id.suratin);
        alakTV = findViewById(R.id.suraalak);
        kodorTV = findViewById(R.id.surakodr);
        baiyenahTV = findViewById(R.id.surabaiyenah);
        jiljalTV = findViewById(R.id.surajiljalah);
        adiatTV = findViewById(R.id.suraadiat);
        kariahTV =findViewById(R.id.surakoriah);
        takasurTV = findViewById(R.id.suratakasur);
        asorTV = findViewById(R.id.suraasor);
        hmajahTV = findViewById(R.id.surahumajah);
        filTV = findViewById(R.id.surafil);
        kuraishTV = findViewById(R.id.surakuraish);
        maunTV = findViewById(R.id.suramaun);
        kaosarTV = findViewById(R.id.surakausr);
        kafirunTV = findViewById(R.id.surakafirun);
        nasrTV = findViewById(R.id.suranasr);
        lahabTV = findViewById(R.id.suralahab);
        ikhlasTV = findViewById(R.id.suraikhlas);
        falakTV = findViewById(R.id.surafalak);
        nasTV = findViewById(R.id.suranas);


        //ParaList
        scrollViewParaList = findViewById(R.id.listParaScrolView);
        oneTV = findViewById(R.id.paraOne);
        twoTV = findViewById(R.id.paraTwo);
        threeTV = findViewById(R.id.paraThree);
        fourTV = findViewById(R.id.paraFour);
        fiveTV = findViewById(R.id.paraFive);
        sixTV = findViewById(R.id.paraSix);
        sevenTV = findViewById(R.id.paraSeven);
        eightTV = findViewById(R.id.paraEight);
        nineTV = findViewById(R.id.paraNine);
        tenTV = findViewById(R.id.paraTen);
        elevenTV = findViewById(R.id.paraEleven);
        twoelveTV = findViewById(R.id.paraTwelve);
        thirtenTV = findViewById(R.id.paraThirten);
        fourtenTV = findViewById(R.id.paraFourten);
        fiftenTV = findViewById(R.id.paraFiften);
        sixtenTV = findViewById(R.id.paraSixten);
        seventenTV = findViewById(R.id.paraSeventen);
        eightenTV = findViewById(R.id.paraEighten);
        nintenTV = findViewById(R.id.paraNinten);
        twentyTV = findViewById(R.id.paraTwenty);
        twentyOneTV = findViewById(R.id.paraTwentyOne);
        twentyTwoTV = findViewById(R.id.paraTwentyTwo);
        twentyThreeTV = findViewById(R.id.paraTwentyThree);
        twentyFourTV = findViewById(R.id.paraTwentyFour);
        twentyFiveTV = findViewById(R.id.paraTwentyFive);
        twentySixTV = findViewById(R.id.paraTwentySix);
        twentySevenTV = findViewById(R.id.paraTwentySeven);
        twentyEightTV = findViewById(R.id.paraTwentyEight);
        twentyNineTV = findViewById(R.id.paraTwentyNine);
        thirty = findViewById(R.id.parathirty);

    }




}
