package com.jesuslcorominas.blank.data.di.module;


import com.jesuslcorominas.blank.data.datasource.PreferencesDatasource;
import com.jesuslcorominas.blank.data.repository.impl.PreferencesRepositoryImpl;
import com.jesuslcorominas.blank.model.repository.PreferencesRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {DatasourceModule.class})
public class RepositoryModule {

    @Provides
    PreferencesRepository providePreferencesRepository(PreferencesDatasource preferencesDatasource) {
        return new PreferencesRepositoryImpl(preferencesDatasource);
    }

}
