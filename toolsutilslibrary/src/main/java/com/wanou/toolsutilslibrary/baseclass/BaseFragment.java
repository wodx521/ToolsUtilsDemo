package com.wanou.toolsutilslibrary.baseclass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author by wodx521
 * Date on 2018/11/5.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getResId() > 0) {
            return inflater.inflate(getResId(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initData(savedInstanceState);
    }

    /**
     * 获取布局的资源id
     *
     * @return 返回资源id
     */
    protected abstract int getResId();

    /**
     * 初始化view
     *
     * @param view 布局view
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     *
     * @param savedInstanceState 保存的数据
     */
    protected abstract void initData(Bundle savedInstanceState);

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
}
