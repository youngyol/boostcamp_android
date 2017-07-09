package com.example.nasos.miniproject1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.nasos.miniproject1.view.FirstFragment;
import com.example.nasos.miniproject1.view.FourthFragment;
import com.example.nasos.miniproject1.view.SecondFragment;
import com.example.nasos.miniproject1.view.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.mTabLayout)
    TabLayout tabLayout;

    @OnClick({R.id.message, R.id.directMSG})
    public void onClickMSG(View v){
        switch (v.getId()){
            case R.id.message:
                Toast.makeText(v.getContext(), "메시지", Toast.LENGTH_SHORT).show();
                break;
            case R.id.directMSG:
                Toast.makeText(v.getContext(), "다이렉트 메시지함", Toast.LENGTH_SHORT).show();
                break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Initializing the TabLayout
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.newsfeed_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.friend_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.alert_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.menu_selector));

        viewPager = (ViewPager) findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }






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
}
