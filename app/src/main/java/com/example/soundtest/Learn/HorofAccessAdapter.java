package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HorofAccessAdapter extends FragmentPagerAdapter {


    public HorofAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                 HorofLearn horofLearn = new HorofLearn();
                return horofLearn;

            case 1:
                HorofExam horofExam = new HorofExam();
                return horofExam;

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

                return  "হরফ";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
