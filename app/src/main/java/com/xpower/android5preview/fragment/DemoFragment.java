package com.xpower.android5preview.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpower.android5preview.R;
import com.xpower.android5preview.activity.ShowActivity;
import com.xpower.android5preview.adapter.DemoAdapter;
import com.xpower.android5preview.listener.RecyclerItemClickListener;
import com.xpower.android5preview.utils.CommonUtil;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class DemoFragment extends Fragment{

    private View mBaseView;
    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;
    private List<String> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.fragment_demo, container, false);

        mRecyclerView = (RecyclerView) mBaseView.findViewById(R.id.frag_demo_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mData = CommonUtil.array2List(getActivity().getResources().getStringArray(R.array.sample_list));
        mAdapter = new DemoAdapter(getActivity(), mData);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), listener));

        return mBaseView;
    }

    RecyclerItemClickListener.OnItemClickListener listener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            startActivity(new Intent(getActivity(), ShowActivity.class));
        }
    };
}
