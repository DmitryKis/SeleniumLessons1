package org.example.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;

public class Button {

    private static String BUTTON_PATH = "//button[contains(text(),'$name$')]";

    public static WebElement BUTTON(String title){
        return getWebDriver().findElement(By.xpath(BUTTON_PATH.replace("$name$", title)));
    }
}
