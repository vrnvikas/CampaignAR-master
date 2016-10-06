package com.campaignar.smis.campaignar.Activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;

import com.campaignar.smis.campaignar.Fragments.BlankFragment;
import com.campaignar.smis.campaignar.Fragments.FragmentYourInterests;
import com.campaignar.smis.campaignar.Fragments.FragmentYourInterestsDetail;
import com.campaignar.smis.campaignar.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

public class YourInterestsDetail extends BaseActivity
        implements BlankFragment.OnFragmentInteractionListener,FragmentYourInterestsDetail.OnFragmentInteractionListener {

    FragmentPagerItemAdapter adapter;
    ViewPager viewPager;
    SmartTabLayout viewPagerTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_interests_detail);
        getSupportActionBar().setTitle("YOUR INTERESTS");
        setupViewPager();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(BlankFragment.newInstance("",""), "INITIATIVES");
        adapter.addFrag(BlankFragment.newInstance("",""), "NEWS");
        adapter.addFrag(BlankFragment.newInstance("",""), "GALLARY");

        viewPager.setAdapter(adapter);
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

        private String[] tabsTitles = {"INITIATIVES","INTRO","NEWS","GALLERY"};

        public FragmentPagerItemAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabsTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            BlankFragment fragment = BlankFragment.newInstance("","");
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
