package com.ennova.emptyproject.login;

import com.ennova.emptyproject.base.presenter.AbstractPresenter;
import com.ennova.emptyproject.base.view.AbstractView;

/**
 * @作者 zhouchao
 * @日期 2019/3/27
 * @描述
 */
public interface LoginContract {

    interface View extends AbstractView {

    }

    interface Presenter extends AbstractPresenter<View> {
        void checkAppVersion();
    }
}
