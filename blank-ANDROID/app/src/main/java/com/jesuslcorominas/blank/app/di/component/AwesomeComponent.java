package com.jesuslcorominas.blank.app.di.component;

import com.jesuslcorominas.blank.app.di.module.AwesomeModule;
import com.jesuslcorominas.blank.app.view.activity.AwesomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link dagger.Component} Dagger de la com.jesuslcorominas.blank.app.view.activity.AwesomeActivity
 */
@Singleton
@Component(modules = {AwesomeModule.class})
public interface AwesomeComponent {

    void inject(AwesomeActivity activity);
}

