package com.jesuslcorominas.blank.data.database.objectbox;

import com.jesuslcorominas.blank.data.database.TransactionManager;

import java.util.concurrent.Callable;

import io.objectbox.BoxStore;

/**
 * Created by joralvar on 14/03/2018.
 */

public class ObjectBoxTransactionManagerImpl implements TransactionManager {

    private final BoxStore boxStore;

    public ObjectBoxTransactionManagerImpl(BoxStore boxStore) {
        this.boxStore = boxStore;
    }

    @Override
    public <R> R callInTx(Callable<R> callable) throws Exception {
        return boxStore.callInTx(callable);
    }
}
