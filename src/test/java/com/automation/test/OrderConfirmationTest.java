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
    public  void verifyStateOfUserSaved() throws InterruptedException {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfFirstItem();
        homePage.clickOnBurgerBtn();
        homePage.doLogOut();
        Assert.assertTrue(  loginPage.isLoginPageDisplayed());
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals( homePage.isCartIconCountCorrect(),"1");

    }
    @Test
    public void sortProducts()
    {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        List<WebElement> aTozSortedProducts = homePage.getAllProducts();
        homePage.doZtoASort();
        List<WebElement> zToaSortedProducts = homePage.getAllProducts();
        Collections.reverse(aTozSortedProducts);
        Assert.assertEquals(zToaSortedProducts, aTozSortedProducts);
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
        int productsCount = homePage.getAllProducts().size();
        homePage.clickOnAllCartButtons();
        Assert.assertEquals( Integer.parseInt(homePage.isCartIconCountCorrect()),productsCount);
        homePage.clickOnShoppingCartLink();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        int carProductsCount = cartPage.getAllProducts().size();
        Assert.assertEquals(carProductsCount,productsCount);
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



