package com.campaignar.smis.campaignar.Activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.campaignar.smis.campaignar.Fragments.FragmentYourInterestsDetail;
import com.campaignar.smis.campaignar.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

public class OurPartyActivity extends BaseActivity
implements FragmentYourInterestsDetail.OnFragmentInteractionListener{

    FragmentPagerItemAdapter adapter;
    ViewPager viewPager;
    SmartTabLayout viewPagerTab;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_party);

        getSupportActionBar().setTitle("Our Party");

        // setupToolbar();

        setupViewPager();

        //setupCollapsingToolbar();
    }


    private void setupCollapsingToolbar() {
        // final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(
        //         R.id.collapse_toolbar);
        // collapsingToolbar.setTitleEnabled(false);
    }

    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TabbedCoordinatorLayout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(FragmentYourInterestsDetail.newInstance("",""), "ABOUT");
        adapter.addFrag(FragmentYourInterestsDetail.newInstance("",""), "AGENDAS");
        adapter.addFrag(FragmentYourInterestsDetail.newInstance("",""), "OPINIONS");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {


            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private class FragmentPagerItemAdapter extends FragmentPagerAdapter {

        private String[] tabsTitles = {"ABOUT","LEADERS","PROGRESS"};

        public FragmentPagerItemAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabsTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            FragmentYourInterestsDetail fragment = FragmentYourInterestsDetail.newInstance("","");
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }



}
