package com.jesuslcorominas.blank.commons.utils;

/**
 * Clase con las constantes de los posibles errores de la aplicacion
 * <p>
 * 0-999 Reservados para codigos de respuesta correcta
 * 1000-1999 Codigos de error inexpecificos
 * 2000-2999 Codigos de error validaciones
 * 3000-3999 Codigos de error de preferencias
 * 4000-4999 Codigos de error de servicios Rest
 * 5000-5999 Codigos de error de base de datos
 */
public class ErrorKeys {

    /**
     * Constructor privado para evitar la instanciacion
     */
    private ErrorKeys() {

    }

    /**
     * Codigo de error para cualquier error no especificado
     */
    public static final int UNEXPECTED_ERROR = 1000;

    /**
     * Codigo de error generico de preferencias
     */
    public static final int PREFERENCES_ERROR = 3000;

    /**
     * Codigo de error para problemas con la red, como que el servidor este caido o el usuario
     * no tenga internet
     */
    public static final int NET_ERROR = 4000;

    /**
     * Codigo de error generico de base de datos
     */
    public static final int DATABASE_GENERIC_ERROR = 5000;

}
