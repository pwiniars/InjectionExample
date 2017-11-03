package com.example.injectionexample;

import android.app.Activity;
import android.app.Application;

import com.example.injectionexample.di.DaggerExampleApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by piowin on 03.11.2017.
 */

public class ExampleApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private static ExampleApplication sApplicationInstance;

    public static ExampleApplication getInstance() {
        return sApplicationInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerExampleApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        sApplicationInstance = this;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
