package com.automation.pages;

import com.automation.util.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
    public boolean isLoginPageDisplayed(){
        return loginBtn.isDisplayed();
    }
}
