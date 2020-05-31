package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Tin_Alif_Access_Adapter extends FragmentPagerAdapter {

    public Tin_Alif_Access_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ArgeFragment argeFragment = new ArgeFragment();
                return argeFragment;

            case 1:
                MunfasilFragment munfasilFragment = new MunfasilFragment();
                return munfasilFragment;


            default:
                return null;
        }
    }
        @Override
        public int getCount () {
            return 2;
        }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "মদ্দে আরজি";

            case 1:

                return  "মদ্দে মুনফাসিল";


            default:
                return null;
        }
    }

    }

