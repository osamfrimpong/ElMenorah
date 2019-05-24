package com.schandorf.elmenorah;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.schandorf.elmenorah.Fragments.EntertainmentFragment;
import com.schandorf.elmenorah.Fragments.HomeFragment;
import com.schandorf.elmenorah.Fragments.RegistrationFragment;

public class LauncherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // setTitle("Elmenorah");
        HomeFragment homeFragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
        fragmentTransactionHome.replace(R.id.homecontentlayout,homeFragment,"Home Fragment");
        fragmentTransactionHome.commit();


        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:
                        setTitle("Elmenorah");
                        HomeFragment homeFragment = new HomeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionHome.replace(R.id.homecontentlayout,homeFragment,"Home Fragment");
                        fragmentTransactionHome.commit();
                        return true;
                    case R.id.navigation_registration:
                        setTitle("Camp Registration");
                        RegistrationFragment registrationFragment = new RegistrationFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionregistration = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionregistration.replace(R.id.homecontentlayout, registrationFragment,"Registration");
                        fragmentTransactionregistration.commit();
                        return true;
                    case R.id.navigation_entertainment:
                        setTitle("Entertainment");
                        EntertainmentFragment entertainmentFragment = new EntertainmentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionEntertainment = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionEntertainment.replace(R.id.homecontentlayout, entertainmentFragment,"Entertainment");
                        fragmentTransactionEntertainment.commit();
                        return true;
                    case R.id.navigation_others:
                        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                        return true;
                }
                return false;
            }
        });
    }

}
