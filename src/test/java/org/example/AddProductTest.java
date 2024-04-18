package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.example.LoginPage.getWebDriver;

public class AddProductTest {
    @Before
    public void open(){
        LoginPage.loginAsAdmin();
        CatalogAdminPage.goTo();
    }

    @Test
    public void addProductTest() {
        String productName = "garage" + new Random().nextInt(100);
        CatalogAdminPage.addNewProduct(productName);
        CatalogAdminPage.validateProduct(productName);
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
