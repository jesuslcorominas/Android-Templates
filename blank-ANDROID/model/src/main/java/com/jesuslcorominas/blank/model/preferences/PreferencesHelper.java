package com.jesuslcorominas.blank.model.preferences;

import java.util.Set;


public interface PreferencesHelper {

    void setCookies(Set<String> cookies);

    Set<String> getCookies();

    void removeCookies();

    void setToken(String token);

    void removeToken();

    String getToken();

}
