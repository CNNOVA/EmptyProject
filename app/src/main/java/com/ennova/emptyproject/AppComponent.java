package com.ennova.emptyproject;

import android.app.Application;

import com.ennova.emptyproject.daggermodule.ActivityBindingModule;
import com.ennova.emptyproject.daggermodule.AppModule;
import com.ennova.emptyproject.daggermodule.ApplicationModule;
import com.ennova.emptyproject.daggermodule.FragmentBindingModule;
import com.ennova.emptyproject.daggermodule.HttpModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        HttpModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
