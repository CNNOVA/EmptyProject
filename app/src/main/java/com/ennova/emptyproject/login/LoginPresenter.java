package com.ennova.emptyproject.login;

import android.util.Log;

import com.ennova.emptyproject.base.observer.BaseObserver;
import com.ennova.emptyproject.base.presenter.BasePresenter;
import com.ennova.emptyproject.data.bean.AppVersion;
import com.ennova.emptyproject.data.bean.ScenicListBean;
import com.ennova.emptyproject.data.local.SpManager;
import com.ennova.emptyproject.data.network.DataManager;
import com.ennova.emptyproject.utils.RxUtils;

import java.util.List;

import javax.inject.Inject;


/**
 * @作者 zhouchao
 * @日期 2019/3/27
 * @描述
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager dataManager;

    @Inject
    LoginPresenter(DataManager dataManager) {
        super(dataManager);
        this.dataManager = dataManager;
    }

    @Override
    public void checkAppVersion() {
        addSubscribe(dataManager.getAllScenics()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<List<ScenicListBean>>(mView) {
                    @Override
                    public void onNext(List<ScenicListBean> scenicListBeans) {
                        Log.i("LoginPresenter", "size: " + scenicListBeans.size());
                    }
                }));
    }

    @Override
    public void putUserInfo() {
        SpManager.getInstance().putUserUserInfo("存什么用户信息呢");
        SpManager.getInstance().putUserId(125);
        Log.i(TAG, "userInfo: "+SpManager.getInstance().getUserUserInfo());
        Log.i(TAG, "userId: "+SpManager.getInstance().getUserId());
        SpManager.getInstance().clearAllUserData();
        Log.i(TAG, "userInfo: "+SpManager.getInstance().getUserUserInfo());
        Log.i(TAG, "userId: "+SpManager.getInstance().getUserId());
    }
}
