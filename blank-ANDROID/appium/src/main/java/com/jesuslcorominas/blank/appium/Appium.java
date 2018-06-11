package com.jesuslcorominas.blank.appium;

import com.jesuslcorominas.blank.appium.utils.AppiumHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

class Appium {

    private Appium() {
    }

    public static void main(String[] args) {
        try {
            // TODO controlar bien el paso de parametros. Se pueden poner nombres??
            if (args.length != 2) {
                throw new Exception("Debes pasar la url del servidor de Appium y el nombre del paquete principal de la aplicacion como parametros");
            }

            String server = args[0];
            String packageName = args[1];

            AppiumHelper.connectAppium(server, packageName);
            // TODO realizar tests
            // test(packageName);
            AppiumHelper.disconnectAppium();
        } catch (Exception ex) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "An exception was thrown", ex);
        }
    }

// Ejemplo de como podria ser un Test de instrumentacion con Appium
//
//    private static void test(String packageName) {
//        AppiumHelper.getScreenshots("start.png");
//
//        AppiumHelper.findEditText(packageName, "inputField").sendKeys("John Doe");
//        AppiumHelper.getScreenshots("after_adding_name");
//
//        AppiumHelper.findButton(packageName, "changeText").click();
//        AppiumHelper.getScreenshots("after_click_changeText");
//
//        AppiumHelper.findButton(packageName, "switchActivity").click();
//        AppiumHelper.getScreenshots("after_click_next_act");
//    }
}
