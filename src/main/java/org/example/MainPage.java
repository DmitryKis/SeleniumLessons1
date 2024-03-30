package org.example;

import org.openqa.selenium.By;

import static org.example.LoginPage.getWebDriver;

public class MainPage {

    private static String PRODUCT_CARD_PATH = "(//li[starts-with(@class,'product')])";
    private static String STICKER_PATH = "//div[starts-with(@class,'sticker')]";


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




}
