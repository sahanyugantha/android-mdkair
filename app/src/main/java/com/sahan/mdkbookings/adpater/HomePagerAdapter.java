package com.sahan.mdkbookings.adpater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sahan.mdkbookings.view.DashboardFragment;
import com.sahan.mdkbookings.view.HistoryFragment;
import com.sahan.mdkbookings.view.HotDealsFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new DashboardFragment();
                break;
            case 1:
                fragment = new HotDealsFragment();
                break;
            case 2:
                fragment = new HistoryFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }


    String titles[] = {"Home", "Hot Deals", "History"};
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
