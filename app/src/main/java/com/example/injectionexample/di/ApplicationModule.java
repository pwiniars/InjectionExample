package com.example.injectionexample.di;

import android.app.Application;
import android.content.Context;

import com.example.injectionexample.event.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by piowin on 03.11.2017.
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context provideApplicationContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
        return EventBus.getDefault();
    }

}
