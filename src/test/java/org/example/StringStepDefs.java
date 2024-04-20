package org.example;

import io.cucumber.java8.En;
import org.example.CartPage;
import org.example.MainPage;
import org.example.ProductPage;

import static org.example.LoginPage.getWebDriver;

public class StringStepDefs implements En {

    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    public StringStepDefs(){
        When("Go to Main Page", () -> {
            mainPage.goTo();
        });

        When("Add {int} popular product in cart", (Integer count) -> {
            for (int i = 0; i < count; i++) {
                mainPage.mostPopularProduct.click();
                productPage.addToCart();
                mainPage.goTo();
            }
        });

        Then("Go to Cart Page", () -> {
            cartPage.goTo();
        });

        Then("Remove all products from Cart", () -> {
            for (int i = 0; i < cartPage.getCountOfDifferentProduct(); i++) {
                cartPage.removeCurrentProduct();
            }
        });
        After(() -> {
            getWebDriver().close();
        });
    }
}
