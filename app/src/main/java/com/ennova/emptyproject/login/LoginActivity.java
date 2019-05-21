package com.ennova.emptyproject.login;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ennova.emptyproject.R;
import com.ennova.emptyproject.base.activity.BaseActivity;
import com.githang.statusbar.StatusBarCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {
        initTitle();
    }

    private void initTitle() {
        ivLeft.setVisibility(View.VISIBLE);
        tvTitle.setText("登录");
        tvRight.setText("注册");
        tvRight.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.checkAppVersion();
        mPresenter.putUserInfo();
    }

    @OnClick({R.id.iv_left, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_right:
                showToast("To Register");
                break;
        }
    }

    @Override
    public void initStatusBar() {
        StatusBarCompat.setTranslucent(getWindow(), true);
    }
}
