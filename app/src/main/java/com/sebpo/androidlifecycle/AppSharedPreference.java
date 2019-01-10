package com.sebpo.androidlifecycle;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppSharedPreference {

    SharedPreferences sharedPreferences;

    static AppSharedPreference appSharedPreference =
            new AppSharedPreference();

    public AppSharedPreference() {
        sharedPreferences = FoodApplication.getApplication().
                getSharedPreferences("Food",
                        MODE_PRIVATE);
    }

    public static AppSharedPreference getDefaultPreferences() {

        return appSharedPreference;
    }

    public void putString(String key, String value){
        this.removeIfValueIsNUll(key, value);
        this.sharedPreferences.edit().putString(key, value).apply();
    }

    public void putInteger(String key, Integer value){
        this.removeIfValueIsNUll(key, value);

        if (value !=   null) {
            this.sharedPreferences.edit().putInt(key, value).apply();
        }
    }

    public void putBoolean(String key, Boolean value){
        this.sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String getString(String key){
        return this.sharedPreferences.getString(key, "Content Not found");
    }

    public int getInteger(String key){
        return this.sharedPreferences.getInt(key,0);
    }

    public boolean getBoolean(String key){
        return this.sharedPreferences.getBoolean(key, false);
    }

    public void remove(String key){
        this.sharedPreferences.edit().remove(key).apply();
    }

    private void removeIfValueIsNUll(String key, Object value){
        if (value == null) {
            this.remove(key);
        }
    }

    public void clearAllValues(){
        this.sharedPreferences.edit().clear().apply();
    }

}
