package com.schandorf.elmenorah;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.schandorf.elmenorah.Adapters.MyPagerAdapter;
import com.schandorf.elmenorah.Fragments.EntertainmentFragment;
import com.schandorf.elmenorah.Fragments.HomeFragment;
import com.schandorf.elmenorah.Fragments.LiteratureFragment;
import com.schandorf.elmenorah.Fragments.UpdatesFragment;

import io.realm.Realm;

public class HomeActivity extends AppCompatActivity {
Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ViewPager viewPager = findViewById(R.id.homepager);
        MyPagerAdapter mypageradapter = new MyPagerAdapter(getSupportFragmentManager());
        mypageradapter.addFragment(new HomeFragment(),"Home");
        mypageradapter.addFragment(new LiteratureFragment(),"Literature");
        mypageradapter.addFragment(new EntertainmentFragment(),"Media");
        mypageradapter.addFragment(new UpdatesFragment(),"News Feed");
//      mypageradapter.addFragment(new OthersFragment(), "Others");

        viewPager.setAdapter(mypageradapter);

        TabLayout tblayout = findViewById(R.id.hometabLayout);
        tblayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(realm != null)
        {
            realm.close();
        }
    }
}
