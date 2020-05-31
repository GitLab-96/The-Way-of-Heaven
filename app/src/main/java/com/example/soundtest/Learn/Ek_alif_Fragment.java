package com.example.soundtest.Learn;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soundtest.R;
import com.google.android.material.tabs.TabLayout;


public class Ek_alif_Fragment extends Fragment {

    private TabLayout ek_alif_TabLayout;
    private ViewPager ek_alif_viewPager;
    private Ek_Alif_Access_Adapter ek_alif_AccessAdapter;


    public Ek_alif_Fragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ek_alif_, container, false);


        ek_alif_TabLayout = view.findViewById(R.id.Ek_Alif_main_tabs);
        ek_alif_viewPager = view.findViewById(R.id.ekAlifViewPager);
        ek_alif_AccessAdapter = new Ek_Alif_Access_Adapter(getChildFragmentManager());
        ek_alif_viewPager.setAdapter(ek_alif_AccessAdapter);
        ek_alif_TabLayout.setupWithViewPager(ek_alif_viewPager);










          return view;
    }

}
