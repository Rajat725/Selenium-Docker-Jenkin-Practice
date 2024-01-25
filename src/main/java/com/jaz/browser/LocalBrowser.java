package com.jaz.browser;

import com.jaz.constants.FrameworkConstant;
import com.jaz.driver.DriverManager;
import com.jaz.utils.ReadConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalBrowser {

    public static void getLocalBrowser() {
        if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());


        } else if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            DriverManager.setDriver(new EdgeDriver());
        } else if (ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            DriverManager.setDriver(new FirefoxDriver());

        }

    }


}
