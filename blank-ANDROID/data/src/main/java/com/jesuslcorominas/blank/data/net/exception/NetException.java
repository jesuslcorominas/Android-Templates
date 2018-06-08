package com.jesuslcorominas.blank.data.net.exception;

import com.jesuslcorominas.blank.commons.Error;

import java.io.IOException;

/**
 * Excepcion lanzada cuando hay un error de IO en las peticiones Rest. Si se produce un error de
 * este tipo, significa que hay un problema en la conexion.
 *
 * @see <a href="https://github.com/square/retrofit/issues/1260">Ver respuesta de JakeWharton</a>
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class NetException extends IOException {

    /**
     * El {@link Error} a enviar como cuerpo de la {@link Exception}
     */
    private final Error error;

    /**
     * Constructor parametrizado con la Exception y el Error
     *
     * @param t     La Exception producida
     * @param error El Error a propagar
     */
    public NetException(Throwable t, Error error) {
        super(t);

        this.error = error;
    }

    /**
     * Obtiene el error asociado a la Exception
     *
     * @return el error asociado a la Exception
     */
    public Error getError() {
        return error;
    }
}
