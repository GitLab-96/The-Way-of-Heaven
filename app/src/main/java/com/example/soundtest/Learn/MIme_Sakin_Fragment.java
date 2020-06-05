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
public class MIme_Sakin_Fragment extends Fragment {

    private TabLayout mime_sakin_TabLayout;
    private ViewPager mime_sakin_viewPager;
    private MimeSakinAccessAdapter mimeSakinAccessAdapter;

    public MIme_Sakin_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mime__sakin_, container, false);

        mime_sakin_TabLayout = view.findViewById(R.id.mime_sakin_main_tabs);
        mime_sakin_viewPager = view.findViewById(R.id.mimeSakinViewPager);
        mimeSakinAccessAdapter = new MimeSakinAccessAdapter(getChildFragmentManager());
        mime_sakin_viewPager.setAdapter(mimeSakinAccessAdapter);
        mime_sakin_TabLayout.setupWithViewPager(mime_sakin_viewPager);


        return view;

    }

}
