package org.example;

import org.example.elements.ProductCardElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;

public class MainPage {

    private static String PRODUCT_CARD_PATH = "(//li[starts-with(@class,'product')])";
    private static String STICKER_PATH = "//div[starts-with(@class,'sticker')]";
    private static String CAMPAIGNS_PRODUCT_PATH = "//div[@id='box-campaigns']//a[@class='link']";




    public static void goTo(){
        getWebDriver().get("http://localhost/litecart/en/");
    }

    public static void checkStikers() throws Exception {
        int productsCount = getWebDriver().findElements(By.xpath(PRODUCT_CARD_PATH)).size();
        for (int i = 1; i < productsCount; i++) {
            if (getWebDriver().findElements(By.xpath(PRODUCT_CARD_PATH + "[" + i + "]"+ STICKER_PATH)).size() != 1){
                throw new Exception("Ошибка верификации стикера товара");
            }
        }
    }

    public static WebElement getFirstCampaingsProduct(){
        return getWebDriver().findElement(By.xpath(CAMPAIGNS_PRODUCT_PATH));
    }

    public static Map<String,String> getCampaingsProductInfoWithCheckStyle() throws Exception {
        WebElement productCard = getFirstCampaingsProduct();
        ProductCardElement.checkRegularPriceStyle(productCard);
        ProductCardElement.checkCampaingsPriceStyle(productCard);
        ProductCardElement.checkPricesFontSize(productCard);
        Map<String,String> productInfo = Map.of(
                "name", productCard.findElement(By.xpath(".//div[@class='name']")).getText(),
                "regular-price", productCard.findElement(By.xpath(".//s")).getText(),
                "campaings-price", productCard.findElement(By.xpath(".//strong")).getText()
        );
        return productInfo;

    }







}
