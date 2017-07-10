package com.example.nasos.miniproject1;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.mTabLayout)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @OnClick({R.id.message, R.id.directMSG})
    public void onClickMSG(View v) {
        switch (v.getId()) {
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
        setSupportActionBar(toolbar);


        initTabLayout();
        makePagerAdapter();


    }

    private void makePagerAdapter() {
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


    //Initializing the TabLayout
    private void initTabLayout() {
        TypedArray tabIcons = getResources().obtainTypedArray(R.array.tabs_icon);
        for (int index = 0; index < 4; index++) {
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.getTabAt(index).setIcon(tabIcons.getResourceId(index, R.drawable.friend_selector));
        }


    }


}
