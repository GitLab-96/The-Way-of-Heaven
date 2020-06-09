package com.example.soundtest.Question;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.soundtest.Learn.AllahFragmentChikon;
import com.example.soundtest.Learn.AllahFragmentMota;

public class QuestionAccessAdapter extends FragmentPagerAdapter {
    public QuestionAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                ApnarProsnoFragment apnarProsnoFragment = new ApnarProsnoFragment();
                return apnarProsnoFragment;

            case 1:
                ShamprotikProshno shamprotikProshno = new ShamprotikProshno();
                return shamprotikProshno;

            case 2:
                JonoPrioProshno jonoPrioProshno = new JonoPrioProshno();
                return jonoPrioProshno;

            case 3:
                NamazFragment namazFragment = new NamazFragment();
                return namazFragment;

            case 4:
                RojaFragment rojaFragment = new RojaFragment();
                return rojaFragment;

            case 5:
                HajjFragment hajjFragment = new HajjFragment();
                return hajjFragment;

            case 6:
                JakatFragment jakatFragment = new JakatFragment();
                return jakatFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "আপনার প্রশ্ন";

            case 1:

                return "সাম্প্রতিক প্রশ্ন";

            case 2:

                return  "জনপ্রিয় প্রশ্ন";

            case 3:

                return "নামাজ";

            case 4:

                return  "রোজা";

            case 5:

                return "হজ্জ";


            case 6:

                return "যাকাত";

            default:
                return null;
        }
    }

}
