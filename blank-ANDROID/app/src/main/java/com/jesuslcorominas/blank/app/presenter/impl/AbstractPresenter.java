package com.jesuslcorominas.blank.app.presenter.impl;

import com.jesuslcorominas.blank.app.presenter.Presenter;
import com.jesuslcorominas.blank.app.view.callbackview.CallbackView;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public abstract class AbstractPresenter<V extends CallbackView> implements Presenter<V> {

    V callbackView;
    boolean resumed;

    @Override
    public void setCallbackView(V view) {
        this.callbackView = view;
    }

    @Override
    public void onResume() {
        resumed = true;
    }

    @Override
    public void onPause() {
        resumed = false;
    }

}
