package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = "#searchBox")
    WebElement searchBox;

    public void enterSearch(String text) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public boolean isResultDisplayed(String expectedText) {
        try {
            By resultLocator = By.xpath("//a[contains(text(),'" + expectedText + "')]");
            wait.until(ExpectedConditions.presenceOfElementLocated(resultLocator));
            WebElement result = driver.findElement(resultLocator);

            // Scroll into view in case it's hidden
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result);

            return result.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
