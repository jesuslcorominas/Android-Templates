package com.jesuslcorominas.blank.data.di.module;

import com.jesuslcorominas.blank.data.database.TransactionManager;
import com.jesuslcorominas.blank.data.database.objectbox.ObjectBoxTransactionManagerImpl;
import com.jesuslcorominas.blank.data.database.objectbox.entity.MyObjectBox;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {MapperModule.class})
public class DatabaseModule {

    private static DatabaseModule instance;

    private BoxStore boxStore;

    private DatabaseModule(File baseDirectory) {
        boxStore = MyObjectBox.builder().baseDirectory(baseDirectory).build();
    }

    public static DatabaseModule getInstance(File baseDirectory) {
        if (instance == null) {
            instance = new DatabaseModule(baseDirectory);
        }

        return instance;
    }

    @Provides
    @Singleton
    BoxStore provideBoxStore() {
        return boxStore;
    }

    @Provides
    TransactionManager provideTransactionManager(BoxStore boxStore) {
        return new ObjectBoxTransactionManagerImpl(boxStore);
    }
}
