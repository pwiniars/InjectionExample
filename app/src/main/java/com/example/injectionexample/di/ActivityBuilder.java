package com.example.injectionexample.di;

import com.example.injectionexample.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by piowin on 03.11.2017.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

}
