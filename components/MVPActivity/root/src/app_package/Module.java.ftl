package ${packageName}.di.module;

import dagger.Module;
import dagger.Provides;

import ${packageName}.presenter.${className}Presenter;
import ${packageName}.presenter.impl.${className}PresenterImpl;

/**
 * {@link dagger.Module} Dagger de la ${packageName}.view.activity.${className}Activity
 */
@Module
public class ${className}Module {

    @Provides
    ${className}Presenter provide${className}Presenter() {
        return new ${className}PresenterImpl();
    }
}