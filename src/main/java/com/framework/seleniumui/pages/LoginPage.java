package com.framework.seleniumui.pages;

import com.framework.seleniumui.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "userName-value")
    private WebElement loggedInUsername;

    @FindBy(id = "name")
    private WebElement errorMessage;


    public String getErrorMessage() {
        return elementUtils.getText(errorMessage);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        elementUtils.typeText(usernameField, username);
    }

    public void enterPassword(String password) {
        elementUtils.typeText(passwordField, password);
    }

    public void clickLogin() {
        elementUtils.clickElement(loginButton);
    }

    public String getLoggedInUsername() {
        return elementUtils.getText(loggedInUsername);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}