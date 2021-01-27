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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurahLearn extends Fragment {
    private TextSwitcher suraImageSwitcher,orthoImageSwitcher;
    private TextSwitcher textSwitcherFatehaTYPING    ;
    private ImageButton suraPrevious,suraNext,suraReplay,suraMic,suracomapre;
    private TextView userVoiceTV,suraName;
    private  static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    MediaPlayer fatehamedia,feelmedia,quraishmedia,maunmedia,kaosarmedia,kafirunmedia,nasrmedia,lahabmedia,ikhlasmedia,falakmedia,nasmedia,goodToast,badToast;
    private int currentayat=0;




    ListView suraLearnlistView;
    List<String> suraList;

    LinearLayout learnLayout;





    String[] fateha = {

            "اَلٛحَمٛدُلِلّٰهِ رَبِّ الٛعٰلَمِيٛنَ۞",
            "الرَّحٛمٰنِ الرَّحِيٛمِ۞",
            "مَالِكِ يَوٛمِ الدِّينَ۞",
            "اِيَّاكَ نَعٛبُدُ و اِيَّاكَ نَسٛتَعِيٛنُ۞",
            "اِهٛدِنَاالصِّرَاط الٛمُسٛتَقِمَ۞",
            "صِرَاط الَّذِيٛنَ اَنٛعَمٛتَ عَلَيٛهِمٛ۞",
            "غَيٛرِالٛمَغٛضُوٛبِ عَلَيٛهِمٛ۞",
            "وَلَاالضَّاٙالِّيٛنَ۞",
            "اٰمِيٛنَ۞",


    };
    String[]  feel = {
            "اَلَمٛ تَرَكَيفَ فَعَلَ رَبُّكَ بِاَصٛحٰبِ الٛفِيٛلِ۞",
            "اَلَمٛ يَجٛعَلٛ كَيٛدَهُمٛ فِيٛ تَضٛلِيٛلِ۞",
            "وَاَرٛسَلَ عَلَيٛهِمٛ طَيٛرًا اَبَابِيٛل۞",
            "تَرٛمِيٛهِمٛ بِحِجَارَةٍ مِنٛ سِجِّيٛلٍ۞",
            "فَجَعَلَهُمٛ كَعَصٛفٍ مَّأكُوٛلٍ۞",
    };

    String[]  quraish = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  maun = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  kaosar = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  kafirun = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  nasr = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  lahab = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  ikhlas = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  falak = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };
    String[]  nas = {
            "لِٳِيٛلٰفِ قُرَيٛشٍ۞",
            "ٳِيٛلٰفِهِمٛ رِحٛلَتَ الشِّتاٙئِ وَالصَّيٛفِ۞",
            "فَلٛيَعٛبُدُوٛ رَبَّ هٰذَالٛبَيٛتِ۞",
            "اَلَّذِيٛ اَطٛعَمَهُمٛ مِنٛ جُوٛعٍ۞",
            "وَٲٰمَنَهُمٛ مِنٛ جُوٛعٍ۞",
    };



    String[] fatehaortho = {

            "যাবতীয় প্রশংসা আল্লাহ তা’আলার যিনি সকল সৃষ্টি জগতের পালনকর্তা।",
            "যিনি নিতান্ত মেহেরবান ও দয়ালু।",
            "যিনি বিচার দিনের মালিক",
            "আমরা একমাত্র তোমারই ইবাদত করি এবং শুধুমাত্র তোমারই সাহায্য প্রার্থনা করি।",
            "আমাদেরকে সরল পথ দেখাও,",
            "সে সমস্ত লোকের পথ, যাদেরকে তুমি নেয়ামত দান করেছ। ",
            "তাদের পথ নয়, যাদের প্রতি তোমার গজব নাযিল হয়েছে ",
            "এবং যারা পথভ্রষ্ট হয়েছে।",


    };
    String[] feelaortho = {
            "আপনি কি দেখেননি আপনার পালনকর্তা হস্তীবাহিনীর সাথে কিরূপ ব্যবহার করেছেন?",
            "তিনি কি তাদের চক্রান্ত নস্যাৎ করে দেননি?",
            "তিনি তাদের উপর প্রেরণ করেছেন ঝাঁকে ঝাঁকে পাখী,",
            "যারা তাদের উপর পাথরের কংকর নিক্ষেপ করছিল।",
            "অতঃপর তিনি তাদেরকে ভক্ষিত তৃণসদৃশ করে দেন।",

    };
    String[] quraishortho = {
            "কুরায়েশদের আসক্তির কারণে",
            "আসক্তির কারণে তাদের শীত ও গ্রীষ্মকালীন সফরের",
            "অতএব তারা যেন ইবাদত করে এই গৃহের মালিকের",
            "যিনি তাদেরকে ক্ষুধায় অন্ন দান করেছেন",
            "এবং ভীতি হ’তে নিরাপদ করেছেন",

    };
    String[] maunortho = {
            "আপনি কি দেখেছেন তাকে, যে বিচার দিবসকে মিথ্যা বলে?",
            "সে হ’ল ঐ ব্যক্তি, যে ইয়াতীমকে গলা ধাক্কা দেয়",
            "এবং মিসকীনকে খাদ্য দানে উৎসাহিত করে না",
            "অতঃপর দুর্ভোগ ঐ সব মুছল্লীর জন্য",
            "যারা তাদের ছালাত থেকে উদাসীন",
            "যারা লোকদেরকে দেখায়",
            "এবং নিত্য ব্যবহার্য বস্ত্ত দানে বিরত থাকে।",

    };
    String[] kaosarortho = {
            "নিশ্চয়ই আমরা আপনাকে ‘কাওছার’ দান করেছি",
            "অতএব আপনার প্রভুর উদ্দেশ্যে ছালাত আদায় করুন ও কুরবানী করুন",
            "নিশ্চয়ই আপনার শত্রুই নির্বংশ।",


    };
    String[] kafirunortho = {
            "আপনি বলুন! হে কাফেরবৃন্দ!",
            "আমি ইবাদত করি না তোমরা যাদের ইবাদত কর",
            "এবং তোমরা ইবাদতকারী নও আমি যার ইবাদত করি",
            "আমি ইবাদতকারী নই তোমরা যার ইবাদত কর",
            "এবং তোমরা ইবাদতকারী নও আমি যার ইবাদত করি",
            "তোমাদের জন্য তোমাদের দ্বীন এবং আমার জন্য আমার দ্বীন",

    };
    String[] nasrortho = {
            "যখন আসবে আল্লাহর সাহায্য ও বিজয় ",
            "এবং আপনি মানুষকে দলে দলে আল্লাহর দ্বীনে প্রবেশ করতে দেখবেন ",
            "তখন আপনি আপনার পালনকর্তার পবিত্রতা বর্ণনা করুন এবং তাঁর কাছে ক্ষমা প্রার্থনা করুন ",
            "নিশ্চয় তিনি ক্ষমাকারী |",
    };
    String[] lahabortho = {
            "ধ্বংস হোক আবু লহবের উভয় হাত, আর সে-ও ধ্বংস হোক!",
            "তার ধন-সম্পদ ও যা সে অর্জন করেছে তা তার কোনো কাজে আসবে না।",
            "তাকে অচিরেই ঠেলে দেওয়া হবে লেলিহান আগুনে",
            "এবং তার স্ত্রীকেও; যে ইন্ধন বহনকারিণী।",
            "তার গলায় থাকবে কড়াপাকের খেজুরের আঁশের রশি।",
    };
    String[] ikhlasortho = {
            "বলুন, তিনি আল্লাহ, এক,",
            "আল্লাহ অমুখাপেক্ষী,",
            "তিনি কাউকে জন্ম দেননি এবং কেউ তাকে জন্ম দেয়নি",
            "এবং তার সমতুল্য কেউ নেই।",

    };
    String[] falakortho = {
            "বলুন, আমি আশ্রয় গ্রহণ করছি প্রভাতের পালনকর্তার,",
            "তিনি যা সৃষ্টি করেছেন, তার অনিষ্ট থেকে",
            "অন্ধকার রাত্রির অনিষ্ট থেকে, যখন তা সমাগত হয়",
            "গ্রন্থিতে ফুঁৎকার দিয়ে জাদুকারিণীদের অনিষ্ট থেকে",
            "এবং হিংসুকের অনিষ্ট থেকে যখন সে হিংসা করে।",

    };
    String[] nasortho = {
            "বলুন, আমি আশ্রয় গ্রহণ করিতেছি মানুষের পালনকর্তার,",
            "মানুষের অধিপতির ।",
            "মানুষের মা’বুদের ।",
            "তার অনিষ্ট থেকে, যে কুমন্ত্রণা দেয় ও আত্নগোপন করে,",
            "যে কুমন্ত্রণা দেয় মানুষের অন্তরে ।",
            "জ্বিনের মধ্য থেকে অথবা মানুষের মধ্য থেকে ।",

    };

    int [] fatehamp3={R.raw.bismillahir,R.raw.alhamdulillah,R.raw.arrahmanir,R.raw.malikieao,R.raw.eiyakabudu,R.raw.ehdinassiratal,R.raw.siratallajina,
            R.raw.gairilmagduni,R.raw.oladdallin};

    int [] feelamp3={R.raw.bismillahir,R.raw.alamtaroksifa,R.raw.alamyajalkaidahum,R.raw.waarsalaalihimtoiran,R.raw.tarmihimbihijarotim,R.raw.fajaalahumkaasfimmm,};

    int [] quraishamp3={R.raw.bismillahir,R.raw.quraish01,R.raw.quraish02,R.raw.quraish03,R.raw.quraish04,R.raw.quraish04,};

    int [] maunmp3={R.raw.bismillahir,R.raw.maun01,R.raw.maun02,R.raw.maun03,R.raw.maun04,R.raw.maun05,R.raw.maun06,R.raw.maun07,};

    int [] kaosarmp3={R.raw.bismillahir,R.raw.kaosar01,R.raw.kaosar02,R.raw.kaosar03,};

    int [] kafirunmp3={R.raw.bismillahir,R.raw.kafirun01,R.raw.kafirun02,R.raw.kafirun03,R.raw.kafirun04,R.raw.kafirun05,R.raw.kafirun06,};

    int [] nasrmp3={R.raw.bismillahir,R.raw.nasr01,R.raw.nasr02,R.raw.nasr03,R.raw.nasr04,};

    int [] lahabmp3={R.raw.bismillahir,R.raw.lahab01,R.raw.lahab02,R.raw.lahab03,R.raw.lahab04,R.raw.lahab05,};

    int [] ikhlasmp3={R.raw.bismillahir,R.raw.ikhlas01,R.raw.ikhlas02,R.raw.ikhlas03,R.raw.ikhlas04,};

    int [] falakmp3={R.raw.bismillahir,R.raw.falah01,R.raw.falah02,R.raw.falah03,R.raw.falah04,R.raw.falah05,};

    int [] nasmp3={R.raw.bismillahir,R.raw.nas01,R.raw.nas02,R.raw.nas03,R.raw.nas04,R.raw.nas05,R.raw.nas06,};


    String[] fatehapronunciation = {
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
            "الم تر كيف فعل ربك باصاب الفيل",
            "الم يجعل كيدهم في تضليل",
            "وارسل عليهم طيرا ابابيل",
            "ترميهم بحجارة من سجيل",
            "فجعلهم كعصف ماكول",
    };
    String[] quraishpronunciation = {
            "لايلاف  قريش",
            "ايلافهم رحله الشتاء والصيف",
            "فليعبدوا رب هذا البيت",
            "الذي اطعمهم من جوع",
            "وامنهم من خوف",
    };
    String[] maunpronunciation = {
            "ارايت الذي يكذب باالدين",
            "فذالك الذي يدع اليتيم",
            "ولا يحض علي طعام المسكين",
            "فويل  للمصلين",
            "الذين هم عن صلاتهم ساهون ",
            "الذين هم يراءون",
            "ويمنعون الماعون",
    };
    String[] kaosarpronunciation = {
            "انا اعطيناك الكوثر",
            "فصل لربك وانحر",
            "ان شانئك هو الابتر",

    };
    String[] kafirunpronunciation = {
            "قل ياايها اللكافرون",
            "لا اعبد ماتعبدون",
            "ولا انتم عابدون ما اعبد",
            "ولا انا عابد ما عبدتم",
            "ولا انتم عابدون ما اعبد",
            "لكم دينكم ولي دين",
    };
    String[] nasrpronunciation = {
            "اذا جاء نصر الله والفتح",
            "ورايت الناس يدخلون في دين الله افواجا",
            "فسبح بحمد ربك واستغفر",
            "انه كان توابا",
    };
    String[] lahabpronunciation = {
            "تبت  يدا ابي لهب وتب",
            "ما اغني عنه ماله وما كسب",
            "سيصلى نارا ذات لهب",
            "ومراته حمالة الحطب",
            "في جيدها حبل  من مسد",
    };
    String[] ikhlaspronunciation = {
            "قل هو الله احد",
            "الله الصمد",
            "لم يلد ولم يولد",
            "ولم يكن له كفوا احد",
    };
    String[] falakpronunciation = {
            "قل اعوذ برب الفلق",
            "من شر ما خلق",
            "ومن شر غاسق اذا وقب",
            "ومن شر النفاثات في العقد",
            "ومن شر حاسد اذا حسد",
    };
    String[] naspronunciation = {
            "قل اعوذ برب الناس",
            "ملك الناس",
            "اله الناس",
            "من شر الوسواس الخناس",
            "الذي يوسوس في صدور الناس",
            "من الجنة والناس",
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
        suraImageSwitcher = view.findViewById(R.id.suratextSwither);
        orthoImageSwitcher = view.findViewById(R.id.textSwitcherBanglaOrtho);
        textSwitcherFatehaTYPING = view.findViewById(R.id.presetTextSwitcher);
        suraPrevious = view.findViewById(R.id.surapreviousBtn);
        suraNext = view.findViewById(R.id.suranextBtn);
        suraReplay = view.findViewById(R.id.surareplayBtn);
        suraMic = view.findViewById(R.id.suramicBtn);
        suracomapre = view.findViewById(R.id.suracompareBtn);
        userVoiceTV = view.findViewById(R.id.userVoiceTV);

        suraName = view.findViewById(R.id.suraName);



        suraLearnlistView = view.findViewById(R.id.suraLearnListView);
        learnLayout = view.findViewById(R.id.learnlayout);

        suraList = new ArrayList<>();
        suraList.add("সুরা ফাতেহা");
        suraList.add("সুরা ফীল");
        suraList.add("সূরা কুরাইশ");
        suraList.add("সুরা মাউন");
        suraList.add("সূরা কাওসার");
        suraList.add("সুরা কাফিরুন");
        suraList.add("সূরা নাসর");
        suraList.add("সুরা লাহাব");
        suraList.add("সূরা ইখলাস");
        suraList.add("সুরা ফালাক");
        suraList.add("সূরা নাস");


        ArrayAdapter<String> adapter = new ArrayAdapter <>(getContext(),R.layout.support_simple_spinner_dropdown_item,suraList);
        suraLearnlistView.setAdapter(adapter);

        suraLearnlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);


                    suraName.setText("সূরা ফাতেহা");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<fateha.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(fateha[position_array]);
                                orthoImageSwitcher.setText(fatehaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(fatehapronunciation[position_array]);

                                try {
                                    fatehamedia.stop();
                                    fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);
                                    currentayat++;
                                    fatehamedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });

                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (fatehamedia == null){
                                fatehamedia = MediaPlayer.create(getContext(),fatehamp3[currentayat]);

                            }
                            fatehamedia.start();

                        }
                    });

                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(fateha[position_array]);

                                orthoImageSwitcher.setText(fatehaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(fatehapronunciation[position_array]);

                                try {

                                    fatehamedia.stop();
                                    MediaPlayer.create(getContext(),fatehamp3[currentayat]);

                                    currentayat--;
                                    fatehamedia.start();
                                }catch (Exception e){


                                }

                            }


                        }
                    });

                    Toast.makeText(getContext(), "Fateha"+suraList.get(position), Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);


                    suraName.setText("সূরা ফীল");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(feel[position_array]);

                                orthoImageSwitcher.setText(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia.stop();
                                    feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);
                                    currentayat++;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (feelmedia == null){
                                feelmedia = MediaPlayer.create(getContext(),feelamp3[currentayat]);

                            }
                            feelmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(feel[position_array]);

                                orthoImageSwitcher.setText(feelaortho[position_array]);
                                textSwitcherFatehaTYPING.setText(feelpronunciation[position_array]);

                                try {
                                    feelmedia.stop();
                                    MediaPlayer.create(getContext(),feelamp3[currentayat]);

                                    currentayat--;
                                    feelmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });


                    Toast.makeText(getContext(), "Feel"+suraList.get(position), Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    quraishmedia = MediaPlayer.create(getContext(),quraishamp3[currentayat]);


                    suraName.setText("সূরা কুরাইশ");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<quraish.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(quraish[position_array]);

                                orthoImageSwitcher.setText(quraishortho[position_array]);
                                textSwitcherFatehaTYPING.setText(quraishpronunciation[position_array]);

                                try {
                                    quraishmedia.stop();
                                    quraishmedia = MediaPlayer.create(getContext(),quraishamp3[currentayat]);
                                    currentayat++;
                                    quraishmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (quraishmedia == null){
                                quraishmedia = MediaPlayer.create(getContext(),quraishamp3[currentayat]);

                            }
                            quraishmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(quraish[position_array]);

                                orthoImageSwitcher.setText(quraishortho[position_array]);
                                textSwitcherFatehaTYPING.setText(quraishpronunciation[position_array]);

                                try {
                                    quraishmedia.stop();
                                    MediaPlayer.create(getContext(),quraishamp3[currentayat]);

                                    currentayat--;
                                    quraishmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });



                }
                if (position==3){

                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    maunmedia = MediaPlayer.create(getContext(),maunmp3[currentayat]);


                    suraName.setText("সূরা মাউন");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<maun.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(maun[position_array]);

                                orthoImageSwitcher.setText(maunortho[position_array]);
                                textSwitcherFatehaTYPING.setText(maunpronunciation[position_array]);

                                try {
                                    maunmedia.stop();
                                    maunmedia = MediaPlayer.create(getContext(),maunmp3[currentayat]);
                                    currentayat++;
                                    maunmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (maunmedia == null){
                                maunmedia = MediaPlayer.create(getContext(),maunmp3[currentayat]);

                            }
                            maunmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(maun[position_array]);

                                orthoImageSwitcher.setText(maunortho[position_array]);
                                textSwitcherFatehaTYPING.setText(maunpronunciation[position_array]);

                                try {
                                    maunmedia.stop();
                                    MediaPlayer.create(getContext(),maunmp3[currentayat]);

                                    currentayat--;
                                    maunmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });



                }
                if (position==4){

                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    kaosarmedia = MediaPlayer.create(getContext(),kaosarmp3[currentayat]);


                    suraName.setText("সূরা কাওসার");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<kaosar.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(kaosar[position_array]);

                                orthoImageSwitcher.setText(kaosarortho[position_array]);
                                textSwitcherFatehaTYPING.setText(kaosarpronunciation[position_array]);

                                try {
                                    kaosarmedia.stop();
                                    kaosarmedia = MediaPlayer.create(getContext(),kaosarmp3[currentayat]);
                                    currentayat++;
                                    kaosarmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (kaosarmedia == null){
                                kaosarmedia = MediaPlayer.create(getContext(),kaosarmp3[currentayat]);

                            }
                            kaosarmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(kaosar[position_array]);

                                orthoImageSwitcher.setText(kaosarortho[position_array]);
                                textSwitcherFatehaTYPING.setText(kaosarpronunciation[position_array]);

                                try {
                                    kaosarmedia.stop();
                                    MediaPlayer.create(getContext(),kaosarmp3[currentayat]);

                                    currentayat--;
                                    kaosarmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });


                }
                if (position==5){

                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    kafirunmedia = MediaPlayer.create(getContext(),kafirunmp3[currentayat]);


                    suraName.setText("সূরা কাফিরুন");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<kafirun.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(kafirun[position_array]);

                                orthoImageSwitcher.setText(kafirunortho[position_array]);
                                textSwitcherFatehaTYPING.setText(kafirunpronunciation[position_array]);

                                try {
                                    kafirunmedia.stop();
                                    kafirunmedia = MediaPlayer.create(getContext(),kafirunmp3[currentayat]);
                                    currentayat++;
                                    kafirunmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (kafirunmedia == null){
                                kafirunmedia = MediaPlayer.create(getContext(),kafirunmp3[currentayat]);

                            }
                            kafirunmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(kafirun[position_array]);

                                orthoImageSwitcher.setText(kafirunortho[position_array]);
                                textSwitcherFatehaTYPING.setText(kafirunpronunciation[position_array]);

                                try {
                                    kafirunmedia.stop();
                                    MediaPlayer.create(getContext(),kafirunmp3[currentayat]);

                                    currentayat--;
                                    kafirunmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });


                }
                if (position==6){

                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    nasrmedia = MediaPlayer.create(getContext(),nasrmp3[currentayat]);


                    suraName.setText("সূরা নাস্র");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<feel.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(nasr[position_array]);

                                orthoImageSwitcher.setText(nasrortho[position_array]);
                                textSwitcherFatehaTYPING.setText(nasrpronunciation[position_array]);

                                try {
                                    nasrmedia.stop();
                                    nasrmedia = MediaPlayer.create(getContext(),nasrmp3[currentayat]);
                                    currentayat++;
                                    nasrmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (nasrmedia == null){
                                nasrmedia = MediaPlayer.create(getContext(),nasrmp3[currentayat]);

                            }
                            nasrmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(nasr[position_array]);

                                orthoImageSwitcher.setText(nasrortho[position_array]);
                                textSwitcherFatehaTYPING.setText(nasrpronunciation[position_array]);

                                try {
                                    nasrmedia.stop();
                                    MediaPlayer.create(getContext(),nasrmp3[currentayat]);

                                    currentayat--;
                                    nasrmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });


                }
                if (position==7){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    lahabmedia = MediaPlayer.create(getContext(),lahabmp3[currentayat]);


                    suraName.setText("সূরা লাহাব");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<lahab.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(lahab[position_array]);

                                orthoImageSwitcher.setText(lahabortho[position_array]);
                                textSwitcherFatehaTYPING.setText(lahabpronunciation[position_array]);

                                try {
                                    lahabmedia.stop();
                                    lahabmedia = MediaPlayer.create(getContext(),lahabmp3[currentayat]);
                                    currentayat++;
                                    lahabmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (lahabmedia == null){
                                lahabmedia = MediaPlayer.create(getContext(),lahabmp3[currentayat]);

                            }
                            lahabmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(lahab[position_array]);

                                orthoImageSwitcher.setText(lahabortho[position_array]);
                                textSwitcherFatehaTYPING.setText(lahabpronunciation[position_array]);

                                try {
                                    lahabmedia.stop();
                                    MediaPlayer.create(getContext(),lahabmp3[currentayat]);

                                    currentayat--;
                                    lahabmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });



                }
                if (position==8){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    ikhlasmedia = MediaPlayer.create(getContext(),ikhlasmp3[currentayat]);


                    suraName.setText("সূরা ইখলাস");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<ikhlas.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(ikhlas[position_array]);

                                orthoImageSwitcher.setText(ikhlasortho[position_array]);
                                textSwitcherFatehaTYPING.setText(ikhlaspronunciation[position_array]);

                                try {
                                    ikhlasmedia.stop();
                                    ikhlasmedia = MediaPlayer.create(getContext(),ikhlasmp3[currentayat]);
                                    currentayat++;
                                    ikhlasmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (ikhlasmedia == null){
                                ikhlasmedia = MediaPlayer.create(getContext(),ikhlasmp3[currentayat]);

                            }
                            ikhlasmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(ikhlas[position_array]);

                                orthoImageSwitcher.setText(ikhlasortho[position_array]);
                                textSwitcherFatehaTYPING.setText(ikhlaspronunciation[position_array]);

                                try {
                                    ikhlasmedia.stop();
                                    MediaPlayer.create(getContext(),ikhlasmp3[currentayat]);

                                    currentayat--;
                                    ikhlasmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });


                }
                if (position==9){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    falakmedia = MediaPlayer.create(getContext(),falakmp3[currentayat]);


                    suraName.setText("সূরা ফালাক");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<falak.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(falak[position_array]);

                                orthoImageSwitcher.setText(falakortho[position_array]);
                                textSwitcherFatehaTYPING.setText(falakpronunciation[position_array]);

                                try {
                                    falakmedia.stop();
                                    falakmedia = MediaPlayer.create(getContext(),falakmp3[currentayat]);
                                    currentayat++;
                                    falakmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (falakmedia == null){
                                falakmedia = MediaPlayer.create(getContext(),falakmp3[currentayat]);

                            }
                            falakmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(falak[position_array]);

                                orthoImageSwitcher.setText(falakortho[position_array]);
                                textSwitcherFatehaTYPING.setText(falakpronunciation[position_array]);

                                try {
                                    falakmedia.stop();
                                    MediaPlayer.create(getContext(),falakmp3[currentayat]);

                                    currentayat--;
                                    falakmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });



                }
                if (position==10){
                    learnLayout.setVisibility(View.VISIBLE);
                    suraLearnlistView.setVisibility(View.GONE);

                    nasmedia = MediaPlayer.create(getContext(),nasmp3[currentayat]);


                    suraName.setText("সূরা নাস");
                    suraNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array<nas.length-1) {

                                position_array = position_array + 1;
                                suraImageSwitcher.setText(nas[position_array]);

                                orthoImageSwitcher.setText(nasortho[position_array]);
                                textSwitcherFatehaTYPING.setText(naspronunciation[position_array]);

                                try {
                                    nasmedia.stop();
                                    nasmedia = MediaPlayer.create(getContext(),nasrmp3[currentayat]);
                                    currentayat++;
                                    nasmedia.start();
                                }catch (Exception e){


                                }

                            }


                        }

                    });


                    suraReplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (nasmedia == null){
                                nasmedia = MediaPlayer.create(getContext(),nasmp3[currentayat]);

                            }
                            nasmedia.start();

                        }
                    });
                    suraPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(position_array>0){

                                position_array = position_array-1;
                                suraImageSwitcher.setText(nas[position_array]);

                                orthoImageSwitcher.setText(nasortho[position_array]);
                                textSwitcherFatehaTYPING.setText(naspronunciation[position_array]);

                                try {
                                    nasmedia.stop();
                                    MediaPlayer.create(getContext(),nasmp3[currentayat]);

                                    currentayat--;
                                    nasmedia.start();
                                }catch (Exception e){


                                }

                            }

                        }
                    });



                }




            }
        });


        goodToast = MediaPlayer.create(getContext(),R.raw.masha_allah2);
        badToast = MediaPlayer.create(getContext(),R.raw.try_again);








        suraImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(50);
                textView.setText("بِسٛمِ اللّٰهِ الرَّحٛمٰنِ الرَّحِيٛمِ۞");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });



        orthoImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                textView.setText("শুরু করছি আল্লাহর নামে যিনি পরম করুণাময়, অতি দয়ালু।");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setGravity(Gravity.CENTER);
                return textView;
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
