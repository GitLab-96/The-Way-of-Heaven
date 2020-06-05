package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NuneSakinAccessAdapter extends FragmentPagerAdapter {
    public NuneSakinAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                IqlabFragment iqlabFragment = new IqlabFragment();
                return iqlabFragment;

            case 1:
                Edgam_Fragment edgam_fragment = new Edgam_Fragment();
                return edgam_fragment;

            case 2:
                IjharFragment ijharFragment = new IjharFragment();
                return ijharFragment;

            case 3:
                IkhfaFragment ikhfaFragment = new IkhfaFragment();
                return ikhfaFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "ইকলাব";

            case 1:

                return  "ইদগাম";

            case 2:

                return  "ইযহার";


            case 3:

                return  "ইখফা";

            default:
                return null;
        }
    }


}
