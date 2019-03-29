package com.ennova.emptyproject.data.network;

import com.ennova.emptyproject.data.bean.AppVersion;
import com.ennova.emptyproject.data.bean.BaseResponse;
import com.ennova.emptyproject.data.bean.ScenicListBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * @作者 zhouchao
 * @日期 2019/3/27
 * @描述
 */
public interface ApiService {

    String HOST = "http://tx.enn.cn/";

    /**
     * 获取所有景区接口
     */
    @POST("encdata-pandaro/scenic/getAllScenics")
    Observable<BaseResponse<List<ScenicListBean>>> getAllScenics();
}
