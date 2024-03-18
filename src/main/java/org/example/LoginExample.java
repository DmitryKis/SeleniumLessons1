package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginExample {

    private static final String USERNAME_FIELD_PATH = "//input[@name='username']";
    private static final String PASSWORD_FIELD_PATH = "//input[@name='password']";
    private static final String SUBMIT_BUTTON_PATH = "//button[@name='login']";
    public static void main(String[] args) {
        // Запустить указав -Dwebdriver.chrome.driver
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.xpath(USERNAME_FIELD_PATH)).sendKeys("admin");
        driver.findElement(By.xpath(PASSWORD_FIELD_PATH)).sendKeys("admin");
        driver.findElement(By.xpath(SUBMIT_BUTTON_PATH)).click();
        driver.quit();
    }
}