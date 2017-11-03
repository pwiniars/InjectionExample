package com.example.injectionexample.di;

import android.app.Application;

import com.example.injectionexample.ExampleApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by piowin on 03.11.2017.
 */

@Component(
        modules = {
                AndroidInjectionModule.class,
                ApplicationModule.class,
                ActivityBuilder.class
        }
)

@Singleton
public interface ExampleApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ExampleApplicationComponent build();
    }

    void inject(ExampleApplication application);
}
