package com.ennova.emptyproject.login;


import com.ennova.emptyproject.R;
import com.ennova.emptyproject.base.activity.BaseActivity;
import com.ennova.emptyproject.data.local.SpManager;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {
        mPresenter.checkAppVersion();
        mPresenter.putUserInfo();
    }

    @Override
    public void reload() {

    }
}
