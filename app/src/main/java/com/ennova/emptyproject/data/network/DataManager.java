package com.ennova.emptyproject.data.network;


import com.ennova.emptyproject.data.bean.BaseResponse;
import com.ennova.emptyproject.data.bean.ScenicListBean;

import java.util.List;

import io.reactivex.Observable;

public class DataManager implements ApiService {

    private ApiService apiService;

    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseResponse<List<ScenicListBean>>> getAllScenics() {
        return apiService.getAllScenics();
    }
}
