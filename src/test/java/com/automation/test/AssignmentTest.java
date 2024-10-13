package com.automation.test;

import com.automation.util.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTest extends BaseTest {
    @Test
    public void sortProducts()
    {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.doZtoASort();
        Assert.assertTrue(homePage.isSortedFromZtoA());
    }

    @Test
    public void sortByPrice(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.doPriceSortHighToLow();
        Assert.assertTrue(homePage.isSortedByHighToLow());
    }

    @Test
    public void verifyCart(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        int homeProductsCount = homePage.getAllProducts().size();
        homePage.clickOnAllCartButtons();
        Assert.assertEquals( Integer.parseInt(homePage.isCartIconCountCorrect()),homeProductsCount);
        homePage.clickOnShoppingCartLink();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        int cartProductsCount = cartPage.getAllProducts().size();
        Assert.assertEquals(cartProductsCount,homeProductsCount);
    }
    @Test
    public void verifyCheckOut(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        int productsCount = homePage.getAllProducts().size();
        homePage.clickOnAllCartButtons();
        Assert.assertEquals( Integer.parseInt(homePage.isCartIconCountCorrect()),productsCount);
        homePage.clickOnShoppingCartLink();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        int carProductsCount = cartPage.getAllProducts().size();
        Assert.assertEquals(carProductsCount,productsCount);
        cartPage.clickOnCheckoutBtn();
        checkoutPage.isCheckoutPageDisplayed();
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();
        reviewPage.isReviewPageDisplayed();
        Assert.assertTrue(reviewPage.verifyTotalPrice());
    }

    @Test
    public void verifyRemoveBtnNotDisplayed(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAllCartButtons();
        homePage.clickOnShoppingCartLink();
        cartPage.isCartPageDisplayed();
        cartPage.clickOnCheckoutBtn();
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();
        reviewPage.isReviewPageDisplayed();
        reviewPage.clickOnFinishBtn();
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());
        orderConfirmationPage.backTOHomeBtnClick();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertTrue(homePage.isRemoveBtnDisplayed());
    }
}
