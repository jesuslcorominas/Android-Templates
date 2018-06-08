package com.jesuslcorominas.blank.commons;


/**
 * Objeto con informacion del error.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class Error {

    /**
     * El mensaje del error. No es para mostrarlo al usuario. Es solo informativo para saber
     * que fallo.
     */
    private final String errorMessage;

    /**
     * El codigo del error. Deberia ser uno de los codigos contenidos en {@link com.jesuslcorominas.blank.commons.utils.ErrorKeys}
     */
    private final int errorCode;

    /**
     * Constructor parametrizado con el codigo y el mensaje de error
     *
     * @param errorCode    El codigo de error
     * @param errorMessage El mensaje de error
     */
    public Error(int errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * Obtiene el mensaje del error
     *
     * @return El mensaje del error
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Obtiene el codigo del error
     *
     * @return El codigo del error
     */
    public int getErrorCode() {
        return errorCode;
    }
}

