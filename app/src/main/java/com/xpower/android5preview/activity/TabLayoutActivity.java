package com.xpower.android5preview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xpower.android5preview.R;
import com.xpower.android5preview.adapter.MyAdapter;
import com.xpower.android5preview.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/25.
 */
public class TabLayoutActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.tab_layout_viewpager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle(getResources().getStringArray(R.array.widget_list)[4]);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setupViewPager();

        mTabLayout.addTab(mTabLayout.newTab().setText("tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab3"));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(SampleFragment.newInstance("Fragment 1"), "Fragment 1");
        adapter.addFragment(SampleFragment.newInstance("Fragment 2"), "Fragment 2");
        adapter.addFragment(SampleFragment.newInstance("Fragment 3"), "Fragment 3");
        mViewPager.setAdapter(adapter);
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<Fragment>();
        private List<String> titles = new ArrayList<String>();

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
