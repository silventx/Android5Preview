package com.xpower.android5preview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpower.android5preview.R;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/22.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    private List<String> mData;
    private Context mContext;

    public DemoAdapter(Context context, List<String> data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText("CardView " + (position + 1));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        viewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_demo, parent, false));
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_demo_tv);
        }
    }
}
