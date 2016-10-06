package com.campaignar.smis.campaignar.Activity;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.campaignar.smis.campaignar.Adapter.LiveDiscussionRecyclerViewAdapter;
import com.campaignar.smis.campaignar.Fragments.FragmentLiveDiscussion;
import com.campaignar.smis.campaignar.Fragments.FragmentPostQuestion;
import com.campaignar.smis.campaignar.R;

public class LiveDiscussions extends BaseActivity
        implements FragmentLiveDiscussion.OnFragmentInteractionListener,
        FragmentPostQuestion.OnFragmentInteractionListener{

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_discussions);

        getSupportActionBar().setTitle("Live Discussions in 360");

        if (findViewById(R.id.fragment_container) != null) {

            currentFragment = FragmentLiveDiscussion.newInstance();

//            currentFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, currentFragment).commit();
        }
    }


    @Override
    public void onLoadFramentPostQuestion() {
//        Fragment newFragment = FragmentPostQuestion.newInstance("","");
//        getSupportFragmentManager().beginTransaction()
//                .add(newFragment, "RING_SPECS")
//                .addToBackStack(null)
//                .replace(R.id.fragment_container, newFragment)
//                .commit();
//        currentFragment = newFragment;
    }

    @Override
    public void onLoadFragmentLiveDiscussion() {
//        Fragment newFragment = FragmentLiveDiscussion.newInstance();
//        getSupportFragmentManager().beginTransaction()
//                .add(newFragment, "RING_SPECS")
//                .addToBackStack(null)
//                .replace(R.id.fragment_container, newFragment)
//                .commit();
//        currentFragment = newFragment;
    }
}
