package com.ennova.emptyproject.base.observer;

import android.text.TextUtils;
import android.util.Log;

import com.ennova.emptyproject.MyApplication;
import com.ennova.emptyproject.base.view.AbstractView;
import com.google.gson.JsonSyntaxException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @param <T>
 * @author quchao
 * @date 2017/11/27
 */

public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private AbstractView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(AbstractView view) {
        this.mView = view;
    }

    protected BaseObserver(AbstractView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(AbstractView view, boolean isShowError) {
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(AbstractView view, String errorMsg, boolean isShowError) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (mView == null) {
            return;
        }
        mView.showError();
        if (!isShowError)
            return;
        if (!TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("网络异常");
        } else if (e instanceof JsonSyntaxException) {
            mView.showErrorMsg("解析出错");
        } else {
            mView.showErrorMsg("网络异常");
        }
    }
}
