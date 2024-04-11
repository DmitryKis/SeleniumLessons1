package org.example;

import org.example.elements.ProductCardElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;

public class ProductPage {

    private static String PRODUCT_BOX = "//div[@id='box-product']";
    private static String PRODUCT_TITLE = ".//h1";

    public static void checkCampaingsProductInfoWithCheckStyle(Map<String, String> productCardInfo) throws Exception {
        WebElement productCard = getWebDriver().findElement(By.xpath(PRODUCT_BOX));
        ProductCardElement.checkRegularPriceStyle(productCard);
        ProductCardElement.checkCampaingsPriceStyle(productCard);
        ProductCardElement.checkPricesFontSize(productCard);
        String name = productCard.findElement(By.xpath(PRODUCT_TITLE)).getText();
        String regularPrice = ProductCardElement.getRegularPrice(productCard).getText();
        String campaingsPrice = ProductCardElement.getCampaingsPrice(productCard).getText();
        // проверка заголовка
        if (!regularPrice.equals(productCardInfo.get("regular-price")) &&
                !campaingsPrice.equals(productCardInfo.get("campaings-price")) &&
                !name.equals(productCardInfo.get("name"))){
            throw new Exception("Data in product page not equals");
        }
    }
}
