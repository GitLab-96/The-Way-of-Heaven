package com.example.soundtest.Question;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TeastAccessAdapter extends FragmentPagerAdapter {
    public TeastAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                ChatFragment chatFragment = new ChatFragment();
                return  chatFragment;

            case 1:
                GroupFragment groupFragment = new GroupFragment();
                return  groupFragment;

            case 2:
                LiveFragment liveFragment = new LiveFragment();
                return  liveFragment;
            case 3:
                ContactFragment contactFragment = new ContactFragment();
                return  contactFragment;
            case 4:
                RojaFragment rojaFragment = new RojaFragment();
                return  rojaFragment;
            case 5:
                HajjFragmant hajjFragmant = new HajjFragmant();
                return  hajjFragmant;
            case 6:
                ZakatFragment zakatFragment = new ZakatFragment();
                return  zakatFragment;
            case 7:
                ShudFragment shudFragment = new ShudFragment();
                return  shudFragment;
            case 8:
                GhushFragment ghushFragment = new GhushFragment();
                return  ghushFragment;


                default:
                    return null;
        }

    }


    @Override
    public int getCount() {
        return 9;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position){

            case 0:

                return  "আপনার প্রশ্ন";

            case 1:

                return  "জনপ্রিয় প্রশ্ন";

            case 2:

                return  "সাম্প্রতিক";
            case 3:

                return  "নামাজ";

            case 4:

                return  "রোজা";
            case 5:

                return  "হজ্জ";
            case 6:

                return  "যাকাত";
            case 7:

                return  "সুধ";
            case 8:

                return  "ঘুষ";

            default:
                return null;
        }
    }
}
