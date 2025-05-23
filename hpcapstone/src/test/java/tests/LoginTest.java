package tests;

import utility.constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void loginWithInvalidCredentials() throws InterruptedException {
        driver.get(constant.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(constant.INVALID_USERNAME);
        loginPage.enterPassword(constant.INVALID_PASSWORD);
        loginPage.clickLogin();

        Thread.sleep(1000); // for visual clarity

        Assert.assertTrue(
            loginPage.getLoginMessage().contains(constant.INVALID_LOGIN_MSG),
            "Invalid login warning not displayed."
        );
        log.info("Invalid login tested successfully.");
    }

    @Test(priority = 2)
    public void loginWithWrongUsername() throws InterruptedException {
        driver.get(constant.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(constant.WRONG_USERNAME);
        loginPage.enterPassword(constant.VALID_PASSWORD);
        loginPage.clickLogin();

        Thread.sleep(1000); // for visual clarity

        Assert.assertTrue(
            loginPage.getLoginMessage().contains(constant.INVALID_LOGIN_MSG),
            "Wrong username test failed."
        );
        log.info("Wrong username login tested successfully.");
    }

    @Test(priority = 3)
    public void loginWithValidCredentials() throws InterruptedException {
        driver.get(constant.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(constant.VALID_USERNAME);
        loginPage.enterPassword(constant.VALID_PASSWORD);
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean redirected = wait.until(ExpectedConditions.urlContains(constant.PROFILE_PAGE_FRAGMENT));

        Thread.sleep(1500); // for visual clarity

        Assert.assertTrue(redirected, "Login failed or user not redirected to profile page.");
        log.info("Valid login tested successfully.");
    }
}
