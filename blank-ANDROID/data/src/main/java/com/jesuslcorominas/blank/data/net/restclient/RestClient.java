package com.jesuslcorominas.blank.data.net.restclient;

/**
 * Interface generica para los clientes Rest para que todos tengan una clase base por si
 * necesitasemos tener alguna funcionalidad comun.
 * <p>
 * Representa la capa de comunicacion con los servidores web a los que tenga que conectarse la
 * aplicacion.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@SuppressWarnings("WeakerAccess")
public interface RestClient {

    /**
     * Interface para retrofit con la descripcion de los metodos para las peticiones REST.
     *
     * No podemos hacer que nuestras APIs hereden de aqui porque retrofit no lo permite, pero se
     * deja a modo de ejemplo.
     *
     * @see <a href="http://square.github.io/retrofit/">Retrofit2</a>
     */
    interface Api {

    }
}
