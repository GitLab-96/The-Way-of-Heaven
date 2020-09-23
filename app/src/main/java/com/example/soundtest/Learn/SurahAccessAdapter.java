package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SurahAccessAdapter extends FragmentPagerAdapter {
    public SurahAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                SurahLearn surahLearn = new SurahLearn();
                return surahLearn;

            case 1:
                SurahExam surahExam = new SurahExam();
                return surahExam;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "সূরা";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
