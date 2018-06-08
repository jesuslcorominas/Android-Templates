package com.jesuslcorominas.blank.data.repository.impl;

import com.jesuslcorominas.blank.commons.VoidCallback;
import com.jesuslcorominas.blank.data.datasource.PreferencesDatasource;
import com.jesuslcorominas.blank.model.repository.PreferencesRepository;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class PreferencesRepositoryImpl implements PreferencesRepository {

    private final PreferencesDatasource preferencesDatasource;

    public PreferencesRepositoryImpl(PreferencesDatasource preferencesDatasource) {
        this.preferencesDatasource = preferencesDatasource;
    }

    @Override
    public void removeToken(final VoidCallback callback) {
        preferencesDatasource.removeToken(callback);
    }


    @Override
    public void setToken(String token, final VoidCallback callback) {
        preferencesDatasource.setToken(token, callback);
    }
}
