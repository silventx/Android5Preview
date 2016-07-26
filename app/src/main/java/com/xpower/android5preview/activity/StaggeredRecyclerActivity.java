package com.xpower.android5preview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xpower.android5preview.R;
import com.xpower.android5preview.adapter.MyAdapter;
import com.xpower.android5preview.utils.CommonUtil;
import com.xpower.android5preview.widget.GridDividerItemDecoration;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class StaggeredRecyclerActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;
    private RecyclerView.ItemDecoration mItemDecoration,mCustomDecoration;
    private MyAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_staggered);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_staggerd_rv);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mToolBar.setTitle(getResources().getStringArray(R.array.recycler_list)[2]);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mData = CommonUtil.array2List(getResources().getStringArray(R.array.sample_list));
        mAdapter = new MyAdapter(this, mData, LinearLayoutManager.VERTICAL, true);
        mRecyclerView.setAdapter(mAdapter);

        mItemDecoration = new GridDividerItemDecoration(this);
        mCustomDecoration = new GridDividerItemDecoration(this, R.drawable.custom_divider);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(mItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mFab.setOnClickListener(onFabClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_recycler_add:
                mAdapter.addData(1,mRecyclerView);
                break;
            case R.id.menu_recycler_delete:
                mAdapter.deleteData(1, mRecyclerView);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener onFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRecyclerView.removeItemDecoration(mItemDecoration);
            mRecyclerView.addItemDecoration(mCustomDecoration);
            mFab.setOnClickListener(onClickedFabListener);
        }
    };

    View.OnClickListener onClickedFabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRecyclerView.removeItemDecoration(mCustomDecoration);
            mRecyclerView.addItemDecoration(mItemDecoration);
            mFab.setOnClickListener(onFabClickListener);
        }
    };
}
