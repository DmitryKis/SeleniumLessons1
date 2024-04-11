package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class AddProductTest {
    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        CatalogAdminPage.goTo();
    }

    @Test
    public void addProductTest() {
        CatalogAdminPage.addNewProduct();
        CatalogAdminPage.validateProduct("garage");
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
