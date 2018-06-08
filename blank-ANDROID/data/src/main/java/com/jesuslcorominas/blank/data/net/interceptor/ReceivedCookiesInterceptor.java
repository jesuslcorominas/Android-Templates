package com.jesuslcorominas.blank.data.net.interceptor;

import com.jesuslcorominas.blank.data.net.utils.NetKeys;
import com.jesuslcorominas.blank.model.preferences.PreferencesHelper;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * {@link Interceptor} para obtener las cookies necesarias para la aplicacion
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class ReceivedCookiesInterceptor implements Interceptor {

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
    public ReceivedCookiesInterceptor(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Extrae las cookies que necesite la aplicacion y las almacena en preferencias para ser
     * utilizadas en el resto de peticiones Rest
     *
     * @param chain La peticion
     * @return La respuesta a la peticion
     * @throws IOException Si se produce algun error tratando la peticion
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers(NetKeys.SET_COOKIE).isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            cookies.addAll(originalResponse.headers(NetKeys.SET_COOKIE));
            preferencesHelper.setCookies(cookies);
        }

        return originalResponse;
    }
}
