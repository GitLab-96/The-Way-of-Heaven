package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TomijHorofAccessAdapter extends FragmentPagerAdapter {

    public TomijHorofAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                TomijHorofLearn tomijHorofLearn = new TomijHorofLearn();
                return tomijHorofLearn;

            case 1:
                TomijHorofExam tomijHorofExam = new TomijHorofExam();
                return tomijHorofExam;

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

                return  "তমীয হরফ";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
