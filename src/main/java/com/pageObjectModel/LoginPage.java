package com.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By loginButton   = By.xpath("//input[@name='login']");

    // Getter methods for WebElements
    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    // Action methods using getters
    public void enterUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
