package com.campaignar.smis.campaignar.Activity;

import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.campaignar.smis.campaignar.Fragments.FragmentKnowYourCandidate;
import com.campaignar.smis.campaignar.Fragments.FragmentKnowYourCandidateDetail;
import com.campaignar.smis.campaignar.Fragments.FragmentYourInterestsDetail;
import com.campaignar.smis.campaignar.R;

public class KnowYourCandidate extends BaseActivity
        implements FragmentKnowYourCandidate.OnFragmentInteractionListener,
        FragmentKnowYourCandidateDetail.OnFragmentInteractionListener,
        FragmentYourInterestsDetail.OnFragmentInteractionListener{

    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_candidate);

        getSupportActionBar().setTitle("Know Your Candidate");

        if (findViewById(R.id.fragment_container) != null) {

            currentFragment = FragmentKnowYourCandidate.newInstance("","");
            currentFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, currentFragment).commit();
        }

    }

    @Override
    public void onLoadFragmentKonwYourCandidateDetail() {
        Fragment newFragment = FragmentKnowYourCandidateDetail.newInstance("","");
        getSupportFragmentManager().beginTransaction()
                .add(newFragment, "RING_SPECS")
                .addToBackStack(null)
                .replace(R.id.fragment_container, newFragment)
                .commit();
        currentFragment = newFragment;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
