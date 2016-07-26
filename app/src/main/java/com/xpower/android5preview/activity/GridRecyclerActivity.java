package com.xpower.android5preview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class GridRecyclerActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;
    private RecyclerView.ItemDecoration mItemDecoration, mCustomItemDecoration;
    private MyAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_grid_rv);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mToolBar.setTitle(getResources().getStringArray(R.array.recycler_list)[1]);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mData = CommonUtil.array2List(getResources().getStringArray(R.array.sample_list));
        mAdapter = new MyAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);

        mItemDecoration = new GridDividerItemDecoration(this);
        mCustomItemDecoration = new GridDividerItemDecoration(this, R.drawable.custom_divider);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
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
                mAdapter.addData(1, mRecyclerView);
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
            mRecyclerView.addItemDecoration(mCustomItemDecoration);
            mFab.setOnClickListener(onClickedFabClickListener);
        }
    };

    View.OnClickListener onClickedFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRecyclerView.removeItemDecoration(mCustomItemDecoration);
            mRecyclerView.addItemDecoration(mItemDecoration);
            mFab.setOnClickListener(onFabClickListener);
        }
    };
}
