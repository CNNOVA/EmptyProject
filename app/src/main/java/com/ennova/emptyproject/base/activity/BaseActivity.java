package com.ennova.emptyproject.base.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


import com.ennova.emptyproject.R;
import com.ennova.emptyproject.base.presenter.AbstractPresenter;
import com.ennova.emptyproject.base.view.AbstractView;
import com.ennova.emptyproject.custom.view.ZLoadingDialog;
import com.ennova.emptyproject.utils.CommonUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import pub.devrel.easypermissions.EasyPermissions;

import static android.view.View.OVER_SCROLL_NEVER;

/**
 * MVP模式的Base Activity
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements
        HasSupportFragmentInjector,
        AbstractView {


    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;
    protected ZLoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }


    @Override
    public void showErrorMsg(String errorMsg) {
        CommonUtils.showMessage(this, errorMsg);
    }

    @Override
    public void showNormal() {
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void showError() {
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void showLoading() {
        dialog = new ZLoadingDialog(mActivity);
        dialog.setLoadingColor(Color.RED)//颜色
                .setHintText(getString(R.string.loading_hint))
                .setHintTextSize(15) // 设置字体大小 dp
                .setHintTextColor(Color.GRAY)  // 设置字体颜色
                .show();
    }

    public void hideLoading() {
        if (dialog != null)
            dialog.dismiss();
    }

    public void setTextView(int resId, String s) {
        TextView textView = findViewById(resId);
        textView.setText(s);
    }

    public View getView(int resId) {
        return findViewById(resId);
    }

    public ImageView getImageView(int resId) {
        return findViewById(resId);
    }


    public RecyclerView initRecyclerView(int resId, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView = findViewById(resId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setOverScrollMode(OVER_SCROLL_NEVER);
        return recyclerView;
    }

    @Override
    public void showToast(String message) {
        CommonUtils.showMessage(mActivity, message);
    }

    public void showToast(int resId) {
        CommonUtils.showMessage(mActivity, getString(resId));
    }

    //美食、表演、特产详情页加载富文本
    public void setWebViewStr(WebView webView, String str) {
        webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
    }

    //=======================================权限的方法=====================================================
    private boolean hasPermission(String perm) {
        return EasyPermissions.hasPermissions(mActivity, perm);
    }

    private boolean hasPermissions(String[] perms) {
        return EasyPermissions.hasPermissions(this, perms);
    }

    /**
     * 获取权限的方法
     */
    public boolean getPermission(String perm, int requestCode, String explain) {
        if (hasPermission(perm)) {
            return true;
        } else {
            EasyPermissions.requestPermissions(this, explain, requestCode, perm);
            return false;
        }
    }

    /**
     * 批量获取权限的方法
     */
    public boolean getPermissions(String[] perms, int requestCode, String explain) {
        if (hasPermissions(perms)) {
            return true;
        } else {
            EasyPermissions.requestPermissions(this, explain, requestCode, perms);
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
