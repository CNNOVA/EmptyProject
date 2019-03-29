package com.ennova.emptyproject.daggermodule;


import com.ennova.emptyproject.data.network.ApiService;
import com.ennova.emptyproject.data.network.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    DataManager provideDataManager(ApiService apiService) {
        return new DataManager(apiService);
    }

}
