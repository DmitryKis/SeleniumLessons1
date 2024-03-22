package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static WebDriver driver;
    private static final String USERNAME_FIELD_PATH = "//input[@name='username']";
    private static final String PASSWORD_FIELD_PATH = "//input[@name='password']";
    private static final String SUBMIT_BUTTON_PATH = "//button[@name='login']";

    public static WebDriver getWebDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            return driver;
        } else {
            return driver;
        }
    }

    public static void loginAsAdmin() {
        // Запустить указав -Dwebdriver.chrome.driver
        getWebDriver().get("http://localhost/litecart/admin");
        getWebDriver().findElement(By.xpath(USERNAME_FIELD_PATH)).sendKeys("admin");
        getWebDriver().findElement(By.xpath(PASSWORD_FIELD_PATH)).sendKeys("admin");
        getWebDriver().findElement(By.xpath(SUBMIT_BUTTON_PATH)).click();
    }
}