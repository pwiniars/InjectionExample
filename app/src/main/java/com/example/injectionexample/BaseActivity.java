package com.example.injectionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by piowin on 03.11.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected EventBus mEventBus;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

}
