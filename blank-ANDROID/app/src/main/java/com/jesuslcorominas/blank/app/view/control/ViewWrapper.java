package com.jesuslcorominas.blank.app.view.control;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder para los adaptadores de la aplicacion
 * Parametrizado con la vista que va a mostrar los datos por pantalla
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 *
 * @see <a href="https://github.com/excilys/androidannotations/wiki/Adapters-and-lists">Adaptadores y listass</a>
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
