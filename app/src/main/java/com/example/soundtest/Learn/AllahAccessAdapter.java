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
            case 2:
                AllahExam allahExam = new AllahExam();
                return allahExam;

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

                return  "মোটা";

            case 1:

                return "চিকন";

            case 2:

                return "পরিক্ষা";

            default:
                return null;
        }
    }
}
