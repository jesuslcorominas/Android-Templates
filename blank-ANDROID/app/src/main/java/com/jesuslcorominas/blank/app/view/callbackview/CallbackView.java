package com.jesuslcorominas.blank.app.view.callbackview;

/**
 * Interface generica de respuesta para las vistas. Todas las {@link com.jesuslcorominas.blank.app.view.activity.AbstractBaseActivity}
 * o {@link com.jesuslcorominas.blank.app.view.activity.AbstractBaseAppCompatActivity} implementan
 * un CallbackView para que sus {@link com.jesuslcorominas.blank.app.presenter.Presenter} puedan devolver
 * los resultados de las distintas acciones a ejecutar.
 * <p>
 * <b>IMPORTANTE</b>: Anotar todos los metodos de esta interface o de sus interfaces hijas
 * como {@link org.androidannotations.annotations.UiThread} ya que todos los metodos
 * de los {@link com.jesuslcorominas.blank.app.presenter.Presenter} deben ser anotados como
 * {@link org.androidannotations.annotations.Background}. Asi, las llamadas al presenter y, por tanto,
 * a todas las capas inferiores de la aplicacion, se haran en segundo plano y no bloquearan la interface,
 * y en los metodos de respuesta volveran a ejecutarse en el hilo principal y podran modificar la vista
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface CallbackView {

    /**
     * Muestra la vista de progreso
     */
    void showProgress();

    /**
     * Oculta la vista de progreso
     */
    void hideProgress();

    /**
     * Muestra un error desconocido
     */
    void showUndefinedError();

    /**
     * Muestra un error de conexion a internet
     */
    void showConnectionError();

}
