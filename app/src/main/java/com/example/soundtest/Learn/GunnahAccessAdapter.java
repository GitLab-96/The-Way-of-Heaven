package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GunnahAccessAdapter extends FragmentPagerAdapter {
    public GunnahAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                Nune_Sakin_Fragment nune_sakin_fragment = new Nune_Sakin_Fragment();
                return nune_sakin_fragment;

            case 1:
                MIme_Sakin_Fragment mIme_sakin_fragment = new MIme_Sakin_Fragment();
                return mIme_sakin_fragment;

            case 2:
               GunnahExam  gunnahExam = new GunnahExam();
                return gunnahExam;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {


        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "নুনে সাকিন";

            case 1:

                return  "মিমে সাকিন";

            case 2:

                return  "পরিক্ষা";

            default:
                return null;
        }
    }
}
