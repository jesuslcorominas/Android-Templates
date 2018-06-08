
package com.jesuslcorominas.blank.app.utils;

import android.app.Activity;

import org.androidannotations.annotations.EBean;

/**
 * Clase de utilidad para gestionar la navegacion de la aplicacion. Todos los cambios de pantallas
 * (Activity) de la aplicacion deben hacerse a traves de este @{@link EBean}, que es inyectado
 * en todas las {@link Activity} a traves de las clases base
 * {@link com.jesuslcorominas.blank.app.view.activity.AbstractBaseActivity} y
 * {@link com.jesuslcorominas.blank.app.view.activity.AbstractBaseAppCompatActivity}
 *
 * @see <a href="https://github.com/androidannotations/androidannotations/wiki/Enhance-custom-classes">EBean</a>
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@EBean
public class Navigator {

    /**
     * Hace up en la aplicacion. En esta aplicacion, mata la Activity que lo invoca
     *
     * @param origin La activity que invoca la accion up
     * @see <a href="https://developer.android.com/design/patterns/navigation.html">Up vs Back</a>
     */
    public void up(Activity origin) {
        origin.finish();
    }


}
