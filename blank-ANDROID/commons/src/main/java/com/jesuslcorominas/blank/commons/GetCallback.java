package com.jesuslcorominas.blank.commons;


/**
 * Intefaz {@link GenericCallback} para cuando queremos obtener un objeto si la peticion fue correcta.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 *
 * @param <V> El tipo a obtener.
 */
public interface GetCallback<V> extends GenericCallback {

    /**
     * Metodo a ejecutar si la peticion es exitosa
     *
     * @param result El objeto a devolver en la peticion
     */
    void onSuccess(V result);
}
