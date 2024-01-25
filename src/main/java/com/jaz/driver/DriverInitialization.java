package com.jaz.driver;

import com.jaz.constants.FrameworkConstant;
import com.jaz.utils.ReadConfigFile;


import java.net.MalformedURLException;
import java.time.Duration;

import static com.jaz.browser.LocalBrowser.getLocalBrowser;
import static com.jaz.browser.RemoteBrowser.getRemoteBrowser;

public final class DriverInitialization {

    private DriverInitialization() {
    }

    public static void driverInit() throws MalformedURLException {

        if (ReadConfigFile.get(FrameworkConstant.SELENIUM_GRID_ENABLED)
                .equalsIgnoreCase("true")) {
            getRemoteBrowser();
        } else {
            getLocalBrowser();
        }

    }

    public static void launchURL(String url, String implTimeOut) {
        //DriverManager.getDriver().get(ReadConfigFile.getConfigValue(FrameworkConstant.APPLICATION_URL));
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implTimeOut)));
    }

    public static void quitDriver() {
        DriverManager.getDriver().quit();
    }


}
