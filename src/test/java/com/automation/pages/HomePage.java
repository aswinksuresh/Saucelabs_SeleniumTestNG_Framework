package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;
    @FindBy(xpath = "//button[@class=\"btn btn_secondary btn_small btn_inventory \"]")
    List<WebElement> removeItemBtnList;


    @FindBy(xpath = "//div[@class=\"bm-burger-button\"]/button")
    WebElement burgerBtn;

    @FindBy(id="logout_sidebar_link")
    WebElement logOutBtn;
    @FindBy(className = "product_sort_container")
    WebElement sortBtn;

    @FindBy(xpath = "//option[@value=\"za\"]")
    WebElement zaSortBtn;

   @FindBy(xpath = "//div[@class=\"inventory_item_name \"]")
   List<WebElement> products;


    @FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//option[@value=\"hilo\"]")
    WebElement hiloSortBtn;

    List<WebElement> aTozSortedProducts;
    List<WebElement> zToaSortedProducts;




    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String isCartIconCountCorrect() {
        return shoppingCartLink.findElement(By.xpath("./span")).getText();
    }

    public void clickOnBurgerBtn() {
        burgerBtn.click();
    }
    public void doLogOut() {
        logOutBtn.click();
    }
    public void doZtoASort(){

       aTozSortedProducts = products;
        sortBtn.click();
        zaSortBtn.click();
    }
    public boolean isSortedFromZtoA(){
        zToaSortedProducts = products;
        Collections.reverse(aTozSortedProducts);
        return aTozSortedProducts.equals(zToaSortedProducts);

    }



    public void doPriceSortHighToLow(){
        sortBtn.click();
        hiloSortBtn.click();
    }

    public boolean isSortedByHighToLow() {
        int flag = 0;
        for(int i =0;i<productPrices.size()-1;i++){
          float  val1 = Float.parseFloat(productPrices.get(i).getText().substring(1) );
          float  val2 = Float.parseFloat(productPrices.get(i+1).getText().substring(1) );
          if (val1 >= val2){
              continue;
          }
          else {
              flag = 1;
          }
        }
        return flag==0;
    }

    public void clickOnAllCartButtons() {
        for (WebElement cartBtn : addToCartBtnList){
            cartBtn.click();
        }
    }
   public boolean isRemoveBtnDisplayed(){
        return removeItemBtnList.isEmpty();
   }

    public List<WebElement> getAllProducts() {
        return products;
    }
}
