package com.jesuslcorominas.blank.appium.view.activity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author Jesús López Corominas
 */
public class AppiumAwesomeActivityObject {

    @FindBy(id = "item_menu_copyright")
    public WebElement itemMenuCopyrigth;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement button1;
}
