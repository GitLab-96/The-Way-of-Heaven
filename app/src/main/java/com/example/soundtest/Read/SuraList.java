package com.example.soundtest.Read;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.soundtest.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuraList extends Fragment  {



    ScrollView scrollViewList;
    PDFView pdfViewList;
    TextView fatehaTV,bakaraTV,imranTV,nisaTV,maidaTV,anamTV,arofTV,anfalTV,taobaTV,yunusTV,hudTV,yusufTV,rodTV,ibrahimTV,hijrTV,nahlTV,israilTV,
            kahafTV,maryamTV,tohaTV,ambiaTV,hajjTV,muminunTV,nurTV,furkonTV,shuaroTV,namlTV,kosasTV,ankabutTV,rumTV,loqmanTV,sajdahTV,ahjabTV,sabaTV,
            fatirTV,yasinTV,soffatTV,sowadTV,zhumarTV,muminTV,hamimsajdahTV,shuraTV,jhukhrufTV,dukhonTV,jasiahTV,ahkofTV,muhammadTV,fathTV,hujrotTV,kofTV,jariatTV,
            turTV,najmTV,komarTV,rohmanTV,wakiahTV,hadidTV,mujadalahTV,hashorTV,mumtahinahTV,soffTV,jumuahTV,munafiqunTV,tagobunTV,tolakTV,tahrimTV,mulkTV,kolamTV,
            hakkohTV,maarijTV,nuhTV,jinTV,mujjhammilTV,muddassirTV,qiyamahTV,dahrTV,mursalatTV,nabaTV,najiatTV,abasaTV,takbirTV,infitorTV,mutoffifinTV,inshikokTV,burujTV,
            torikTV,aalaTV,goshiahTV,fajriTV,baladTV,shamsTV,lailTV,duhaTV,alamnashrohTV,tinTV,alakTV,kodorTV,baiyenahTV,jiljalTV,adiatTV,kariahTV,takasurTV,
            asorTV,hmajahTV,filTV,kuraishTV,maunTV,kaosarTV,kafirunTV,nasrTV,lahabTV,ikhlasTV,falakTV,nasTV;

    public SuraList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sura_list, container, false);

        scrollViewList = view.findViewById(R.id.listScrolView);
        pdfViewList = view.findViewById(R.id.listQuranPDF);
        fatehaTV = view.findViewById(R.id.suraFateha);
        bakaraTV = view.findViewById(R.id.suraBakara);
        imranTV = view.findViewById(R.id.suraImran);
        nisaTV = view.findViewById(R.id.suraNisa);
        maidaTV = view.findViewById(R.id.suraMayeda);
        anamTV = view.findViewById(R.id.suraAnam);
        arofTV = view.findViewById(R.id.suraArof);
        anfalTV = view.findViewById(R.id.suraAnfal);
        taobaTV = view.findViewById(R.id.suraTaoba);
        yunusTV = view.findViewById(R.id.suraUnus);
        hudTV = view.findViewById(R.id.suraHud);
        yusufTV = view.findViewById(R.id.suraUsuf);
        rodTV = view.findViewById(R.id.suraRod);
        ibrahimTV = view.findViewById(R.id.suraIbrahim);
        hijrTV = view.findViewById(R.id.suraHijr);
        nahlTV = view.findViewById(R.id.suraNahl);
        israilTV = view.findViewById(R.id.suraIsrail);
        kahafTV = view.findViewById(R.id.surakahaf);
        maryamTV = view.findViewById(R.id.suramariam);
        tohaTV = view.findViewById(R.id.suratoha);
        ambiaTV = view.findViewById(R.id.suraambia);
        hajjTV = view.findViewById(R.id.surahajj);
        muminunTV = view.findViewById(R.id.suramuminun);
        nurTV = view.findViewById(R.id.suranur);
        furkonTV = view.findViewById(R.id.surafurkon);
        shuaroTV = view.findViewById(R.id.surashuaro);
        namlTV = view.findViewById(R.id.suranaml);
        kosasTV = view.findViewById(R.id.surakosas);
        ankabutTV = view.findViewById(R.id.suraankabut);
        rumTV = view.findViewById(R.id.surarum);
        loqmanTV = view.findViewById(R.id.suralukman);
        sajdahTV = view.findViewById(R.id.surasajdah);
        ahjabTV = view.findViewById(R.id.suraahjab);
        sabaTV = view.findViewById(R.id.surasaba);
        fatirTV = view.findViewById(R.id.surafatir);
        yasinTV = view.findViewById(R.id.surayasin);
        soffatTV = view.findViewById(R.id.surasoffat);
        sowadTV = view.findViewById(R.id.surasowad);
        zhumarTV = view.findViewById(R.id.surajhumar);
        muminTV = view.findViewById(R.id.suramumin);
        hamimsajdahTV = view.findViewById(R.id.surahamimsajdah);
        jhukhrufTV = view.findViewById(R.id.surajukhruf);
        shuraTV = view.findViewById(R.id.surashura);
        dukhonTV = view.findViewById(R.id.suradukhon);
        jasiahTV = view.findViewById(R.id.surajasiah);
        ahkofTV = view.findViewById(R.id.suraahkof);
        muhammadTV = view.findViewById(R.id.suramuhammad);
        fathTV = view.findViewById(R.id.surafath);
        hujrotTV = view.findViewById(R.id.surahujrot);
        kofTV = view.findViewById(R.id.surakoff);
        jariatTV = view.findViewById(R.id.surajariat);
        turTV = view.findViewById(R.id.suratur);
        najmTV = view.findViewById(R.id.suranajm);
        komarTV = view.findViewById(R.id.surakomar);
        rohmanTV = view.findViewById(R.id.surarohman);
        wakiahTV = view.findViewById(R.id.surawakiyah);
        hadidTV = view.findViewById(R.id.surahadid);
        mujadalahTV = view.findViewById(R.id.suramujadalah);
        hashorTV = view.findViewById(R.id.surahashr);
        mumtahinahTV = view.findViewById(R.id.suramumtahinah);
        soffTV = view.findViewById(R.id.surasoff);
        jumuahTV = view.findViewById(R.id.surajumuah);
        munafiqunTV = view.findViewById(R.id.suramunafikun);
        tagobunTV = view.findViewById(R.id.suratagobun);
        tolakTV = view.findViewById(R.id.suratolam);
        tahrimTV = view.findViewById(R.id.suratahrim);
        mulkTV = view.findViewById(R.id.suramulk);
        kolamTV = view.findViewById(R.id.surakolam);
        hakkohTV = view.findViewById(R.id.surahakkoh);
        maarijTV = view.findViewById(R.id.suramarij);
        nuhTV = view.findViewById(R.id.suranuh);
        jinTV = view.findViewById(R.id.surajin);
        mujjhammilTV = view.findViewById(R.id.suramujjhammil);
        muddassirTV = view.findViewById(R.id.suramuddhassir);
        qiyamahTV = view.findViewById(R.id.surakiamah);
        dahrTV = view.findViewById(R.id.suradahor);
        mursalatTV = view.findViewById(R.id.suramursalat);
        nabaTV = view.findViewById(R.id.suranaba);
        najiatTV = view.findViewById(R.id.suranajiat);
        abasaTV = view.findViewById(R.id.suraabasa);
        takbirTV = view.findViewById(R.id.suratakbir);
        infitorTV = view.findViewById(R.id.surainfitor);
        mutoffifinTV = view.findViewById(R.id.suramutoffifin);
        inshikokTV = view.findViewById(R.id.surainshikok);
        burujTV = view.findViewById(R.id.suraburuj);
        torikTV = view.findViewById(R.id.suratorik);
        aalaTV = view.findViewById(R.id.suraala);
        goshiahTV = view.findViewById(R.id.suragoshiat);
        fajriTV = view.findViewById(R.id.surafajri);
        baladTV = view.findViewById(R.id.surabalad);
        shamsTV = view.findViewById(R.id.surashams);
        lailTV = view.findViewById(R.id.suralaili);
        duhaTV = view.findViewById(R.id.suraduha);
        alamnashrohTV = view.findViewById(R.id.suraalamnashroh);
        tinTV = view.findViewById(R.id.suratin);
        alakTV = view.findViewById(R.id.suraalak);
        kodorTV = view.findViewById(R.id.surakodr);
        baiyenahTV = view.findViewById(R.id.surabaiyenah);
        jiljalTV = view.findViewById(R.id.surajiljalah);
        adiatTV = view.findViewById(R.id.suraadiat);
        kariahTV = view.findViewById(R.id.surakoriah);
        takasurTV = view.findViewById(R.id.suratakasur);
        asorTV = view.findViewById(R.id.suraasor);
        hmajahTV = view.findViewById(R.id.surahumajah);
        filTV = view.findViewById(R.id.surafil);
        kuraishTV = view.findViewById(R.id.surakuraish);
        maunTV = view.findViewById(R.id.suramaun);
        kaosarTV = view.findViewById(R.id.surakausr);
        kafirunTV = view.findViewById(R.id.surakafirun);
        nasrTV = view.findViewById(R.id.suranasr);
        lahabTV = view.findViewById(R.id.suralahab);
        ikhlasTV = view.findViewById(R.id.suraikhlas);
        falakTV = view.findViewById(R.id.surafalak);
        nasTV = view.findViewById(R.id.suranas);




        fatehaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(1)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        bakaraTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(2)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        imranTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(50)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        nisaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(77)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        maidaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(106)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        anamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(128)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        arofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(151)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        anfalTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(177)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        taobaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(187)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        yunusTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(208)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hudTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(221)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        yusufTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(235)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        rodTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(249)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        ibrahimTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(255)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        hijrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(261)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        nahlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(267)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        israilTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(282)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });



        kahafTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(293)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        maryamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(305)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        tohaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(312)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        ambiaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(322)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hajjTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(331)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        muminunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(342)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        nurTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(350)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        furkonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(359)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        shuaroTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(365)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        namlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(376)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        kosasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(385)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        ankabutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(396)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        rumTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(404)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        loqmanTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(411)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        sajdahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(415)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        ahjabTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(418)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        sabaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(428)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        fatirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(434)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        yasinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(440)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        soffatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(445)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        sowadTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(452)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        zhumarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(458)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        muminTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(467)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hamimsajdahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(477)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });


        shuraTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(483)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        jhukhrufTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(489)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        dukhonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(495)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });


        jasiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(498)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        ahkofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(502)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        muhammadTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(506)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        fathTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(511)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hujrotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(515)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        kofTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(518)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        jariatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(520)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        turTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(523)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        najmTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(526)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        komarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(528)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        rohmanTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(531)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        wakiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(535)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hadidTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(537)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mujadalahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(542)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hashorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(545)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mumtahinahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(549)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        soffTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(551)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        jumuahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(553)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        munafiqunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(554)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        tagobunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(556)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        tolakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(558)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        tahrimTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(560)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mulkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(562)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        kolamTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(564)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hakkohTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(567)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        maarijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(569)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        nuhTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(572)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        jinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(573)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mujjhammilTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(576)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        muddassirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(578)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        qiyamahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(580)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        dahrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(582)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mursalatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(585)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        nabaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(586)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        najiatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(587)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        abasaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(589)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        takbirTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(590)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        infitorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(591)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        mutoffifinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(592)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });



        inshikokTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(594)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        burujTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(595)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        torikTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(596)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        aalaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(597)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        goshiahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(597)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        fajriTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(598)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        baladTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(600)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        shamsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(600)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        lailTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(601)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });


        alamnashrohTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(602)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        duhaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(602)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        tinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(603)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        alakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(603)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        kodorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(604)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        baiyenahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(604)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        jiljalTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(605)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        adiatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(605)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        kariahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(606)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        takasurTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(606)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        asorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(607)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        hmajahTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(607)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        filTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(607)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        kuraishTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(608)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        maunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(608)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        kaosarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(608)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        kafirunTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(608)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });




        nasrTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(609)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });lahabTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(609)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        ikhlasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(609)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });

        falakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(610)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });
        nasTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollViewList.setVisibility(View.GONE);
                pdfViewList.setVisibility(View.VISIBLE);
                pdfViewList.fromAsset("hifjquran.pdf").defaultPage(610)
                        .enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(getContext()))
                        .spacing(2).load();
            }
        });



   return view;
    }

}
