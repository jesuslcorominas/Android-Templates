package com.jesuslcorominas.blank.model.repository;

import com.jesuslcorominas.blank.commons.VoidCallback;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface PreferencesRepository extends Repository {

    void setToken(String token, VoidCallback callback);

    void removeToken(VoidCallback callback);

}
