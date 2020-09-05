package com.example.soundtest.Learn;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class KolkolaAccessAdapter extends FragmentPagerAdapter {
    public KolkolaAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                KolkolaLearn kolkolaLearn = new KolkolaLearn();
                return kolkolaLearn;

            case 1:
                KolkolaExam kolkolaExam = new KolkolaExam();
                return kolkolaExam;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "কল্কলা";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }

}
