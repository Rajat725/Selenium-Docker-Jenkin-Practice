package com.jaz.browser;

import com.jaz.constants.FrameworkConstant;
import com.jaz.driver.DriverManager;
import com.jaz.utils.ReadConfigFile;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteBrowser {

    public static void getRemoteBrowser() throws MalformedURLException, MalformedURLException {
        Capabilities capabilities = null;
        if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        } else if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("edge")) {
            capabilities = new EdgeOptions();
        } else if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("firefox")) {
            capabilities = new FirefoxOptions();
        }
        String url = ReadConfigFile.get(FrameworkConstant.SELENIUM_GRID_URL_FORMAT);
        String hubHost = ReadConfigFile.get(FrameworkConstant.SELENIUM_HUB);
        String seleniumGridURL = String.format(url, hubHost);
        DriverManager.setDriver(new RemoteWebDriver(new URL(seleniumGridURL), capabilities));
    }
}
