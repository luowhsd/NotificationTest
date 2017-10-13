package com.example.fangl.notificationtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by fangl on 2017/10/13.
 */

public class Myapplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
