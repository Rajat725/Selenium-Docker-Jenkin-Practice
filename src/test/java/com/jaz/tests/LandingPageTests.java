package com.jaz.tests;

import com.jaz.driver.DriverManager;
import com.jaz.listener.TestListener;
import com.jaz.pages.HomePage;
import com.jaz.pages.LandingPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;


public final class LandingPageTests extends BaseTest {
    private LandingPageTests() {
    }

    @Test
    public void assertTitle() {
        LandingPage landingPage = new LandingPage();
        Assertions.assertThat(landingPage.isAt());
        Assertions.assertThat(landingPage.getTitleOfPage()).
                isEqualToIgnoringCase("Swag Labs");
    }

    @Test
    public void invalidCredTest() {
        LandingPage landingPage = new LandingPage();
        Assertions.assertThat(landingPage.isAt());
        landingPage.setUsername(RandomStringUtils.randomAlphabetic(20))
                .setPassword(RandomStringUtils.randomAlphabetic(20))
                .clickLoginBtn();
        Assertions.assertThat(landingPage.isAt());
        Assertions.assertThat(landingPage.getErrorMessage())
                .isEqualToIgnoringCase("Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void validCredTest() {
        LandingPage landingPage = new LandingPage();
        Assertions.assertThat(landingPage.isAt());
        landingPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
        HomePage homePage = new HomePage();
        Assertions.assertThat(homePage.isAt());

    }


}
