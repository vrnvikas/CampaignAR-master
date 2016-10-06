package com.campaignar.smis.campaignar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.campaignar.smis.campaignar.Adapter.BadgesGridViewRecyclerViewAdapter;
import com.campaignar.smis.campaignar.R;

public class BadgesActivity extends BaseActivity {

    RecyclerView badgesRecyclerView;
    BadgesGridViewRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);
        getSupportActionBar().setTitle("BADGES");
        badgesRecyclerView = (RecyclerView) findViewById(R.id.badges_recycler_view);
        String[] badgesNames = this.getResources().getStringArray(R.array.badges_names_list);
        String[] badgesInfo = this.getResources().getStringArray(R.array.badges_info_list);
        adapter = new BadgesGridViewRecyclerViewAdapter(this,badgesNames,badgesInfo);
        badgesRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        badgesRecyclerView.setHasFixedSize(true);
        badgesRecyclerView.setAdapter(adapter);
    }
}
