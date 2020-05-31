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
public class Char_Alif_Fragment extends Fragment {

    private TabLayout char_alif_TabLayout;
    private ViewPager char_alif_viewPager;
    private Char_Alif_Access_Adapter char_alif_AccessAdapter;

    public Char_Alif_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_char__alif_, container, false);

        char_alif_TabLayout = view.findViewById(R.id.char_Alif_main_tabs);
        char_alif_viewPager = view.findViewById(R.id.charAlifViewPager);
        char_alif_AccessAdapter = new Char_Alif_Access_Adapter(getChildFragmentManager());
        char_alif_viewPager.setAdapter(char_alif_AccessAdapter);
        char_alif_TabLayout.setupWithViewPager(char_alif_viewPager);






    return view;
    }

}
