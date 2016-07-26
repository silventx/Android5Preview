package com.xpower.android5preview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xpower.android5preview.R;
import com.xpower.android5preview.adapter.MyAdapter;
import com.xpower.android5preview.listener.RecyclerItemClickListener;
import com.xpower.android5preview.utils.CommonUtil;
import com.xpower.android5preview.widget.DividerItemDecoration;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class RecyclerListActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcer_list);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_list_rv);
        mToolBar.setTitle("RecyclerView");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mData = CommonUtil.array2List(getResources().getStringArray(R.array.recycler_list));
        mAdapter = new MyAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, listener));
    }

    RecyclerItemClickListener.OnItemClickListener listener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    startActivity(new Intent(RecyclerListActivity.this, LinearRecyclerActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(RecyclerListActivity.this, GridRecyclerActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(RecyclerListActivity.this, StaggeredRecyclerActivity.class));
                    break;

            }
        }
    };
}
