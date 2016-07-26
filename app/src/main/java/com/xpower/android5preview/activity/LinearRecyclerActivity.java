package com.xpower.android5preview.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xpower.android5preview.R;
import com.xpower.android5preview.adapter.MyAdapter;
import com.xpower.android5preview.utils.CommonUtil;
import com.xpower.android5preview.widget.DividerItemDecoration;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class LinearRecyclerActivity extends AppCompatActivity {

    private CoordinatorLayout mHolder;

    private Toolbar mToolBar;
    private RecyclerView mRvVertical, mRvHorizontal;
    private FloatingActionButton mFab;

    private RecyclerView.ItemDecoration mVerticalDecoration, mHorizontalDecoration, mCVerticalDecoration, mCHorizontalDecoration;

    private MyAdapter mAdapter, mHorizontalAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_linear);

        mHolder = (CoordinatorLayout) findViewById(R.id.rec_linear_holder);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRvVertical = (RecyclerView) findViewById(R.id.rec_linear_rv_vertical);
        mRvHorizontal = (RecyclerView) findViewById(R.id.rec_linear_rv_horizontal);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        //初始化ToolBar
//        mToolBar.inflateMenu(R.menu.recycler_toolbar);
        mToolBar.setTitle(getResources().getStringArray(R.array.recycler_list)[0]);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //初始化RecyclerView
        mData = CommonUtil.array2List(getResources().getStringArray(R.array.sample_list));
        mAdapter = new MyAdapter(this, mData);
        mHorizontalAdapter = new MyAdapter(this, mData, LinearLayoutManager.HORIZONTAL, false);

        LinearLayoutManager vManager = new LinearLayoutManager(this);
        vManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvVertical.setLayoutManager(vManager);
        mRvVertical.setAdapter(mAdapter);
        mVerticalDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRvVertical.addItemDecoration(mVerticalDecoration);

        LinearLayoutManager hManager = new LinearLayoutManager(this);
        hManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHorizontal.setLayoutManager(hManager);
        mRvHorizontal.setAdapter(mHorizontalAdapter);
        mHorizontalDecoration = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
        mRvHorizontal.addItemDecoration(mHorizontalDecoration);

        mCHorizontalDecoration = new DividerItemDecoration(LinearRecyclerActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.custom_divider);
        mCVerticalDecoration = new DividerItemDecoration(LinearRecyclerActivity.this, LinearLayoutManager.VERTICAL, R.drawable.custom_divider);

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
                mAdapter.addData(1, mHolder);
                mHorizontalAdapter.addData(1);
                break;
            case R.id.menu_recycler_delete:
                mAdapter.deleteData(1, mHolder);
                mHorizontalAdapter.deleteData(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener onFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRvVertical.removeItemDecoration(mVerticalDecoration);
            mRvVertical.addItemDecoration(mCVerticalDecoration);
            mRvHorizontal.removeItemDecoration(mHorizontalDecoration);
            mRvHorizontal.addItemDecoration(mCHorizontalDecoration);

            mFab.setOnClickListener(onClickedFabClickListener);
        }
    };

    View.OnClickListener onClickedFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRvVertical.removeItemDecoration(mCVerticalDecoration);
            mRvVertical.addItemDecoration(mVerticalDecoration);
            mRvHorizontal.removeItemDecoration(mCHorizontalDecoration);
            mRvHorizontal.addItemDecoration(mHorizontalDecoration);

            mFab.setOnClickListener(onFabClickListener);
        }
    };
}
