//package ctest;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//
//public class TestBase {
//    public WebDriver driver;
//    public Properties prop;
//    public Logger log = Logger.getLogger(TestBase.class);
//
//    @BeforeSuite
//    public void loadConfig() throws IOException {
//        prop = new Properties();
//        FileInputStream fis = new FileInputStream("testdata/config.properties");
//        prop.load(fis);
//        PropertyConfigurator.configure("testdata/log4j.properties");
//    }
//
//    @BeforeMethod
//    public void setup() {
//        String br = prop.getProperty("browser");
//        String headless = prop.getProperty("headless");
//
//        if (br.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            if (Boolean.parseBoolean(headless)) {
//                options.addArguments("--headless=new", "--disable-gpu");
//            }
//            driver = new ChromeDriver(options);
//        }
//
//        else if (br.equalsIgnoreCase("firefox")) {
//            FirefoxOptions options = new FirefoxOptions();
//            if (Boolean.parseBoolean(headless)) {
//                options.addArguments("--headless");
//            }
//            driver = new FirefoxDriver(options);
//        }
//
//        else if (br.equalsIgnoreCase("edge")) {
//            EdgeOptions options = new EdgeOptions();
//            if (Boolean.parseBoolean(headless)) {
//                options.addArguments("--headless=new", "--disable-gpu");
//            }
//            driver = new EdgeDriver(options);
//        }
//
//        else {
//            log.warn("Unknown browser specified. Defaulting to Chrome.");
//            driver = new ChromeDriver();
//        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        log.info(br.toUpperCase() + " launched in " + (headless.equals("true") ? "headless" : "headed") + " mode.");
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) throws Exception {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            takeScreenshot(result.getName());
//            log.error("Test Failed: " + result.getName());
//        }
//        driver.quit();
//    }
//
//    public void takeScreenshot(String name) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        File dest = new File("screenshot/" + name + ".png");
//        FileUtils.copyFile(src, dest);
//    }
//}



package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    public WebDriver driver;
    public static Properties prop = new Properties(); // Ensure it's initialized
    public Logger log = Logger.getLogger(TestBase.class);

    // Load config just once
    static {
        try {
            FileInputStream fis = new FileInputStream("testdata/config.properties");
            prop.load(fis);
            PropertyConfigurator.configure("testdata/log4j.properties");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config properties.");
        }
    }

    @BeforeMethod
    public void setup() {
        String browser = prop.getProperty("browser", "chrome");
        String headless = prop.getProperty("headless", "false");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(headless)) {
                options.addArguments("--headless=new", "--disable-gpu");
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
        	EdgeOptions options = new EdgeOptions();
        	if (Boolean.parseBoolean(headless)) {
                options.addArguments("--headless=new", "--disable-gpu");
            }
            driver = new EdgeDriver(options);
        } else {
            driver = new ChromeDriver(); // default
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Browser launched: " + browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
            log.error("Test Failed: " + result.getName());
        }
        driver.quit();
    }

    public void takeScreenshot(String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshot/" + name + ".png");
        FileUtils.copyFile(src, dest);
    }
}
