package com.wanou.toolsutilsdemo;

import android.app.Application;

import com.wanou.toolsutilslibrary.LibraryGlobalInit;

public class Myaplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LibraryGlobalInit.init(this);
    }
}
