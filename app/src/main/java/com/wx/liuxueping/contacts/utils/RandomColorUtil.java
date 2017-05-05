package com.wx.liuxueping.contacts.utils;

import android.graphics.Color;

/**
 * Created by liuxueping on 2017/5/4.
 */

public class RandomColorUtil {

   private  static  int color[] = new int[]{Color.parseColor("#F1715D"),Color.parseColor("#568AAD"),Color.parseColor("#16C194"),Color.parseColor("#F6B45D"),Color.parseColor("#4DA9EB")};

    public  static int getRandomColor(){
        int length = color.length;
        if(length>0){
            return color[(int) (Math.random()*(length-1))];

        }else {
            return  Color.parseColor("#F1715D");
        }
    }
}
