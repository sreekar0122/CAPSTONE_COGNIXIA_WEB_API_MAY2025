package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.constant;

import java.util.Set;

public class ExtraFunctionalityTest extends TestBase {

    @Test(priority = 1)
    public void testActionsExample() throws InterruptedException {
        driver.get(constant.Demoqa_appurl+"buttons");
        Thread.sleep(2000);

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Thread.sleep(2000);
        actions.contextClick(rightClickBtn).perform();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed(),
                "Double click message not displayed");
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed(),
                "Right click message not displayed");
        log.info("Actions example test passed.");
    }

    @Test(priority = 2)
    public void testWindowExample() throws InterruptedException {
        driver.get(constant.Demoqa_appurl+"browser-windows");
        Thread.sleep(2000);

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabButton);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabButton);

        Thread.sleep(2000);
        String originalWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement text = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals(text.getText(),
                "This is a sample page",
                "Text not matched in new tab");

        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(originalWindow);
        log.info("Windows example test passed.");
    }

    @Test(priority = 3)
    public void testIframeExample() throws InterruptedException {
        driver.get(constant.Demoqa_appurl+"frames");
        Thread.sleep(2000);

        driver.switchTo().frame("frame1");
        Assert.assertTrue(driver.findElement(By.id("sampleHeading")).isDisplayed(),
                "Heading inside iframe not found");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        log.info("Iframe example test passed.");
    }

    @Test(priority = 4)
    public void testAlertExample() throws InterruptedException {
        driver.get(constant.Demoqa_appurl+"alerts");
        Thread.sleep(2000);

        WebElement alertBtn = driver.findElement(By.id("alertButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertBtn);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertBtn);

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("You clicked a button"),
                "Unexpected alert text");
        alert.accept();
        Thread.sleep(1000);

        log.info("Alert example test passed.");
    }
}
