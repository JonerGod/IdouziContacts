package com.wx.liuxueping.contacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;



/**
 * Created by liuxueping on 2017/4/27.
 */

public  abstract  class BaseHolder<T> extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T t);
}
