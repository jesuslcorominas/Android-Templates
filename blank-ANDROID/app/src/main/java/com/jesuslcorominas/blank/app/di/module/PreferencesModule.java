package com.jesuslcorominas.blank.app.di.module;

import android.content.Context;

import com.jesuslcorominas.blank.app.utils.PreferencesHelperImpl_;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import dagger.Module;
import dagger.Provides;


@Module
public class PreferencesModule {

    private Context context;

    public PreferencesModule(Context context) {
        this.context = context;
    }

    @Provides
    PreferencesHelper providePreferencesHelper() {
        return PreferencesHelperImpl_.getInstance_(context);
    }
}
