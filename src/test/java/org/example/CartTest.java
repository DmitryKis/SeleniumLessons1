package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class CartTest {

    @Test
    public void addAndRemoveCartTest() {
        for (int i = 0; i < 3; i++) {
            MainPage.goTo();
            MainPage.clickFirstMostPopularProduct();
            ProductPage.addToCart();
        }
        CartPage.goTo();
        for (int i = 0; i < 3; i++) {
            CartPage.removeCurrentProduct();
        }
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
