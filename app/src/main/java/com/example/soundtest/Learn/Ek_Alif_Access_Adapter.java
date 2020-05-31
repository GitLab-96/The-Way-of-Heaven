package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Ek_Alif_Access_Adapter extends FragmentPagerAdapter {

    public Ek_Alif_Access_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                TobayeFragment tobayeFragment = new TobayeFragment();
                return tobayeFragment;

            case 1:
                Bodol_Fragment bodol_fragment = new Bodol_Fragment();
                return bodol_fragment;

            case 2:
                Leen_Fragment leen_fragment = new Leen_Fragment();
                return leen_fragment;

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

                return  "মদ্দে তবায়ি";

            case 1:

                return  "মদ্দে বদল";

            case 2:

                return  "মদ্দে লীন";

            default:
                return null;
        }
    }
}
