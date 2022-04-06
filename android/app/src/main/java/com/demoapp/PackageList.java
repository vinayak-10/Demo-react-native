package com.demoapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.Collections;


public class PackageList {
    private Application application;
    private final ReactNativeHost reactNativeHost;
    private final MainPackageConfig mConfig;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, null);
    }

    public PackageList(Application application) {
        this(application, null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig config) {
        this.reactNativeHost = reactNativeHost;
        mConfig = config;
    }

    public PackageList(Application application, MainPackageConfig config) {
        this.reactNativeHost = null;
        this.application = application;
        mConfig = config;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return this.getApplication().getResources();
    }

    private Application getApplication() {
        if (this.reactNativeHost == null) return this.application;
        //return this.reactNativeHost.getApplication();
        return (Application) getApplicationContext();
    }

    private Context getApplicationContext() {
        return this.getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Collections.<ReactPackage>singletonList(
                new MainReactPackage(mConfig)
        ));
    }
}
