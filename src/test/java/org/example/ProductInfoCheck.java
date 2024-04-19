package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;

public class ProductInfoCheck {

    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    @Before
    public void open(){
        mainPage.goTo();
    }

    @Test
    public void ProductInfoCheck() throws Exception {
        Map<String, String> cardInfo = mainPage.getCampaingsProductInfoWithCheckStyle();
        mainPage.firstCampaingsProduct.click();
        productPage.checkCampaingsProductInfoWithCheckStyle(cardInfo);
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
