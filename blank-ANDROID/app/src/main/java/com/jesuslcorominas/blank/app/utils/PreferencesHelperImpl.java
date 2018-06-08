package com.jesuslcorominas.blank.app.utils;

import com.google.gson.Gson;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.util.Set;

@EBean
public class PreferencesHelperImpl implements PreferencesHelper {

    @Pref
    Preferences_ preferences;

    @Override
    public void setCookies(Set<String> cookies) {
        preferences.cookies().put(cookies);
    }

    @Override
    public Set<String> getCookies() {
        return preferences.cookies().get();
    }

    @Override
    public void removeCookies() {
        preferences.cookies().remove();
    }

    @Override
    public void setToken(String token) {
        preferences.token().put(token);
    }

    @Override
    public void removeToken() {
        preferences.token().remove();
    }

    @Override
    public String getToken() {
        return preferences.token().get();
    }
}
