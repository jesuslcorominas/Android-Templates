package com.jesuslcorominas.blank.data.net.interceptor;

import com.jesuslcorominas.blank.commons.Error;
import com.jesuslcorominas.blank.commons.utils.ErrorKeys;
import com.jesuslcorominas.blank.data.net.exception.NetException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * {@link Interceptor} para las peticinoes REST para controlar los errores de red de manera global.
 * Si se produce un error de tipo IOException es que ha ocurrido un error en la red (servidor
 * caido, sin conexion, etc.) Capturamos el error y lo relanzamos con un objeto {@link Error}
 * con un codigo de error interno de los contenidos en {@link ErrorKeys}.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class NetInterceptor implements Interceptor {

    /**
     * {@inheritDoc}
     * <p>
     * Intercepta la peticion para controlar los errores de red y lanzar una {@link NetException}
     * en caso de que haya un error de red
     *
     * @param chain La peticion
     * @return La respuesta a la peticion
     * @throws IOException Si se produce algun error tratando la peticion
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        try {
            return chain.proceed(chain.request());
        } catch (IOException e) {
            throw new NetException(e, new Error(ErrorKeys.NET_ERROR, "Error en la peticion: " + e.getMessage()));
        }
    }
}
