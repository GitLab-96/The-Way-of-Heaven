package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AllahAccessAdapter extends FragmentPagerAdapter {
    public AllahAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                AllahFragmentMota allahFragmentMota = new AllahFragmentMota();
                return allahFragmentMota;

            case 1:
                AllahFragmentChikon allahFragmentChikon = new AllahFragmentChikon();
                return allahFragmentChikon;

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

                return  "মোটা";

            case 1:

                return "চিকন";

            default:
                return null;
        }
    }
}
