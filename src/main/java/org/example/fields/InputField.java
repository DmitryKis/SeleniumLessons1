package org.example.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;

public class InputField {

    private static String INPUT_PATH = "//td[contains(text(),'$name$')]//input";

    public static WebElement INPUT(String title){
        return getWebDriver().findElement(By.xpath(INPUT_PATH.replace("$name$", title)));
    }
}
