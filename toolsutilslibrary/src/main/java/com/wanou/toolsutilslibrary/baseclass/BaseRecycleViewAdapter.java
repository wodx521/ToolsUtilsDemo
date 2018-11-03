package com.wanou.toolsutilslibrary.baseclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BaseRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        View.OnClickListener, View.OnLongClickListener {

    protected Context mContext;
    protected LayoutInflater inflater;
    protected int defItem = -1;

    public BaseRecycleViewAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindClickListener(holder, position);
    }

    //绑定点击监听事件
    private void bindClickListener(RecyclerView.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(position);
        viewHolder.itemView.setOnClickListener(this);
        viewHolder.itemView.setOnLongClickListener(this);
    }

    public void setSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }


    public int getSelect() {
        return defItem;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            onItemClickListener.onItemClickListener(v, (Integer) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return onItemLongClickListener != null && onItemLongClickListener.onItemLongClickListener(v, (Integer) v.getTag());
    }

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    /*设置点击事件*/
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /*设置长按事件*/
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClickListener(View view, int position);
    }
}
