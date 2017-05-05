package com.wx.liuxueping.contacts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wx.liuxueping.contacts.bean.User;

import java.util.List;

/**
 * Created by liuxueping on 2017/4/27.
 */

public abstract  class BaseAdapter<T> extends RecyclerView.Adapter<BaseHolder<T>> {

    private List<T> data;
    private Context mContext;


    public BaseAdapter(List<T> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public abstract BaseHolder<T> onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseHolder<T> holder, int position) {
        T t=getItemObject(position);
        holder.bindData(t);
    }

    public int getItemCount() {

        return data==null?0:data.size();
    }

    public T getItemObject(int position){
        if(null!=data&&data.size()>position){
          return   data.get(position);
        }else {
            return null;
        }
    }
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Context getmContext() {
        return mContext;
    }


}
