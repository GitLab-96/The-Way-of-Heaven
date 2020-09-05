package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WajibAccessAdapter extends FragmentPagerAdapter {
    public WajibAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                WajibLearn wajibLearn = new WajibLearn();
                return wajibLearn;

            case 1:
                WajibExam wajibExam = new WajibExam();
                return wajibExam;

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

                return  "ওয়াজিব গুন্নাহ";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
