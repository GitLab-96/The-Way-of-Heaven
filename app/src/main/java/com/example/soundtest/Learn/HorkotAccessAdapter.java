package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HorkotAccessAdapter extends FragmentPagerAdapter {
    public HorkotAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                HorkotLearn horkotLearn = new HorkotLearn();
                return horkotLearn;

            case 1:
                HorkotExam horkotExam = new HorkotExam();
                return horkotExam;

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

                return  "হরকত";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }

}
