package com.wanou.toolsutilslibrary.managerclass;

import android.app.Activity;

import com.wanou.toolsutilslibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wodx521
 * @date on 2018/8/10
 */
public class ActivityManage {
    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        LogUtils.d(activity.getLocalClassName());
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        LogUtils.d(activity.getLocalClassName());
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
