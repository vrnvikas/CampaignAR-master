package com.campaignar.smis.campaignar.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.campaignar.smis.campaignar.Adapter.HomeScreenRecyclerViewAdapter;
import com.campaignar.smis.campaignar.R;

import ayar.oktay.advancedtextview.AdvancedTextView;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {


    private RecyclerView recyclerView;
    private HomeScreenRecyclerViewAdapter recyclerViewAdapter;
    private String[] dataArray;
    private TypedArray myImages;
    private View badgesView;
    private ImageView ivShare;
    private AdvancedTextView tvShare;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.home_screen_recycler_view);
        badgesView = findViewById(R.id.badge_view);
        tvShare = (AdvancedTextView) findViewById(R.id.tvShare);
        ivShare = (ImageView) findViewById(R.id.ivShare);
        setSupportActionBar(toolbar);
        setTitle("");
        dataArray = getResources().getStringArray(R.array.home_screen_list);
        myImages = getResources().obtainTypedArray(R.array.icon_images_home_screen_list);
        recyclerViewAdapter = new HomeScreenRecyclerViewAdapter(this,dataArray,myImages);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        badgesView.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Share();
            }
        });
        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Share();
            }
        });


    }

    private void Share() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        startActivityFromDrawer(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == badgesView.getId()){
            startActivity(new Intent(this,BadgesActivity.class));
        }
    }


    private void startActivityFromDrawer(int id) {
        Log.d("id", Integer.toString(id));
        switch (id){
            case R.id.nav_home:
                break;
            case R.id.nav_discussions:
                startActivity(new Intent(this, LiveDiscussions.class));
                break;
            case R.id.nav_be_the_cm:
                Intent intent = new Intent(this,com.google.unity.GoogleUnityActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_ar_history:
                startActivity(new Intent(this, SimplePlayerActivity.class));
                break;
            case R.id.nav_interest:
                startActivity(new Intent(this, YourInterests.class));
                break;
            case R.id.nav_candidate:
                startActivity(new Intent(this, KnowYourCandidate.class));
                break;
            case R.id.nav_polling_booth:
                startActivity(new Intent(this, PollingBoothActivity.class));
                break;
            case R.id.nav_party:
                startActivity(new Intent(this, VideoGallery.class));
                break;
            case R.id.nav_video_gallery:
                startActivity(new Intent(this, VideoGallery.class));
                break;
            default:
                startActivity(new Intent(this, HomeScreen.class));
                break;
        }
    }
}
