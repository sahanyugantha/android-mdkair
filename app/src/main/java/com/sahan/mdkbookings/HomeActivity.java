package com.sahan.mdkbookings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.sahan.mdkbookings.adpater.HomePagerAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.homeTabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.homeViewPager);

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), 1);
        viewPager.setAdapter(homePagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
