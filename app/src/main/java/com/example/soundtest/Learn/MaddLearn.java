package com.example.soundtest.Learn;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaddLearn extends Fragment {
    private TabLayout maddTabLayout;
    private ViewPager maddviewPager;
    private MaddAccessAdapter maddAccessAdapter;

    public MaddLearn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_madd_learn, container, false);


        maddTabLayout = view.findViewById(R.id.madd_main_tabs);
        maddviewPager = view.findViewById(R.id.maddViewPager);
        maddAccessAdapter = new MaddAccessAdapter(getChildFragmentManager());
        maddviewPager.setAdapter(maddAccessAdapter);
        maddTabLayout.setupWithViewPager(maddviewPager);


    return view;
    }

}
