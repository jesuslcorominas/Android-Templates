package com.jesuslcorominas.blank.app.di.module;

import dagger.Module;
import dagger.Provides;

import com.jesuslcorominas.blank.app.presenter.AwesomePresenter;
import com.jesuslcorominas.blank.app.presenter.impl.AwesomePresenterImpl;

/**
 * {@link dagger.Module} Dagger de la com.jesuslcorominas.blank.app.view.activity.AwesomeActivity
 */
@Module
public class AwesomeModule {

    @Provides
    AwesomePresenter provideAwesomePresenter() {
        return new AwesomePresenterImpl();
    }
}