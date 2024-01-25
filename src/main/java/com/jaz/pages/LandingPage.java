package com.jaz.pages;

import com.jaz.driver.DriverManager;
import com.jaz.extentreport.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage {

    public LandingPage() {
    }


    private By usernameText = By.id("user-name");

    private By passwordText = By.id("password");

    private By loginBtn = By.id("login-button");

    private By invalidCredError = By.cssSelector("h3[data-test='error']");

    public LandingPage setUsername(String username) {
        DriverManager.getDriver().findElement(usernameText).sendKeys(username);
        ExtentLogger.pass("Username :: "+username);
        return this;
    }

    public LandingPage setPassword(String password) {
        DriverManager.getDriver().findElement(passwordText).sendKeys(password);
        ExtentLogger.pass("Password :: "+password);
        return this;
    }

    public void clickLoginBtn() {
        DriverManager.getDriver().findElement(loginBtn).click();
        ExtentLogger.pass("Clicked :: Login Button");
    }

    public String getErrorMessage() {
        ExtentLogger.pass(DriverManager.getDriver().findElement(invalidCredError).getText());
        return DriverManager.getDriver().findElement(invalidCredError).getText();
    }


    @Override
    public boolean isAt() {
       // ExtentLogger.info("Lands On Login Page");
        WebDriverWait wait = new
                WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameText)).isDisplayed();

    }
}