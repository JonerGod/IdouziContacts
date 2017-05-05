package com.wx.liuxueping.contacts.adapter;


import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wx.liuxueping.contacts.R;
import com.wx.liuxueping.contacts.bean.User;
import com.wx.liuxueping.contacts.utils.RandomColorUtil;
import com.wx.liuxueping.contacts.view.CircleImageView;


/**
 * Created by liuxueping on 2017/5/2.
 */


public class UserHolder extends BaseHolder<User> {

    TextView tvTitle;
    CircleImageView tvMonicker;
    TextView tvName;
    TextView tvPhoneNumber;
    public UserHolder(View itemView, boolean showTitle) {
        super(itemView);
        initViews(itemView, showTitle);
    }

    private void initViews(View itemView, boolean showTitle) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvPhoneNumber = (TextView) itemView.findViewById(R.id.tv_phone_number);
        tvMonicker = (CircleImageView) itemView.findViewById(R.id.tv_monicker);
        if (showTitle) {
            tvTitle.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public void bindData(User user) {
        tvTitle.setText(user.getFirstletter());
        String name = user.getName();
        tvName.setText(name);
        if (TextUtils.isEmpty(name) || name.length() < 3) {
            tvMonicker.setmText(name);
        } else {
            tvMonicker.setmText(name.subSequence(name.length() - 2, name.length()).toString());
        }
        tvMonicker.setFillColor(RandomColorUtil.getRandomColor());
        tvPhoneNumber.setText(user.getPhoneNumber());
    }


    public static int getLayoutId() {
        return R.layout.item_layout_user;
    }

}
