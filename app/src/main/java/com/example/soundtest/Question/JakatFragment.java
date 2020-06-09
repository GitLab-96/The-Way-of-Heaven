package com.example.soundtest.Question;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soundtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JakatFragment extends Fragment {


    public JakatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jakat, container, false);
    }

}
