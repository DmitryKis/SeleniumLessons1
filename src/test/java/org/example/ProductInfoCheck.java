package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.example.GeoZonePage.checkCountryZonesAlphabetSorting;
import static org.example.LoginPage.getWebDriver;

public class ProductInfoCheck {

    @Before
    public void open(){
        MainPage.goTo();
    }

    @Test
    public void ProductInfoCheck() throws Exception {
        Map<String, String> cardInfo = MainPage.getCampaingsProductInfoWithCheckStyle();
        MainPage.getFirstCampaingsProduct().click();
        ProductPage.checkCampaingsProductInfoWithCheckStyle(cardInfo);
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
