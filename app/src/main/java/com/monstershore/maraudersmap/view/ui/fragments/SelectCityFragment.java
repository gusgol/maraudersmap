package com.monstershore.maraudersmap.view.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monstershore.maraudersmap.R;


public class SelectCityFragment extends Fragment {

    public SelectCityFragment() {
    }

    public static SelectCityFragment newInstance() {
        SelectCityFragment fragment = new SelectCityFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_city, container, false);
    }

}
