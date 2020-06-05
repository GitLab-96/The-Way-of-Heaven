package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MimeSakinAccessAdapter extends FragmentPagerAdapter {
    public MimeSakinAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                IkhfaSafwe ikhfaSafwe = new IkhfaSafwe();
                return ikhfaSafwe;

            case 1:
                IdgameMislain idgameMislain = new IdgameMislain();
                return idgameMislain;

            case 2:
                IjhareKhas ijhareKhas = new IjhareKhas();
                return ijhareKhas;


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

                return  "ইখফা";

            case 1:

                return  "ইদগাম";

            case 2:

                return  "ইযহার";

            default:
                return null;
        }
    }




}
