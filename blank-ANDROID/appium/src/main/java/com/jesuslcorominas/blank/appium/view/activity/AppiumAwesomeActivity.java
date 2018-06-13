package com.jesuslcorominas.blank.appium.view.activity;

import com.jesuslcorominas.blank.appium.AppiumTesteable;
import com.jesuslcorominas.blank.appium.utils.AppiumHelper;

import java.util.concurrent.TimeUnit;

/**
 * @author Jesús López Corominas
 */
public class AppiumAwesomeActivity implements AppiumTesteable {

    @Override
    public boolean runTests(String screenshotsDir, String packageName) {
        AppiumHelper.getScreenshots(screenshotsDir, "01_start");

        AppiumHelper.findMenuITem(packageName, "item_menu_copyright").click();

        AppiumHelper.waitDriver().withTimeout(3, TimeUnit.SECONDS);

        AppiumHelper.getScreenshots(screenshotsDir, "02_licenses");

        AppiumHelper.findButton("android", "button1").click();

        return true;
    }
}
