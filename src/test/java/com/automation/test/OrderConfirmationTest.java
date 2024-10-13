package com.automation.test;

import com.automation.util.ConfigReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class OrderConfirmationTest extends BaseTest{
    @Test
    public void orderConfirmationTest(){
            loginPage.openWebsite();
            loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

            Assert.assertTrue(homePage.isHomePageDisplayed());
            homePage.clickOnAddToCartOfFirstItem();
            homePage.clickOnShoppingCartLink();

            Assert.assertTrue(cartPage.isCartPageDisplayed());
            cartPage.clickOnCheckoutBtn();

            Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
            checkoutPage.fillShippingInfo();
            checkoutPage.clickOnContinueBtn();

            Assert.assertTrue(reviewPage.isReviewPageDisplayed());
            reviewPage.clickOnFinishBtn();

            Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());
        }
    @Test
    public  void verifyStateOfUserSaved()  {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfFirstItem();
        homePage.clickOnBurgerBtn();
        try{
            homePage.doLogOut();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue( loginPage.isLoginPageDisplayed());
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals( homePage.isCartIconCountCorrect(),"1");

    }

}



