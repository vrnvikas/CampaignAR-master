package com.campaignar.smis.campaignar.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.campaignar.smis.campaignar.Fragments.FragmentYourInterests;
import com.campaignar.smis.campaignar.R;

public class YourInterests extends BaseActivity implements FragmentYourInterests.OnFragmentInteractionListener{


    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_intrests);

        getSupportActionBar().setTitle("YOUR INTERESTS");

        if (findViewById(R.id.fragment_container) != null) {

            currentFragment = FragmentYourInterests.newInstance("","");
            currentFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, currentFragment).commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
