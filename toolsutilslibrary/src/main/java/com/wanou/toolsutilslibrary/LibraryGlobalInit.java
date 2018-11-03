package com.wanou.toolsutilslibrary;

import android.app.Application;

import com.wanou.toolsutilslibrary.utils.AppInfoUtils;
import com.wanou.toolsutilslibrary.utils.ClipboardUtils;
import com.wanou.toolsutilslibrary.utils.Dp2PxUtils;
import com.wanou.toolsutilslibrary.utils.LogUtils;
import com.wanou.toolsutilslibrary.utils.UiUtils;
import com.wanou.toolsutilslibrary.utils.ResUtils;
import com.wanou.toolsutilslibrary.utils.SaveImageUtils;
import com.wanou.toolsutilslibrary.utils.SpUtils;
import com.wanou.toolsutilslibrary.utils.ToastUtils;


/**
 * @author wodx521
 * @date on 2018/8/14
 */
public class LibraryGlobalInit {
    /**
     * 工具类所有需要用到上下文的初始化都写在这里统一处理，
     *
     * @param application 全局上下文
     */
    public static void init(Application application) {
        UiUtils.initContext(application);
        AppInfoUtils.initAppInfoUtils(application);
        ClipboardUtils.initClipboardUtils(application);
        Dp2PxUtils.initDp2PxUtils(application);
        LogUtils.initLogUtils(application);
        SaveImageUtils.initSaveImage(application);
        SpUtils.initSpUtils(application);
        ToastUtils.initToast(application);
        ResUtils.initGetResUtils(application);
    }
}
