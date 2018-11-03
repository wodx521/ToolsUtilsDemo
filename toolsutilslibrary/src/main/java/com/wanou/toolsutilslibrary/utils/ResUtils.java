package com.wanou.toolsutilslibrary.utils;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Application;
import android.content.res.Resources;
import android.os.Build;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @author wodx521
 * @date on 2018/8/16
 */
public class ResUtils {
    public static Resources resources;
    public static Application mApplication;

    /**
     * 初始化获取资源类
     *
     * @param application 全局上下文
     */
    public static void initGetResUtils(Application application) {
        mApplication = application;
        resources = application.getResources();
    }

    /**
     * 获取资源id对应的字符串
     *
     * @param resId 资源ID
     * @return 返回对应字符串
     */
    public static String getString(int resId) {
        return resources.getString(resId);
    }

    /**
     * 获取资源id对应的字符串数组
     *
     * @param resId 资源ID
     * @return 返回对应字符串数组
     */
    public static String[] getStringArray(int resId) {
        return resources.getStringArray(resId);
    }

    /**
     * 获取资源id对应的颜色值
     *
     * @param resId 资源ID
     * @return 返回对应颜色值
     */
    public static int getColor(int resId) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? resources.getColor(resId, null) : resources.getColor(resId);
    }

    public static Animation getAnimation(int resId) {
        return AnimationUtils.loadAnimation(mApplication, resId);
    }

    public static Animator getAnimator(int resId) {
        return AnimatorInflater.loadAnimator(mApplication, resId);
    }
}
