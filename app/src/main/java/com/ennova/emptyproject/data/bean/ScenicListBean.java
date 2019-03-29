package com.ennova.emptyproject.data.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyuejun on 2018/12/12.
 */

public class ScenicListBean {

    private int id;
    private String typeName;
    private List<ScenicArea> scenics;
    private String zyj_status;//selected(选中)/unselected(未选中)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName == null ? "" : typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ScenicArea> getScenics() {
        if (scenics == null) {
            return new ArrayList<>();
        }
        return scenics;
    }

    public void setScenics(List<ScenicArea> scenics) {
        this.scenics = scenics;
    }

    public String getZyj_status() {
        return zyj_status == null ? "" : zyj_status;
    }

    public void setZyj_status(String zyj_status) {
        this.zyj_status = zyj_status;
    }
}
