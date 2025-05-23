# CAPSTONE_COGNIXIA_WEB_API_MAY2025

# 🔹Selenium Web UI Test Automation (Java + TestNG)

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
 ```

---

# 🔹API Automation with Postman + Newman

This section includes REST API test automation using Postman collections and Newman CLI.

### ✅ Requests Covered:
- `GET /objects`
- `POST /objects`
- `GET /objects/{{objectID}}`
- `PATCH /objects/{{objectID}}`
- `DELETE /objects/{{objectID}}`

### ✅ Validation Checks:
- Status Code validation (e.g., 200, 201)
- Response body content (e.g., `Apple iPhone 14`)
- Response time checks (e.g., `< 2000ms`)
- Response headers (e.g., `Content-Type: application/json`)

### ✅ How to Run Jenkins:
```bash
@echo off
echo Running Newman Tests...

:: Create output directory
if not exist "newman" mkdir newman

:: Run Newman with htmlextra reporter
newman run restful-api.dev.postman_collection.json -e restful-api-env.postman_environment.json --insecure -r htmlextra --reporter-htmlextra-export newman\report.html

:: Confirm report is created
if exist "newman\report.html" (
    echo Report generated successfully.
) else (
    echo Failed to generate report!
)

exit /b
```
---

# 🚀 Performance Testing with JMeter

This section includes `.jmx` scripts designed for performance testing both APIs and web applications.

### ✅ Test Scenarios:

- **Users:** 10
- **Ramp-up Time:** 1 sec
- **Delay:** 10 sec
- **Duration:** 120 sec

### ✅ How to Run JMeter Tests:

You can run the `.jmx` script via Command Line Interface (CLI) and generate HTML reports:

```bash
jmeter.bat -n -t "path/to/test.jmx" -l "path/to/results.log" -e -o "path/to/HTMLReport"
```
---
# 📊 JIRA Dashboard and Reports
JIRA is used to manage sprints, tasks, and test execution reports.

✅ JIRA Artifacts Covered:
Sprint Summary

Epics, Stories, Tasks

Test Cases & Executions (Xray Plugin)

Pre-conditions and Bugs

Backlog and Active Sprint View

Execution Test Result Screenshots

Dashboard & Filter Screenshots

Bug Reports with Status

Artifacts are saved as PDF or image files and organized for traceability.
