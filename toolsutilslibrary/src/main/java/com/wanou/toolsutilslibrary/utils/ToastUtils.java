package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Author by wodx521
 * Date on 2018/11/5.
 */

@SuppressLint("ShowToast")
public class ToastUtils {
    private static Toast toast;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initToast(Context applicationContext) {
        context = applicationContext;
    }

    static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }

    static void showToast(@StringRes int resId) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(resId);
        toast.show();
    }
}
