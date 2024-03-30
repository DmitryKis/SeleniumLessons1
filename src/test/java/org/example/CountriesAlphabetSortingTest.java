package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class CountriesAlphabetSortingTest {

    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        CountryPage.goTo();
    }
    @Test
    public void CountriesAlphabetSortingCheck() throws Exception {
        CountryPage.checkSort("Country");
        CountryPage.checkSort("Zone");
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
