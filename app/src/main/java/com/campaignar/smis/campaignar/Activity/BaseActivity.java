package com.campaignar.smis.campaignar.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.campaignar.smis.campaignar.R;

public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private Bundle state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = savedInstanceState;
    }


    @Override
    public void setContentView(int layoutResID) {

        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_basic,null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        startActivityFromDrawer(id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    private void startActivityFromDrawer(int id) {
        switch (id){
            case R.id.nav_home:
                startActivity(new Intent(this, HomeScreen.class));
                break;
            case R.id.nav_discussions:
                startActivity(new Intent(this, LiveDiscussions.class));
                break;
            case R.id.nav_be_the_cm:
                break;
            case R.id.nav_ar_history:
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
                startActivity(new Intent(this, OurPartyActivity.class));
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
