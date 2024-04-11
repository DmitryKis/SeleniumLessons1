package org.example.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;

public class SelectField {
    private static String SELECT_PATH = "//td[contains(text(),'$name$')]//select";

    public static WebElement SELECT(String title){
        return getWebDriver().findElement(By.xpath(SELECT_PATH.replace("$name$", title)));
    }
}
