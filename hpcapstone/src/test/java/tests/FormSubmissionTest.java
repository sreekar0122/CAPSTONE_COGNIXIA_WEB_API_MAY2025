package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FormSubmission;
import utility.constant;

import java.time.Duration;

public class FormSubmissionTest extends TestBase {

    @Test(priority = 1)
    public void validFormSubmissionTest() throws InterruptedException {
        driver.get(constant.Demoqa_appurl + constant.FORM_PAGE);
        FormSubmission formPage = new FormSubmission(driver);

        formPage.enterFirstName(constant.FORM_FIRST_NAME_VALID);
        formPage.enterLastName(constant.FORM_LAST_NAME_VALID);
        formPage.enterEmail(constant.FORM_EMAIL_VALID);
        formPage.selectGenderMale();
        formPage.enterMobile(constant.FORM_MOBILE_VALID);

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isSuccessful = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")))
                .isDisplayed();

        Thread.sleep(1000);

        Assert.assertTrue(isSuccessful, "Form submission failed.");
        log.info("Positive form submission tested successfully.");
    }

    @Test(priority = 2)
    public void invalidFormSubmissionTest() throws InterruptedException {
        driver.get(constant.Demoqa_appurl + constant.FORM_PAGE);
        FormSubmission formPage = new FormSubmission(driver);

        formPage.enterFirstName(constant.FORM_FIRST_NAME_INVALID);
        formPage.enterLastName(constant.FORM_LAST_NAME_INVALID);
        formPage.enterEmail(constant.FORM_EMAIL_INVALID);
        formPage.selectGenderMale();
        formPage.enterMobile(constant.FORM_MOBILE_INVALID);

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        Thread.sleep(1500);

        boolean modalExists = driver.findElements(By.id("example-modal-sizes-title-lg")).size() > 0;
        Assert.assertFalse(modalExists, "Modal should not appear on invalid submission.");

        log.info("Negative form submission tested successfully.");
    }
}
