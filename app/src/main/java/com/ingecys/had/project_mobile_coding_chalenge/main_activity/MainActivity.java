package com.ingecys.had.project_mobile_coding_chalenge.main_activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ingecys.had.project_mobile_coding_chalenge.R;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolbarAndTablayout();



        setupViewPager(pager);


        setupTabIcon();

    }

    private void initToolbarAndTablayout() {

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#520556"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#000000"));

    }


    private void setupTabIcon() {

        //after initialization TabLayout and ViewPager
        TabLayout.Tab tabTrending = tabLayout.getTabAt(0);
        tabTrending.setIcon(R.drawable.ic_stars);

        TabLayout.Tab tabSetting = tabLayout.getTabAt(1);
        tabSetting.setIcon(R.drawable.ic_setting);
    }

    private void setupViewPager(ViewPager pager) {


        // Fragment manager to add fragment in viewpager we will pass object of Fragment manager to adpater class.
        FragmentManager manager=getSupportFragmentManager();
        //object of PagerAdapter passing fragment manager object as a parameter of constructor of PagerAdapter class.
        PagerAdapterRepos adapter=new PagerAdapterRepos(manager);
        //set Adapter to view pager
        pager.setAdapter(adapter);
        //set tablayout with viewpager
        tabLayout.setupWithViewPager(pager);
        // mTabLayout.setupWithViewPager(mPager1);

        // adding functionality to tab and viewpager to manage each other when a page is changed or when a tab is selected
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Setting tabs from adpater
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
}
