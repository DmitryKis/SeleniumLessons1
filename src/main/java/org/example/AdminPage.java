package org.example;

import org.openqa.selenium.By;

import static org.example.LoginPage.getWebDriver;


public class AdminPage {

    private static String MENU_ITEM_PATH = "//div[@id='box-apps-menu-wrapper']//li[starts-with(@id,'app-')]";
    private static String SUBMENU_ITEM_PATH = "//div[@id='box-apps-menu-wrapper']//li[starts-with(@id,'doc-')]";
    private static String HEADER = "//h1";
    public static void checkHeaders() {
        int menuItemsCounter = getWebDriver().findElements(By.xpath(MENU_ITEM_PATH)).size();
        for (int i = 1; i <= menuItemsCounter; i++) {
            getWebDriver().findElement(By.xpath(MENU_ITEM_PATH + "[" + i + "]")).click();
            int menuSubItemsCounter = getWebDriver().findElements(By.xpath(SUBMENU_ITEM_PATH)).size();
            checkHeader();
            for (int j = 2; j <= menuSubItemsCounter; j++) {
                getWebDriver().findElement(By.xpath(SUBMENU_ITEM_PATH + "[" + j + "]")).click();
                checkHeader();
            }
        }
    }

    public static void checkHeader() {
        getWebDriver().findElement(By.xpath(HEADER));
    }
}
