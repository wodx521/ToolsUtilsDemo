package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Author by wodx521
 * Date on 2018/11/5.
 */
public class UiUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static DecimalFormat decimalFormat = new DecimalFormat();

    public static void initContext(Application application) {
        context = application;
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 获取屏幕宽
     *
     * @param activity 当前页面的activity
     * @return 当前页面宽
     */
    public static int getDeviceWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        return p.x;
    }

    /**
     * 获取屏幕的高
     *
     * @param activity 当前页面的activity
     * @return 当前页面高
     */
    public static int getDeviceHeight(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        return p.y;
    }

    /**
     * 判断传入的字符串是否为空
     *
     * @param strings 传入的字符串数组
     * @return 全部非空返回true 否则返回false
     */
    public static boolean isEmpty(String... strings) {
        if (strings != null && strings.length > 0) {
            for (String string : strings) {
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 要获取内容的TextView
     *
     * @param textView TextView
     * @return TextView内容
     */
    public static String getText(TextView textView) {
        return textView.getText().toString().trim();
    }

    /**
     * 格式化数字为指定格式
     *
     * @param number  需要格式化的数字
     * @param pattern 指定格式
     * @return 格式化完成后的字符串
     */
    public static String formatNumber(double number, String pattern) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(number);
    }

    /**
     * 格式化数字为指定格式
     *
     * @param number  需要格式化的数字
     * @param pattern 指定格式
     * @return 格式化完成后的字符串
     */
    public static String formatNumber(long number, String pattern) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(number);
    }

    /**
     * 格式化数字为指定格式
     *
     * @param number  需要格式化的数字
     * @param pattern 指定格式
     * @return 格式化完成后的字符串
     */
    public static String formatNumber(Object number, String pattern) {
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(number);
    }

    /**
     * 格式化文字字符串为制定格式
     *
     * @param stringNum 需要格式化的字符串
     * @param pattern   格式类型
     * @return 格式化后的字符串
     */
    public static String formatString(String stringNum, String pattern) {
        if (isEmpty(stringNum)) {
            if (stringNum.contains(".")) {
                Double aDouble = Double.valueOf(stringNum);
                return formatNumber(aDouble, pattern);
            }
            return stringNum;
        }
        return "0";
    }

}
