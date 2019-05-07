package ${packageName}.di.component;

import ${packageName}.di.module.${className}Module;
import ${packageName}.view.activity.${className}Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link dagger.Component} Dagger de la ${packageName}.view.activity.${className}Activity
 */
@Singleton
@Component(modules = {${className}Module.class})
public interface ${className}Component {

    void inject(${className}Activity activity);
}

