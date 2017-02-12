package com.iftalab.designdimentiondirection;

import android.app.Application;

import com.iftalab.designdimentiondirection.lib.I;

/**
 * Created by Acer PC on 2/10/2017.
 */

public class IftaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        I.destroy();
    }
}
