package com.example.nasos.miniproject2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nasos on 2017-07-12.
 */


public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }
    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
//            case 0:
//                return new FirstFragment();
//            case 1:
//                return  new SecondFragment();
//            case 2:
//                return  new ThirdFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}