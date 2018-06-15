package com.jesuslcorominas.blank.appium.view.activity;

import com.jesuslcorominas.blank.appium.AppiumTesteable;
import com.jesuslcorominas.blank.appium.utils.AppiumHelper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author Jesús López Corominas
 */
public class AppiumAwesomeActivity implements AppiumTesteable {

    @Override
    public boolean runTests(String screenshotsDir, String packageName) {
        AppiumAwesomeActivityObject appiumAwesomeActivityObject = new AppiumAwesomeActivityObject();
        PageFactory.initElements(AppiumHelper.getDriver(), appiumAwesomeActivityObject);

        AppiumHelper.getScreenshots(screenshotsDir, "01_start");

        appiumAwesomeActivityObject.itemMenuCopyrigth.click();

        AppiumHelper.getScreenshots(screenshotsDir, "02_licenses");

        appiumAwesomeActivityObject.button1.click();

        return true;
    }
}
