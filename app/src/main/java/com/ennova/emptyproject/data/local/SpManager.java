package com.ennova.emptyproject.data.local;

import android.content.SharedPreferences;

import com.ennova.emptyproject.MyApplication;
import static android.content.Context.MODE_PRIVATE;
/**
 * @作者 zhouchao
 * @日期 2019/3/28
 * @描述
 */
public class SpManager {

    private static SpManager spManager;
    private SharedPreferences spUser;

    private SpManager() {
        spUser = MyApplication.getInstance().getSharedPreferences("user", MODE_PRIVATE);
    }

    //2017年3月14日 17:09:32 修改为DCL 单例模式
    public static SpManager getInstance() {
        if (spManager == null) {
            synchronized (SpManager.class) {
                if (spManager == null)
                    spManager = new SpManager();
            }
        }
        return spManager;
    }

    public String getUserUserInfo() {
        return spUser.getString("userInfo", "");
    }

    public void putUserUserInfo(String userInfo) {
        spUser.edit().putString("userInfo", userInfo).apply();
    }
}
