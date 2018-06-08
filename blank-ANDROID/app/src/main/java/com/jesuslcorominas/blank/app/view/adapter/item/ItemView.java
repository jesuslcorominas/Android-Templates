package com.jesuslcorominas.blank.app.view.adapter.item;

/**
 * Interface para vistas a utilizar desde los adaptadores de la aplicacion
 *
 * @see <a href="https://github.com/excilys/androidannotations/wiki/Adapters-and-lists">Android Annotations Adapters</a>
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface ItemView<T> {

    void bind(T item);
}

