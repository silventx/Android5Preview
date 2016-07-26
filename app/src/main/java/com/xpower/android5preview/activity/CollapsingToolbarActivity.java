package com.xpower.android5preview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.xpower.android5preview.R;

/**
 * Created by 4399-3040 on 2016/7/25.
 */
public class CollapsingToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        mCollapsingLayout.setTitle("Android5Preview");
        mToolbar.setTitle("Android5Preview");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.collapsing_iv_image);
//        imageView.setBackgroundResource(R.mipmap.ic_launcher);
    }

}
