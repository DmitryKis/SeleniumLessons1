package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;
public class TabsElement {

    private static String TAB_PATH = "//li/a[text()='$name$']";

    public static WebElement TAB(String name) {
        return getWebDriver().findElement(By.xpath(TAB_PATH.replace("$name$", name)));
    }

}
