package com.jesuslcorominas.blank.appium;

/**
 * @author Jesús López Corominas
 */
public interface AppiumTesteable {

    boolean runTests(String screenshotsDir, String packageName);
}
