package com.example.soundtest.Question.Scholer;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ScholarsAccessAdapter extends FragmentPagerAdapter {

    public ScholarsAccessAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                ScholarsAnswerFragment scholarsAnswerFragment = new ScholarsAnswerFragment();
                return scholarsAnswerFragment;

            case 1:
                ScholarsCourseFragment scholarsCourseFragment = new ScholarsCourseFragment();
                return scholarsCourseFragment;

            case 2:
                ScholarsLiveFragment scholarsLiveFragment = new ScholarsLiveFragment();
                return scholarsLiveFragment;

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

                return  "Answer";

            case 1:

                return  "Course";

            case 2:

                return  "Live";

            default:
                return null;
        }
    }

}
