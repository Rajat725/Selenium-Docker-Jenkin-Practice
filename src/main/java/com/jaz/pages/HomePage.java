package com.jaz.pages;

import com.jaz.driver.DriverManager;
import com.jaz.extentreport.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage() {
    }

    private final By addToCartIcon = By.cssSelector(".shopping_cart_link");

    @Override
    public boolean isAt() {
        ExtentLogger.pass("Lands On Home Page");
        WebDriverWait wait = new
                WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartIcon)).isDisplayed();
    }

    ;


}
