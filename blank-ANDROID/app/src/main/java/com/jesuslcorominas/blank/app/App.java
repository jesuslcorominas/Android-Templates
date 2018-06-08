package com.jesuslcorominas.blank.app;

import android.annotation.SuppressLint;
import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.jesuslcorominas.blank.app.di.component.AwesomeComponent;
import com.jesuslcorominas.blank.app.di.component.DaggerAwesomeComponent;

import org.androidannotations.annotations.EApplication;

import io.fabric.sdk.android.Fabric;

@EApplication
@SuppressLint("registered")
public class App extends Application {

    AwesomeComponent awesomeComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        if (!BuildConfig.DEBUG) {
//            // Si no estamos en debug hay que iniciar Fabric
            Fabric.with(this, new Crashlytics());
//        }

        awesomeComponent = DaggerAwesomeComponent.builder().build();
    }

    public AwesomeComponent getAwesomeComponent() {
        return awesomeComponent;
    }
}
