package com.framework.seleniumui.listeners;

import com.framework.seleniumui.utils.Constants;
import com.framework.seleniumui.utils.LoggerUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < Constants.RETRY_COUNT) {
            retryCount++;
            LoggerUtils.warn("Retrying test: " + result.getName()
                    + " | Attempt: " + retryCount + " of " + Constants.RETRY_COUNT);
            return true;
        }
        return false;
    }
}