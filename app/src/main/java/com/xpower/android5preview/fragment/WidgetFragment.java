package com.xpower.android5preview.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.xpower.android5preview.R;
import com.xpower.android5preview.activity.CardViewActivity;
import com.xpower.android5preview.activity.CollapsingToolbarActivity;
import com.xpower.android5preview.activity.RecyclerListActivity;
import com.xpower.android5preview.activity.TabLayoutActivity;
import com.xpower.android5preview.activity.TextInputLayoutActivity;
import com.xpower.android5preview.adapter.MyAdapter;
import com.xpower.android5preview.listener.RecyclerItemClickListener;
import com.xpower.android5preview.utils.CommonUtil;
import com.xpower.android5preview.utils.ToastUtil;
import com.xpower.android5preview.widget.DividerItemDecoration;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class WidgetFragment extends Fragment {

    private View mBaseView;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.fragment_widget, container, false);

        mRecyclerView = (RecyclerView) mBaseView.findViewById(R.id.frag_widget_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> data = CommonUtil.array2List(getActivity().getResources().getStringArray(R.array.widget_list));
        mRecyclerView.setAdapter(new MyAdapter(getActivity(), data));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), listener));

        return mBaseView;
    }

    RecyclerItemClickListener.OnItemClickListener listener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    startActivity(new Intent(getActivity(), RecyclerListActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), CardViewActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(getActivity(), TextInputLayoutActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getActivity(), CollapsingToolbarActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(getActivity(), TabLayoutActivity.class));
                    break;
            }
        }
    };


}
