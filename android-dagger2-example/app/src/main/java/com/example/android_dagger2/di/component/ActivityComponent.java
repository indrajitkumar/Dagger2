package com.example.android_dagger2.di.component;

import com.example.android_dagger2.MainActivity;
import com.example.android_dagger2.di.PerActivity;
import com.example.android_dagger2.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
