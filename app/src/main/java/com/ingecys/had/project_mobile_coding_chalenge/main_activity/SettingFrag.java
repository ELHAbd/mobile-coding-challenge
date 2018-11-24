package com.ingecys.had.project_mobile_coding_chalenge.main_activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingecys.had.project_mobile_coding_chalenge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFrag extends Fragment {


    public SettingFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

}
