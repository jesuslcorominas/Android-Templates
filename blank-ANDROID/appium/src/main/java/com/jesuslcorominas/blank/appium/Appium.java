package com.jesuslcorominas.blank.appium;

import com.jesuslcorominas.blank.appium.utils.AppiumHelper;
import com.jesuslcorominas.blank.appium.view.activity.AppiumAwesomeActivity;
import com.jesuslcorominas.blank.appium.view.fragment.AppiumAwesomeFragment;

import java.util.logging.Level;
import java.util.logging.Logger;

class Appium {

    private static final int ARGS = 3;
    private static final int ARG_SERVER = 0;
    private static final int ARG_PACKAGE_NAME = 1;
    private static final int ARG_SCREENSHOTS_DIR = 2;

    private Appium() {
    }

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new Exception("Debes pasar la url del servidor de Appium, el nombre del paquete principal de la aplicacion y el nombre de la carpeta para las capturas como parametros");
            }

            String server = args[ARG_SERVER];
            String packageName = args[ARG_PACKAGE_NAME];
            String screenshotsDir = args[ARG_SCREENSHOTS_DIR];

            AppiumHelper.connectAppium(server, packageName);

            runtTests(screenshotsDir, packageName);

            AppiumHelper.disconnectAppium();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "An exception was thrown", ex);
        }
    }

    private static void runtTests(String screenshotsDir, String packageName) {
        boolean result = new AppiumAwesomeActivity().runTests(screenshotsDir, packageName) &&
                new AppiumAwesomeFragment().runTests(screenshotsDir, packageName);

        if (!result) {
            throw new RuntimeException("No se han superado los test de Appium");
        }

    }
}
