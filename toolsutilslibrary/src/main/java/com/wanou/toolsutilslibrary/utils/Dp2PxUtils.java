package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * @author wodx521
 * @date on 2018/8/15
 */
public class Dp2PxUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initDp2PxUtils(Application application) {
        context = application;
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     *
     * @param dpValue 需要转换的dp值
     * @return 返回转换后的值
     */
    public static int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue 需要转换的px值
     * @return 返回转换后的值
     */
    public static int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue 需要转换的px值
     * @return 返回转换后的值
     */
    public static int px2sp(float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue 需要转换的sp值
     * @return 返回转换后的值
     */
    public static int sp2px(float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}

