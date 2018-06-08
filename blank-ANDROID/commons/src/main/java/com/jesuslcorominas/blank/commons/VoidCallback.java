package com.jesuslcorominas.blank.commons;

/**
 * Interface {@link GenericCallback} para cuando su la peticion fue correcta, no se quiere devolver
 * ningun objeto
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface VoidCallback extends GenericCallback {

    /**
     * Metodo a ejecutar si la peticion fue exitosa
     */
    void onSuccess();
}
