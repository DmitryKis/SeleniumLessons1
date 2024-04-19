package org.example.elements;

import org.openqa.selenium.*;

import static org.example.LoginPage.getWebDriver;

public class ProductCardElement{
    WebElement instance;

    public WebElement regularPrice;

    public WebElement campaingsPrice;


    public ProductCardElement(String Xpath){
        instance = getWebDriver().findElement(By.xpath(Xpath));
    }

    public ProductCardElement checkRegularPriceStyle() throws Exception {
        if (instance.findElement(By.xpath(".//s")).getCssValue("color").matches("rgba\\((\\d+), \\1, \\1, 1\\)") &&
                instance.findElement(By.xpath(".//s")).getCssValue("text-decoration-line").equals("line-through")
        ) return this;
        else throw new Exception("Error in regular-price style");
    }

    public ProductCardElement checkCampaingsPriceStyle() throws Exception {
        if (instance.findElement(By.xpath(".//strong")).getCssValue("color").matches("rgba\\((\\d+), 0, 0, 1\\)") &&
                instance.findElement(By.xpath(".//strong")).getCssValue("font-weight").equals("700")
        ) return this;
        else throw new Exception("Error in campaings-price style");
    }

    public ProductCardElement checkPricesFontSize() throws Exception {
        double campaingsPriceFontSize = Double.parseDouble(instance.findElement(By.xpath(".//strong")).getCssValue("font-size").replace("px",""));
        double regularPriceFontSize = Double.parseDouble(instance.findElement(By.xpath(".//s")).getCssValue("font-size").replace("px",""));
        if (campaingsPriceFontSize > regularPriceFontSize) return this;
        else throw new Exception("Error in prices font size");
    }

    public void click(){
        instance.click();
    }

    public WebElement findElement(By by){
        return instance.findElement(by);
    }
}
