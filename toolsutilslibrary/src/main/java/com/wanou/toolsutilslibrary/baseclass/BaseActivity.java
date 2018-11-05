package com.wanou.toolsutilslibrary.baseclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wanou.toolsutilslibrary.managerclass.ActivityManage;


/**
 * Author by wodx521
 * Date on 2018/11/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManage.addActivity(this);
        //设置页面布局资源
        setContentView(getResId());

        initView();

        initData(savedInstanceState);

    }

    /**
     * 获取资源ID
     *
     * @return 返回资源id
     */
    protected abstract int getResId();

    /**
     * 初始化视图操作
     */
    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 设置数据
     */
    protected abstract void setData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManage.removeActivity(this);
    }

    protected void viewVisible(View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                view.setVisibility(View.VISIBLE);
            }
        }
    }

    protected void viewGone(View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                view.setVisibility(View.GONE);
            }
        }
    }

    protected void viewInvisible(View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                view.setVisibility(View.INVISIBLE);
            }
        }
    }
}
