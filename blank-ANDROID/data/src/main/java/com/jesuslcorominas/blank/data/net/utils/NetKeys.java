package com.jesuslcorominas.blank.data.net.utils;

/**
 * @author Jesús López Corominas
 */
public abstract class NetKeys {

    /**
     * Constructor privado para evitar la instanciacion
     */
    private NetKeys() {
    }

    /**
     * Constante para recibir las Cookies de las peticiones
     */
    public static final String COOKIE = "Cookie";

    /**
     * Constante para agregar la Cookies en todas las peticiones
     */
    public static final String SET_COOKIE = "Set-Cookie";


    /**
     * Endpoints de los servicios Rest
     */
    public static final class Paths {

    }

    public static final class Headers {
        public static final String TOKEN = "token";
    }

}
