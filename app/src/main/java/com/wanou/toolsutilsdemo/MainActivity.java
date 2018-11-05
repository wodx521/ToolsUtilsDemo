package com.wanou.toolsutilsdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wanou.toolsutilslibrary.baseclass.BaseActivity;
import com.wanou.toolsutilslibrary.utils.CountDownUtils;
import com.wanou.toolsutilslibrary.utils.LogUtils;
import com.wanou.toolsutilslibrary.utils.UiUtils;

public class MainActivity extends BaseActivity {
    int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvStartTime = findViewById(R.id.tv_start_time);
        TextView pauseTime = findViewById(R.id.pause_time);
        long l = System.currentTimeMillis();
        tvStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CountDownUtils.getTimer(5, null, "重新发送");
                CountDownUtils.setTimeFinishListener(new CountDownUtils.CountTimeFinishListener() {
                    @Override
                    public void onTimeFinishListener() {
                        finish();
                    }
                });
            }
        });

        pauseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownUtils.getTimer(10, (TextView) v, "重新发送");
                CountDownUtils.setTimeFinishListener(null);
            }
        });

        boolean empty = UiUtils.isEmpty("");
        String s = UiUtils.formatString("", "0.00");
        LogUtils.d(empty + "------" + s);
    }

    @Override
    protected int getResId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void setData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CountDownUtils.cancelTimer();
    }
}
