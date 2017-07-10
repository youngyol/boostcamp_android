package com.example.nasos.miniproject1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nasos.miniproject1.view.FirstFragment;
import com.example.nasos.miniproject1.view.FourthFragment;
import com.example.nasos.miniproject1.view.SecondFragment;
import com.example.nasos.miniproject1.view.ThirdFragment;

/**
 * Created by nasos on 2017-07-09.
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
            case 0:
                return new FirstFragment();
            case 1:
                return  new SecondFragment();
            case 2:
                return  new ThirdFragment();
            case 3:
                return  new FourthFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}