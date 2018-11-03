package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

import com.wanou.toolsutilslibrary.R;


/**
 * @author wodx521
 * @date on 2018/8/15
 */
public class ClipboardUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initClipboardUtils(Application application) {
        context = application;
    }

    public static void copyText(String copyText) {
        //获取剪贴板管理器
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (!TextUtils.isEmpty(copyText)) {
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", copyText);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            ToastUtils.showToast(R.string.copy_success);
        } else {
            ToastUtils.showToast(R.string.copy_fail);
        }
    }
}
