package org.example;

import org.openqa.selenium.By;

import static org.example.LoginPage.getWebDriver;


public class AdminPage {

    private static String MENU_ITEM_PATH = "//div[@id='box-apps-menu-wrapper']//span[text()='%name%']";
    private static String HEADER = "//h1";
    public static void clickMenuItem(String menuItemName) {
        getWebDriver().findElement(By.xpath(MENU_ITEM_PATH.replace("%name%", menuItemName))).click();
    }

    public static void checkHeader() {
        getWebDriver().findElement(By.xpath(HEADER));
    }
}
