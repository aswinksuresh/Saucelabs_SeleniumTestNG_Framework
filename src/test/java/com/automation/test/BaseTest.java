package com.automation.test;

import com.automation.pages.*;
import com.automation.util.ConfigReader;
import com.automation.util.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ReviewPage reviewPage;
    OrderConfirmationPage orderConfirmationPage;
    //CheckoutComplete checkoutComplete;
    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        reviewPage = new ReviewPage();
        orderConfirmationPage = new OrderConfirmationPage();
        //checkoutComplete = new CheckoutComplete();
    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
