package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormSubmission {
    WebDriver driver;

    public FormSubmission(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement genderMale;

    @FindBy(id = "userNumber")
    WebElement mobile;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement successModal;

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void selectGenderMale() {
        genderMale.click();
    }

    public void enterMobile(String mob) {
        mobile.sendKeys(mob);
    }

    public void clickSubmit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
    }


    public boolean isSubmissionSuccessful() {
        try {
            return successModal.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
