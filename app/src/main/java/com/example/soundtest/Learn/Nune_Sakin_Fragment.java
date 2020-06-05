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
 * A simple {@link Fragment} subclass./
 */
public class Nune_Sakin_Fragment extends Fragment {
    private TabLayout nun_sakin_TabLayout;
    private ViewPager nun_sakin_viewPager;
    private NuneSakinAccessAdapter nunSakinAccessAdapter;

    public Nune_Sakin_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nune__sakin_, container, false);

        nun_sakin_TabLayout = view.findViewById(R.id.nun_sakin_main_tabs);
        nun_sakin_viewPager = view.findViewById(R.id.nunSakinViewPager);
        nunSakinAccessAdapter = new NuneSakinAccessAdapter(getChildFragmentManager());
        nun_sakin_viewPager.setAdapter(nunSakinAccessAdapter);
        nun_sakin_TabLayout.setupWithViewPager(nun_sakin_viewPager);


        return view;
    }

}
