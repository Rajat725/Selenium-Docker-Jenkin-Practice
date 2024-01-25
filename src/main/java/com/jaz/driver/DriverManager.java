package com.jaz.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    public static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void unload() {
        threadLocal.remove();
    }

}
