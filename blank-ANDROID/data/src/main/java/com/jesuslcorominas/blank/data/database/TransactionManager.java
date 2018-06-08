package com.jesuslcorominas.blank.data.database;

import java.util.concurrent.Callable;

/**
 * Created by joralvar on 14/03/2018.
 */

public interface TransactionManager {

    <R> R callInTx(Callable<R> callable) throws Exception;

}
