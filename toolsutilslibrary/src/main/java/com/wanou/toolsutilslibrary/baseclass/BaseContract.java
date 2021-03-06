package com.wanou.toolsutilslibrary.baseclass;

/**
 * Author by wodx521
 * Date on 2018/11/5.
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
