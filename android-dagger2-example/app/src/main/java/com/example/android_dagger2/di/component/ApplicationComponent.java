package com.example.android_dagger2.di.component;

import android.app.Application;
import android.content.Context;

import com.example.android_dagger2.DemoApplication;
import com.example.android_dagger2.data.DataManager;
import com.example.android_dagger2.data.DbHelper;
import com.example.android_dagger2.data.SharedPrefsHelper;
import com.example.android_dagger2.di.ApplicationContext;
import com.example.android_dagger2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
