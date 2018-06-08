package com.jesuslcorominas.blank.app.utils;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

import java.util.Set;

/**
 * Bean de preferencias de Android Annotations.
 * <p>
 * Al anotar la clase como @{@link SharedPref}, unicamente tenemos que crear los metodos que devuelvan
 * el tipo de preferencia y con el nombre de la preferencia.
 * <p>
 * Este es el unico caso de AndroidAnnotations en el que tenemos que trabajar con la clase
 * extendida es decir {@link com.jesuslcorominas.blank.app.utils.Preferences_}
 *
 * @see <a href="https://github.com/androidannotations/androidannotations/wiki/SharedPreferencesHelpers" />
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface Preferences {

    /**
     * Preferencia que almacena las cookies de autenticacion en el servidor, que seran agregadas en todas las
     * peticiones Rest
     *
     * @return Almacena las cookies de autenticacion en el servidor
     */
    Set<String> cookies();

    /**
     * Preferncia que almacena el token de sesion
     *
     * @return Almacena informacion sobre el token de sesion
     */
    String token();
}
