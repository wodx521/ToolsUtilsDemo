package com.wanou.toolsutilslibrary.baseclass;

/**
 * @author wodx521
 * @date on 2018/8/17
 */
public interface BaseContract {
    interface BasePresenter<T> {
        /**
         * 绑定视图
         *
         * @param page 视图page
         */
        void attachView(T page);

        /**
         * 解绑视图
         */
        void detachView();
    }

    interface BaseView {

    }
}
