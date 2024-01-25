package com.jaz.pages;

import com.jaz.driver.DriverManager;
import com.jaz.extentreport.ExtentLogger;

public abstract class BasePage {
    protected BasePage() {
    }

    public abstract boolean isAt();


    public String getTitleOfPage() {
        ExtentLogger.pass("Title :: "+DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    ;


}
