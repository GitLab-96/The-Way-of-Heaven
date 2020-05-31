package com.example.soundtest.Learn;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Char_Alif_Access_Adapter extends FragmentPagerAdapter {
    public Char_Alif_Access_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Harfi_Mukhaffaf harfi_mukhaffaf = new Harfi_Mukhaffaf();
                return harfi_mukhaffaf;

            case 1:
                Harfi_Musakkal harfi_musakkal = new Harfi_Musakkal();
                return harfi_musakkal;

            case 2:
                Kalmi_Mukhaffaf kalmi_mukhaffaf  = new Kalmi_Mukhaffaf();
                return kalmi_mukhaffaf;

            case 3:
                Kalmi_Musakkal kalmi_musakkal = new Kalmi_Musakkal();
                return kalmi_musakkal;

            case 4:
                Muttasil muttasil = new Muttasil();
                return muttasil;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "হারফি মুখাফফাফ";

            case 1:

                return  "হারফি মুসাক্কাল";

            case 2:

                return  "কালমি মুখাফফাফ";

            case 3:

                return  "কালমি মুসাক্কাল";

            case 4:

                return  "মুত্তাসিল";

            default:
                return null;
        }
    }


}
