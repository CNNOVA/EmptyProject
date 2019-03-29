package com.ennova.emptyproject.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyuejun on 2018/3/14.
 */

public class ScenicArea implements Serializable {

    /**
     * id : 1
     * code : 1
     * name : 东升科技园北领地
     * enName : DongShengTechnologyNorthPark
     * city : null
     * isUsed : 1
     * lat : 116.362894
     * lon : 40.052172
     * pre : 1
     * detail : 东升科技园，我工作的地方
     * redio : http://baidu.com
     * state : 1
     * scale: 17
     * comment : 为了测试特做次数据
     * updateTime : 1520823387000
     * scenicRes : []
     * sides : []
     */

    private int id;
    private String code;
    private String name;
    private String enName;
    private Object city;
    private int isUsed;
    private double lat;
    private double lon;
    private int pre;
    private String detail;
    private String redio;
    private int state;
    private int scale;
    private String comment;
    private long updateTime;
    private List<?> scenicRes;
    private List<?> sides;
    private String gradeName;
    private String picture;
    private String icon;

    public ScenicArea() {

    }

    public ScenicArea(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName == null ? "" : enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public String getDetail() {
        return detail == null ? "" : detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRedio() {
        return redio == null ? "" : redio;
    }

    public void setRedio(String redio) {
        this.redio = redio;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getComment() {
        return comment == null ? "" : comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public List<?> getScenicRes() {
        if (scenicRes == null) {
            return new ArrayList<>();
        }
        return scenicRes;
    }

    public void setScenicRes(List<?> scenicRes) {
        this.scenicRes = scenicRes;
    }

    public List<?> getSides() {
        if (sides == null) {
            return new ArrayList<>();
        }
        return sides;
    }

    public void setSides(List<?> sides) {
        this.sides = sides;
    }

    public String getGradeName() {
        return gradeName == null ? "" : gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getPicture() {
        return picture == null ? "" : picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIcon() {
        return icon == null ? "" : icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
