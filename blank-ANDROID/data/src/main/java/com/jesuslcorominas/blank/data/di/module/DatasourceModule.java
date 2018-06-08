package com.jesuslcorominas.blank.data.di.module;

import com.jesuslcorominas.blank.data.datasource.PreferencesDatasource;
import com.jesuslcorominas.blank.data.datasource.impl.PreferencesDatasourceImpl;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {NetModule.class, DatabaseModule.class})
public class DatasourceModule {

    @Provides
    PreferencesDatasource providePreferencesDatasource(PreferencesHelper preferencesHelper) {
        return new PreferencesDatasourceImpl(preferencesHelper);
    }

}
