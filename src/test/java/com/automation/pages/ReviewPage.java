package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewPage extends BasePage {
    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class=\"summary_subtotal_label\"]")
    WebElement priceTag;

    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
    WebElement taxTag;
    @FindBy(xpath = "//div[@class=\"summary_total_label\"]")
    WebElement totalPriceTag;


    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }

    public boolean verifyTotalPrice() {
        double sum = 0.0;
        double totalProductPriceOnPage=0.0;
        double taxOnPage=0.0;
        double totalPricePlusTaxOnPage=0.0;
        for (WebElement productPrice : productPrices) {
            double val1 = Double.parseDouble(productPrice.getText().substring(1));
            sum += val1;
        }
        totalProductPriceOnPage = Double.parseDouble(priceTag.getText().replace("Item total: $",""));
        taxOnPage=Double.parseDouble(taxTag.getText().replace("Tax: $",""));
        if (sum==totalProductPriceOnPage){
             sum += taxOnPage;
        }
        totalPricePlusTaxOnPage=Double.parseDouble(totalPriceTag.getText().replace("Total: $",""));
        return sum==totalPricePlusTaxOnPage;
    }
}
