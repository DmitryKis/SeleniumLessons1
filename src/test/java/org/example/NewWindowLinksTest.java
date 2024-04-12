package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.GeoZonePage.checkCountryZonesAlphabetSorting;
import static org.example.LoginPage.getWebDriver;

public class NewWindowLinksTest {

    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        CountryPage.goTo();
    }

    @Test
    public void newWindowLinksTest(){
        CountryPage.goToEditCountry("Afghanistan");
        CountryPage.checkExternalLinks();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
