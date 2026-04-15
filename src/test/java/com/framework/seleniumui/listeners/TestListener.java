package com.framework.seleniumui.listeners;

import com.framework.seleniumui.utils.LoggerUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtils.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtils.info("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtils.error("Test FAILED: " + result.getName());
        LoggerUtils.error("Reason: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtils.warn("Test SKIPPED: " + result.getName());
    }
}