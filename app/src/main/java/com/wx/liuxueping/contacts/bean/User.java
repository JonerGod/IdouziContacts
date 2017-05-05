package com.wx.liuxueping.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.github.promeg.pinyinhelper.Pinyin;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by liuxueping on 2017/5/2.
 */

public class User  implements Parcelable,Comparable<User>{
    private String id;
    private String name;
    private String firstletter;
    private String type;
    private String phoneNumber;

    public User() {
    }

    protected User(Parcel in) {
        id = in.readString();
        name = in.readString();
        firstletter = in.readString();
        type = in.readString();
        phoneNumber = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstletter() {
        if(!TextUtils.isEmpty(name)){
            String pinyin = Pinyin.toPinyin(name,"");
            firstletter = pinyin.substring(0,1).toUpperCase();
        }else {
            firstletter = "#";
        }
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(firstletter);
        parcel.writeString(type);
        parcel.writeString(phoneNumber);
    }


    @Override
    public int compareTo(@NonNull User user) {
        String name = user.getFirstletter();
        if(TextUtils.isEmpty(name)){
            return 1;
        }

        if(TextUtils.isEmpty(getFirstletter())){
            return -1;
        }
        int isLetter = 1;
        int isLetter1 = 1;
        if(getFirstletter().matches("[A-Z]")){
            isLetter =isLetter<<1;
        }
        if(user.getFirstletter().matches("[A-Z]")){
            isLetter1 = isLetter1<<1;
        }

        if((isLetter & isLetter1 )== 0){
            if(isLetter==1){
                return 1;
            }else {
                return -1;
            }

        } else {
            return getFirstletter().compareTo(name);
        }

    }
}
