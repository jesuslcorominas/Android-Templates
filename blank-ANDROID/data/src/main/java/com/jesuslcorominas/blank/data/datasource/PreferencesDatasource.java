package com.jesuslcorominas.blank.data.datasource;

import com.jesuslcorominas.blank.commons.VoidCallback;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface PreferencesDatasource extends Datasource {

    void removeToken(VoidCallback callback);

    void setToken(String token, VoidCallback callback);

}


