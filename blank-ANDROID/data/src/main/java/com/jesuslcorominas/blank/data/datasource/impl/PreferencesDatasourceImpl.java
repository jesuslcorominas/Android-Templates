package com.jesuslcorominas.blank.data.datasource.impl;


import com.jesuslcorominas.blank.commons.Error;
import com.jesuslcorominas.blank.commons.VoidCallback;
import com.jesuslcorominas.blank.commons.utils.ErrorKeys;
import com.jesuslcorominas.blank.data.datasource.PreferencesDatasource;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class PreferencesDatasourceImpl implements PreferencesDatasource {

    private final PreferencesHelper preferencesHelper;

    public PreferencesDatasourceImpl(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public void setToken(String token, VoidCallback callback) {
        try {
            preferencesHelper.removeToken();
            preferencesHelper.setToken(token);

            callback.onSuccess();
        } catch (Exception e) {
            callback.onError(new Error(ErrorKeys.PREFERENCES_ERROR, "Error al guardar el token en preferencias: " + e.getMessage()));
        }
    }

    @Override
    public void removeToken(VoidCallback callback) {
        try {
            preferencesHelper.removeToken();

            callback.onSuccess();
        } catch (Exception e) {
            callback.onError(new Error(ErrorKeys.PREFERENCES_ERROR, "Error al eliminar el token de preferencias: " + e.getMessage()));
        }
    }
}
