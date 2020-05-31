package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.soundtest.Question.RojaFragment;

public class MaddAccessAdapter extends FragmentPagerAdapter {

    public MaddAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                Ek_alif_Fragment ek_alif_fragment = new Ek_alif_Fragment();
                return ek_alif_fragment;

            case 1:
                Tin_Alif_Fragment tin_alif_fragment = new Tin_Alif_Fragment();
                return tin_alif_fragment;

            case 2:
                Char_Alif_Fragment char_alif_fragment = new Char_Alif_Fragment();
                return char_alif_fragment;

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

                return  "এক আলিফ";

            case 1:

                return  "তিন আলিফ";

            case 2:

                return  "চার আলিফ";

            default:
                return null;
        }
    }

    }

