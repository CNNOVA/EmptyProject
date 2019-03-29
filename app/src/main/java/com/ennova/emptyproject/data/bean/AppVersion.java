package com.ennova.emptyproject.data.bean;

public class AppVersion {
    private int versionCode;
    private String versionName;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName == null ? "" : versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                '}';
    }
}
