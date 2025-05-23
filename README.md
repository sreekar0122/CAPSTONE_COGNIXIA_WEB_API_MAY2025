# CAPSTONE_COGNIXIA_WEB_API_MAY2025

# Selenium Web UI Test Automation (Java + TestNG)

This branch contains automated UI test scripts written in Java using Selenium WebDriver and TestNG. The test framework follows the Page Object Model (POM) design pattern for improved readability and maintainability.

## ✅ Features Included:

- **Test Coverage:**
  - Login functionality
  - Form submission tests
  - Search functionality
  - Alert, IFrame, Window Handling

- **Framework Design:**
  - Page Object Model (POM)
  - Log4j logging for test activities
  - Assertions for validation using TestNG
  - Screenshot capture on test failure
  - Headless vs Headed mode toggle (configured via `config.properties`)
  - Cross-browser support (Chrome & Edge)

- **Custom Utility Methods:**
  - `ClickOnElementUsingJS(WebElement ele)`
  - `CaptureScreenshot(WebDriver driver, String fileName)`

- **Test Execution:**
  - Run tests via `testng.xml`
  - Use Maven goals: `mvn test`, `mvn clean install`

## ✅ Browser Config

Set browser type and headless mode in `config.properties`:

```properties
browser=chrome
headless=true
