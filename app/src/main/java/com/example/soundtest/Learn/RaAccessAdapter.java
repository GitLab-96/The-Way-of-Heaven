package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class RaAccessAdapter extends FragmentPagerAdapter {
    public RaAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

        case 0:
            PurFragment purFragment = new PurFragment();
            return purFragment;

        case 1:
            BarikFragment barikFragment = new BarikFragment();
            return barikFragment;


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

                return  "পুর";

            case 1:

                return  "বারিক";

            default:
                return null;
        }
    }
}
