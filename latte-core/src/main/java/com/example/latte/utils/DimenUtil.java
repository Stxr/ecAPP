package com.example.latte.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.latte.app.Latte;

/**
 * Created by stxr .
 * Date: 18-1-30
 * Time: 下午12:29
 * note:
 */
public class DimenUtil {
    /**
     * 测量屏幕的宽
     * @return 返回屏幕的宽
     */
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 测量屏幕的高
     * @return 返回屏幕的高
     */
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
