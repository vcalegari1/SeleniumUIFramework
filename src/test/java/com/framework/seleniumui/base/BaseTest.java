package com.framework.seleniumui.base;

import com.framework.seleniumui.config.ConfigReader;
import com.framework.seleniumui.utils.LoggerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        LoggerUtils.info("Starting test setup...");
        String browser = ConfigReader.getInstance().getProperty("browser");
        LoggerUtils.info("Browser selected: " + browser);
        WebDriver webDriver;

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }

        webDriver.manage().window().maximize();
        webDriver.get(ConfigReader.getInstance().getProperty("baseUrl"));
        driver.set(webDriver);
        LoggerUtils.info("Browser launched and navigated to: " +
                ConfigReader.getInstance().getProperty("baseUrl"));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        LoggerUtils.info("Tearing down test...");
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            LoggerUtils.info("Browser closed successfully");
        }
    }
}