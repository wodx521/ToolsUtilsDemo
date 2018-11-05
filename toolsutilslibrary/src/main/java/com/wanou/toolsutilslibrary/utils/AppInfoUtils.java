package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Author by wodx521
 * Date on 2018/11/5.
 */
public class AppInfoUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initAppInfoUtils(Application application) {
        context = application;
    }

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    private static long getLocalVersion() {
        long localVersion = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                localVersion = packageInfo.getLongVersionCode();
            } else {
                localVersion = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取程序版本名
     *
     * @return 返回版本名称
     */
    public static String getLocalVersionName() {
        String localVersionName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            localVersionName = packageInfo.versionName;
            LogUtils.d("本软件的版本号--" + localVersionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersionName;
    }

    public static boolean isUpdate(long newVersion) {
        return newVersion > getLocalVersion();
    }
}
