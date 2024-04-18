package org.example;

import org.example.utils.RandomTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.LoginPage.getWebDriver;
import static org.example.fields.InputField.INPUT;
import static org.example.fields.SelectField.SELECT;

public class RegisterPage {

    private static String SUBMIT_PATH = "//button[@type='submit']";


    public static void goTo(){
        getWebDriver().get("http://localhost/litecart/en/create_account");
    }

    public static String registerTestUser(String firstname, String password ){
        String email = RandomTestData.getEmail();
        INPUT("Tax ID").sendKeys("123");
        INPUT("Company").sendKeys("testCompany");
        INPUT("First Name").sendKeys(firstname);
        INPUT("Last Name").sendKeys("test");
        INPUT("Address 1").sendKeys("Street");
        INPUT("Address 2").sendKeys("21");
        INPUT("Postcode").sendKeys("12332");
        SELECT("Country").sendKeys("United States");
        SELECT("Zone/State/Province").sendKeys("Alabama");
        INPUT("City").sendKeys("inAlabama");
        INPUT("Email").sendKeys(email);
        INPUT("Phone").sendKeys("+1234567890");
        INPUT("Desired Password").sendKeys(password);
        INPUT("Confirm Password").sendKeys(password);
        getWebDriver().findElement(By.xpath(SUBMIT_PATH)).click();
        return email;
    }
}
