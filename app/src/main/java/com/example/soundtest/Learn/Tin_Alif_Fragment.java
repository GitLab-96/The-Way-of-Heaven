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
public class Tin_Alif_Fragment extends Fragment {

    private TabLayout tin_alif_TabLayout;
    private ViewPager tin_alif_viewPager;
    private Tin_Alif_Access_Adapter tin_alif_access_adapter;



    public Tin_Alif_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tin__alif_, container, false);



        tin_alif_TabLayout = view.findViewById(R.id.Tin_Alif_main_tabs);
        tin_alif_viewPager = view.findViewById(R.id.tinAlifViewPager);
        tin_alif_access_adapter = new Tin_Alif_Access_Adapter(getChildFragmentManager());
        tin_alif_viewPager.setAdapter(tin_alif_access_adapter);
        tin_alif_TabLayout.setupWithViewPager(tin_alif_viewPager);





   return view;
    }

}
