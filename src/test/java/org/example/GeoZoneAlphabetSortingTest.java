package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.example.GeoZonePage.checkCountryZonesAlphabetSorting;
import static org.example.LoginPage.getWebDriver;

public class GeoZoneAlphabetSortingTest {

    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        GeoZonePage.goTo();
    }

    @Test
    public void GeoZoneSortingCheck() throws Exception {
        checkCountryZonesAlphabetSorting();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
