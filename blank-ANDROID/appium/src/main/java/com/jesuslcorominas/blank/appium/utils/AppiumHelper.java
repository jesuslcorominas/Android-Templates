package com.jesuslcorominas.blank.appium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * Created by fernamar on 18/05/2017.
 */

public abstract class AppiumHelper {

    private static final int TIMEOUT = 5;

    private static Logger logger = Logger.getAnonymousLogger();

    private static AndroidDriver sDriver;

    private AppiumHelper() {
    }

    public static AndroidDriver getDriver() {
        return sDriver;
    }

    public static WebDriverWait waitDriver() {
        return new WebDriverWait(sDriver, TIMEOUT);
    }

    public static void connectAppium(String appiumServer, String packageName, String launchActivityName) throws IOException {
        URL url = new URL(appiumServer);
        URLConnection urlConnection = url.openConnection();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability("appPackage", packageName);
        capabilities.setCapability("appActivity", packageName + launchActivityName);

        sDriver = new AndroidDriver(urlConnection.getURL(),
                capabilities);

        logger.log(Level.INFO, "Android driver connected");
    }

    public static void disconnectAppium() {
        if (sDriver != null) {
            sDriver.quit();
            logger.log(Level.INFO, "Android driver disconnected");
        }
    }

    public static void getScreenshots(String screenshotsDir, String name) {
        logger.log(Level.INFO, String.format("Capturing the snapshot of the page: %s", name));

        try {
            byte[] screenshot = sDriver.getScreenshotAs(OutputType.BYTES);
            Path picturePath = Paths.get(URI.create(screenshotsDir + "/" + name + ".png").toString());
            Files.write(picturePath, screenshot);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "An exception was thrown", ex);
        }
    }

    public static WebElement findButton(String packageName, String id) {
        return findElement("android.widget.Button", packageName, id);
    }

    public static WebElement findEditText(String packageName, String id) {
        return findElement("android.widget.EditText", packageName, id);
    }

    public static WebElement findMenuITem(String packageName, String id) {
        return findTextView(packageName, id);
    }

    public static WebElement findTextView(String packageName, String id) {
        return findElement("android.widget.TextView", packageName, id);
    }

    public static WebElement findElement(String type, String packageName, String id) {
        return sDriver.findElement(By.xpath("//" + type + "[@resource-id='" + packageName + ":id/" + id + "']"));
    }

}
