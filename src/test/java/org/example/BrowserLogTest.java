package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class BrowserLogTest {

    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        CatalogAdminPage.goTo();
    }

    @Test
    public void browserLogTest() throws Exception {
        CatalogAdminPage.validateProductsOpen();
        if (!getWebDriver().manage().logs().get("browser").getAll().isEmpty()) throw new Exception("Browser logs is not Empty!");
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
