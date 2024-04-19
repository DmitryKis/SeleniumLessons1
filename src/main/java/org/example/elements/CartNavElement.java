package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.LoginPage.getWebDriver;

public class CartNavElement {

    @FindBy(xpath = "//div[@id='cart']//span[@class='quantity']")
    WebElement quantityCounter;


    public CartNavElement(){
        PageFactory.initElements(getWebDriver(), this);
    }
    public String getCartQuantity() {
        return quantityCounter.getText();
    }
}
