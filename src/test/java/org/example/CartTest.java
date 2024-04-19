package org.example;

import org.junit.After;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class CartTest {

    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addAndRemoveCartTest() {
        for (int i = 0; i < 3; i++) {
            mainPage.goTo().mostPopularProduct.click();
            productPage.addToCart();
        }
        cartPage.goTo();
        for (int i = 0; i < cartPage.getCountOfDifferentProduct(); i++) {
            cartPage.removeCurrentProduct();
        }
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
