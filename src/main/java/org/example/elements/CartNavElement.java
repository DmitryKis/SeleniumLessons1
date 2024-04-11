package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;

public class CartNavElement {

    private static String CART_PATH = "//div[@id='cart']";
    private static String CART_QUANTITY_COUNTER_PATH = "//div[@id='cart']//span[@class='quantity']";

    public static WebElement CART(){
        return getWebDriver().findElement(By.xpath(CART_PATH));
    }


    public static String getCartQuantity() {
        return getWebDriver().findElement(By.xpath(CART_QUANTITY_COUNTER_PATH)).getText();
    }
}
