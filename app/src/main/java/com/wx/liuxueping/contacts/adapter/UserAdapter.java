package com.wx.liuxueping.contacts.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wx.liuxueping.contacts.bean.User;

import java.util.List;

/**
 * Created by liuxueping on 2017/5/2.
 */

public class UserAdapter extends BaseAdapter<User> {

    private final static int SHOWTITLE = 0;
    private final static int HIDETITLE = 1;

    public UserAdapter(List<User> data, Context mContext) {
        super(data, mContext);
    }

    @Override
    public BaseHolder<User> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(getmContext()).inflate(UserHolder.getLayoutId(), parent, false),viewType==SHOWTITLE);
    }



    @Override
    public int getItemViewType(int position) {
        if (position > 0) {
            User lastUser = getData().get(position-1);
            User user = getData().get(position);
            if(TextUtils.equals(lastUser.getFirstletter(),user.getFirstletter())){
                return HIDETITLE;
            }else {
                return SHOWTITLE;
            }
        } else {
            return SHOWTITLE;
        }

    }
}
