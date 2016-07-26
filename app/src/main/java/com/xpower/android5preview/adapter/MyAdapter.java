package com.xpower.android5preview.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpower.android5preview.R;
import com.xpower.android5preview.utils.ToastUtil;

import java.util.List;

/**
 * Created by 4399-3040 on 2016/7/20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> mData;
    private Context mContext;
    private boolean mIsStaggered; //判断是否为瀑布流绑定控件
    private int mOrientation; //默认为Vertical

    public MyAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
        this.mOrientation = LinearLayoutManager.VERTICAL;
        this.mIsStaggered = false;
    }

    public MyAdapter(Context context, List<String> data, int orientation, boolean isStaggered) {
        this.mContext = context;
        this.mData = data;
        this.mOrientation = orientation;
        this.mIsStaggered = isStaggered;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder;
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_default, parent, false));
        } else {
            holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_default_horizontal, parent, false));
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));
        holder.tv.setHeight(300);
        if (mIsStaggered) {
            holder.tv.setHeight(300 + (position % 5)* 200);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        MyViewHolder(View view) {
            super(view);
            if (mOrientation == LinearLayoutManager.VERTICAL) {
                this.tv = (TextView) view.findViewById(R.id.item_default_tv);
            } else {
                this.tv = (TextView) view.findViewById(R.id.item_default_horizontal_tv);
            }
        }
    }

    //添加一个item
    public void addData(int position) {
        mData.add(position, "New Item");
        notifyItemInserted(position);
    }

    public void addData(int position, View view) {
        mData.add(position, "New Item");
        notifyItemInserted(position);

        Snackbar.make(view, "添加成功", Snackbar.LENGTH_LONG).setAction("撤销", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               deleteData(1);
            }
        }).show();
    }

    //删除一个item
    public void deleteData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void deleteData(final int position, View view) {
        mData.remove(position);
        notifyItemRemoved(position);

        Snackbar.make(view, "删除成功", Snackbar.LENGTH_LONG).setAction("撤销", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData(position);
            }
        }).show();
    }
}
