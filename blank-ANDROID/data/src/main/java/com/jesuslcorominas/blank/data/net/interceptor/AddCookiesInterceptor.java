package com.jesuslcorominas.blank.data.net.interceptor;

import com.jesuslcorominas.blank.data.net.utils.NetKeys;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * {@link Interceptor} para agregar las cookies que tenga almacenadas la aplicacion.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class AddCookiesInterceptor implements Interceptor {

    /**
     * Helper para acceder a las preferencias de la aplicacion
     */
    private final PreferencesHelper preferencesHelper;

    /**
     * Constructor parametrizado que utilizara Dagger2 para inyectar las dependencias
     *
     * @param preferencesHelper Helper para acceder a las preferencias de la aplicacion
     * @see <a href="https://google.github.io/dagger/">Dagger2</a>
     */
    public AddCookiesInterceptor(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Agrega las cookies que tenga almacenadas la aplicacion que sean necesarias para las
     * peticiones Rest
     *
     * @param chain La peticion
     * @return La respuesta a la peticion
     * @throws IOException Si se produce algun error tratando la peticion
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> cookies = (HashSet<String>) preferencesHelper.getCookies();
        for (String cookie : cookies) {
            builder.addHeader(NetKeys.COOKIE, cookie);
        }

        return chain.proceed(builder.build());
    }
}
