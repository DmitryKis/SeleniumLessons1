package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.example.LoginPage.getWebDriver;

public class ProductStickersCheckTest {
    MainPage mainPage = new MainPage();

    @Before
    public void open(){
        mainPage.goTo();
    }

    @Test
    public void checkTabsTest() throws Exception {
        mainPage.checkStikers();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
