package com.jaz.tests;

import com.jaz.constants.FrameworkConstant;
import com.jaz.listener.TestListener;
import com.jaz.utils.ReadConfigFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

import static com.jaz.driver.DriverInitialization.driverInit;
import static com.jaz.driver.DriverInitialization.launchURL;
import static com.jaz.driver.DriverInitialization.quitDriver;


public class BaseTest {

    protected BaseTest() {
    }

    @BeforeSuite
    public void initConf() {
        System.out.println("**********************////////////////////////////////");
        ReadConfigFile.initialize();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.out.println("setup");
        System.out.println(ReadConfigFile.get("browser"));
        System.out.println(ReadConfigFile.get(FrameworkConstant.SELENIUM_GRID_ENABLED));
        System.out.println(ReadConfigFile.get(FrameworkConstant.BROWSER).equalsIgnoreCase("chrome"));
        System.out.println("9999999999999999");
        driverInit();
        System.out.println("driver init");
        launchURL("https://www.saucedemo.com/", "5");
        System.out.println("launch URL");

    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
