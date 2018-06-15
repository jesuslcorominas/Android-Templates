package com.jesuslcorominas.blank.appium;

import com.jesuslcorominas.blank.appium.utils.AppiumHelper;
import com.jesuslcorominas.blank.appium.view.activity.AppiumAwesomeActivity;
import com.jesuslcorominas.blank.appium.view.fragment.AppiumAwesomeFragment;

import java.util.logging.Level;
import java.util.logging.Logger;

class Appium {

    private static final int ARGS = 4;
    private static final int ARG_SERVER = 0;
    private static final int ARG_PACKAGE_NAME = 1;
    private static final int ARG_SCREENSHOTS_DIR = 2;
    private static final int ARG_LAUNCH_ACTIVITY = 3;

    private Appium() {
    }

    public static void main(String[] args) {
        try {
            if (args.length != ARGS) {
                throw new Exception("Parametros requeridos:" +
                        "\n\tURL del servidor de Appium" +
                        "\n\tPaquete principal de la aplicacion" +
                        "\n\tCarpeta para las capturas" +
                        "\n\tActivity a lanzar");
            }

            String server = args[ARG_SERVER];
            String packageName = args[ARG_PACKAGE_NAME];
            String launchActivity = args[ARG_LAUNCH_ACTIVITY];
            String screenshotsDir = args[ARG_SCREENSHOTS_DIR];

            AppiumHelper.connectAppium(server, packageName, launchActivity);

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
