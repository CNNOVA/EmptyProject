package com.ennova.emptyproject.base.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;


import com.ennova.emptyproject.R;
import com.ennova.emptyproject.base.ActivityManager;
import com.githang.statusbar.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;


/**
 * 抽象Activity
 * 1.ButterKnife绑定与解除绑定
 * 2.
 */
public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unBinder;
    protected AbstractSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initStatusBar();
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityManager.add(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }

    public void initStatusBar() {
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.withe));
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        setSlideRightIn();
    }

    public void setSlideRightIn() {
        overridePendingTransition(R.anim.activity_slide_right_in, R.anim.activity_slide_left_out);
    }

    public void setSlideLeftIn() {
        overridePendingTransition(R.anim.activity_slide_left_in, R.anim.activity_slide_right_out);
    }

    @Override
    public void finish() {
        super.finish();
        setSlideLeftIn();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.remove(this);
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    /**
     * 在initEventAndData()之前执行
     */
    protected abstract void onViewCreated();

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
