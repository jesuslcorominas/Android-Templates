package com.jesuslcorominas.blank.commons.utils;

/**
 * Clase de utilidades para tratamiento de textos
 */
public class TextUtils {

    /**
     * Constructor privado para evitar la instanciacion
     */
    private TextUtils() {

    }

    /**
     * Devuelve el texto con la primera letra en mayuscula
     *
     * @param textToCapitalize El texto que se quiere capitalizar
     * @return El texto capitalizado
     */
    public static String capitalizeString(String textToCapitalize) {
        return Character.toUpperCase(textToCapitalize.charAt(0)) + textToCapitalize.substring(1);
    }

    /**
     * Comprueba si un texto esta vacio, comprobando si es nulo, tiene longitud 0 o solo contiene
     * espacios en blanco
     *
     * @param string El texto a comprobar
     * @return True si el texto es nulo, tiene longitud 0 o solo contiene espacios en blanco.
     * False en caso contrario
     */
    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }
}
