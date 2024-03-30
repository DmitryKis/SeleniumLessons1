package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.example.LoginPage.getWebDriver;

public class ProductStickersCheckTest {

    @Before
    public void open(){
        MainPage.goTo();
    }

    @Test
    public void checkTabsTest() throws Exception {
        MainPage.checkStikers();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
