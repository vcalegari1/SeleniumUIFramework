package com.framework.seleniumui.listeners;

import com.framework.seleniumui.base.BaseTest;
import com.framework.seleniumui.utils.LoggerUtils;
import com.framework.seleniumui.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtils.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtils.info("Test PASSED: " + result.getName());

        WebDriver driver = BaseTest.getDriver();
        if (driver != null) {
            byte[] screenshot = ScreenshotUtils.takeScreenshot(driver);
            Allure.addAttachment(
                    "Screenshot - " + result.getName(),
                    new ByteArrayInputStream(screenshot)
            );
            LoggerUtils.info("Screenshot captured and attached to Allure report");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtils.error("Test FAILED: " + result.getName());
        LoggerUtils.error("Reason: " + result.getThrowable().getMessage());

        WebDriver driver = BaseTest.getDriver();
        if (driver != null) {
            byte[] screenshot = ScreenshotUtils.takeScreenshot(driver);
            Allure.addAttachment(
                    "Screenshot - " + result.getName(),
                    new ByteArrayInputStream(screenshot)
            );
            ScreenshotUtils.saveScreenshot(driver, result.getName());
            LoggerUtils.info("Screenshot captured and attached to Allure report");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtils.warn("Test SKIPPED: " + result.getName());
    }
}