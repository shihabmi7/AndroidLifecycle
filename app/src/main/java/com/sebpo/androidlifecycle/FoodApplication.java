package com.sebpo.androidlifecycle;

import android.app.Application;
import android.content.SharedPreferences;

public class FoodApplication extends Application {

    private static FoodApplication application;

    public AppSharedPreference getAppSharedPreference() {
        return appSharedPreference;
    }

    public void setAppSharedPreference(AppSharedPreference appSharedPreference) {
        this.appSharedPreference = appSharedPreference;
    }

    private AppSharedPreference appSharedPreference;


    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
        setAppSharedPreference(
                AppSharedPreference.getDefaultPreferences());
    }

    public static FoodApplication getApplication() {
        return application;
    }

    public void setApplication(
            FoodApplication application) {
        this.application = application;
    }
}
