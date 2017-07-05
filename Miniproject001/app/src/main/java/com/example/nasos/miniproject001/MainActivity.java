package com.example.nasos.miniproject001;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.newsfeed_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.friend_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.alert_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.menu_selector));
    //    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
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

    public void onClickImgBtn(View v){
        Toast.makeText(v.getContext(), "다이렉트 메시지함", Toast.LENGTH_SHORT).show();


    }


    public void onClickMSG(View v){
        Toast.makeText(v.getContext(), "메시지", Toast.LENGTH_SHORT).show();


    }


//    private void initLayout(){
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        ctl.setTitle("Details");
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {   getMenuInflater().inflate(R.menu.menu_search, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return  true;
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
                    FirstFragment tabFragment1 = new FirstFragment();
                    return tabFragment1;
                case 1:
                    SecondFragment tabFragment2 = new SecondFragment();
                    return tabFragment2;
                case 2:
                    ThirdFragment tabFragment3 = new ThirdFragment();
                    return tabFragment3;
                case 3:
                    FourthFragment tabFragment4 = new FourthFragment();
                    return tabFragment4;
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
