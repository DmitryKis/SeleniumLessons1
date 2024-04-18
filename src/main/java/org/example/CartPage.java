package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.LoginPage.getWebDriver;
import static org.example.fields.Button.BUTTON;

public class CartPage {

    private static String PRODUCTS_IN_TABLE_PATH = "//td[@class='item']";
    private static String TABLE_PATH = "//div[@id='box-checkout-summary']";

    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);
    public static void goTo(){
        getWebDriver().findElement(By.xpath("//a[text()='Checkout »']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TABLE_PATH)));
    }

    public static int getCountOfDifferentProduct(){
        return getWebDriver().findElements(By.xpath("//div[@id='order_confirmation-wrapper']//td[@class='item']")).size();
    }
    public static void removeCurrentProduct(){
        int initialProductCounter = getWebDriver().findElements(By.xpath(PRODUCTS_IN_TABLE_PATH)).size();
        BUTTON("Remove").click();
        wait.until( t -> initialProductCounter > getWebDriver().findElements(By.xpath(PRODUCTS_IN_TABLE_PATH)).size());
    }


}
