package com.ingecys.had.project_mobile_coding_chalenge.main_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapterRepos extends FragmentStatePagerAdapter {
    public PagerAdapterRepos(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ReposFrag();
            case 1:
                return new SettingFrag();


            default:
                break;


        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";
        switch (position) {
            case 0:
                title = "Trending";
                break;
            case 1:
                title = "Setting";
                break;




        }

        return title;
    }

}
