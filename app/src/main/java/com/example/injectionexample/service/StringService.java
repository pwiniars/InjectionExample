package com.example.injectionexample.service;

import android.content.Context;

import com.example.injectionexample.R;

import javax.inject.Inject;

/**
 * Created by piowin on 03.11.2017.
 */

public class StringService {

    private Context mContext;

    @Inject
    public StringService(Context context) {
        this.mContext = context;
    }

    public String formatString(String string) {
        return string.trim().toUpperCase().concat(mContext.getString(R.string.suffix));
    }
}
