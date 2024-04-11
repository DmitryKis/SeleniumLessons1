package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCardElement {

    public static WebElement getRegularPrice(WebElement productCard){
        return productCard.findElement(By.xpath(".//s"));
    }
    public static WebElement getCampaingsPrice(WebElement productCard){
        return productCard.findElement(By.xpath(".//strong"));
    }

    public static void checkRegularPriceStyle(WebElement productCard) throws Exception {
        if (getRegularPrice(productCard).getCssValue("color").matches("rgba\\((\\d+), \\1, \\1, 1\\)") &&
                getRegularPrice(productCard).getCssValue("text-decoration-line").equals("line-through")
        ) return;
        else throw new Exception("Error in regular-price style");
    }

    public static void checkCampaingsPriceStyle(WebElement productCard) throws Exception {
        if (getCampaingsPrice(productCard).getCssValue("color").matches("rgba\\((\\d+), 0, 0, 1\\)") &&
                getCampaingsPrice(productCard).getCssValue("font-weight").equals("700")
        ) return;
        else throw new Exception("Error in campaings-price style");
    }

    public static void checkPricesFontSize(WebElement productCard) throws Exception {
        double campaingsPriceFontSize = Double.parseDouble(getCampaingsPrice(productCard).getCssValue("font-size").replace("px",""));
        double regularPriceFontSize = Double.parseDouble(getRegularPrice(productCard).getCssValue("font-size").replace("px",""));
        if (campaingsPriceFontSize > regularPriceFontSize) return;
        else throw new Exception("Error in prices font size");
    }
}
