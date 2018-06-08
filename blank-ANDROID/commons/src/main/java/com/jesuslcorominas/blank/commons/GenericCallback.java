package com.jesuslcorominas.blank.commons;

/**
 * Interface callback para todas las peticiones de la aplicacion. Las distintas capas de la aplicacion
 * se comunican de forma directa desde la capa superior a la inferior (de Presenter a UseCase,
 * de UseCase a Repository, etc.) pero la respuesta se hace de forma indirecta con un objeto callback.
 * Con esto, podriamos hacer que las peticiones se ejecutasen en otro hilo y la respuesta en el callback
 * enviarla en el hilo que invoco la peticion. Ademas, haciendolo de esta manera, podemos controlar
 * los errores mejor, ya que en lugar de trabajar con excepciones, tenemos un metodo onError para
 * controlar los fallos.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface GenericCallback {

    /**
     * Metodo a ejecutar cuando algo ha ido mal
     *
     * @param error Objeto con el codigo de error y un mensaje informativo <b>NO INTERNACIONALIZADO</b>. Este
     *              mensaje es <b>para nosotros, NO para mostrarlo en pantalla al usuario</b>.
     */
    void onError(Error error);
}
