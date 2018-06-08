package com.jesuslcorominas.blank.data.di.module;

import org.modelmapper.ModelMapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module
public class MapperModule {

    @Provides
    ModelMapper provideDatabaseMapper() {
        return new ModelMapper();
    }

}
