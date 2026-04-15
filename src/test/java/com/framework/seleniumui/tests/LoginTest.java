package com.framework.seleniumui.tests;

import com.framework.seleniumui.base.BaseTest;
import com.framework.seleniumui.pages.LoginPage;
import com.framework.seleniumui.utils.Constants;
import com.framework.seleniumui.utils.LoggerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        Assert.assertEquals(loginPage.getLoggedInUsername(), Constants.VALID_USERNAME);
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), Constants.INVALID_LOGIN_MESSAGE);
    }
}