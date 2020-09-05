package com.example.soundtest.Learn;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MaddExamAccesAdapter extends FragmentPagerAdapter {
    public MaddExamAccesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                MaddLearn maddLearn = new MaddLearn();
                return maddLearn;

            case 1:
                MaddExam maddExam = new MaddExam();
                return maddExam;

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

                return  "মদ্দ";

            case 1:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
