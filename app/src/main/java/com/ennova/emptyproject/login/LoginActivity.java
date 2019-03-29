package com.ennova.emptyproject.login;


import com.ennova.emptyproject.R;
import com.ennova.emptyproject.base.activity.BaseActivity;

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
    }

    @Override
    public void reload() {

    }
}
