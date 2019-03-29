package com.ennova.emptyproject.base.presenter;



import com.ennova.emptyproject.base.view.AbstractView;

import io.reactivex.disposables.Disposable;

/**
 * Presenter 基类
 * 绑定和解绑view
 */

public interface AbstractPresenter<T extends AbstractView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);

}
