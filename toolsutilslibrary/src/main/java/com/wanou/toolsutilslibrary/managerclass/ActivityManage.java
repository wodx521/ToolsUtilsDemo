package com.wanou.toolsutilslibrary.managerclass;

import android.app.Activity;

import com.wanou.toolsutilslibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by wodx521
 * Date on 2018/11/5.
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
