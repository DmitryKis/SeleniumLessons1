package org.example;

import org.example.elements.ProductCardElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;
import static org.example.fields.InputField.INPUT;

public class MainPage {

    private static String PRODUCT_CARD_PATH = "(//li[starts-with(@class,'product')])";
    private static String STICKER_PATH = "//div[starts-with(@class,'sticker')]";

    ProductCardElement firstCampaingsProduct;

    public ProductCardElement mostPopularProduct;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;
    @FindBy(xpath = "//button[@type='submit' and text() = 'Login']")
    WebElement login;



    public MainPage goTo(){
        getWebDriver().get("http://localhost/litecart/en/");
        PageFactory.initElements(getWebDriver(), this);
        firstCampaingsProduct = new ProductCardElement("//div[@id='box-campaigns']//a[@class='link']");
        mostPopularProduct = new ProductCardElement("//div[@id='box-most-popular']//a[@class='link']");
        return this;
    }

    public void checkStikers() throws Exception {
        int productsCount = getWebDriver().findElements(By.xpath(PRODUCT_CARD_PATH)).size();
        for (int i = 1; i < productsCount; i++) {
            if (getWebDriver().findElements(By.xpath(PRODUCT_CARD_PATH + "[" + i + "]"+ STICKER_PATH)).size() != 1){
                throw new Exception("Ошибка верификации стикера товара");
            }
        }
    }

    public Map<String,String> getCampaingsProductInfoWithCheckStyle() throws Exception {
        firstCampaingsProduct.checkCampaingsPriceStyle().checkRegularPriceStyle().checkRegularPriceStyle();
        Map<String,String> productInfo = Map.of(
                "name", firstCampaingsProduct.findElement(By.xpath(".//div[@class='name']")).getText(),
                "regular-price", firstCampaingsProduct.regularPrice.getText(),
                "campaings-price", firstCampaingsProduct.campaingsPrice.getText()
        );
        return productInfo;
    }

    public void loginAs(String email, String password) {
        INPUT("Email Address").sendKeys(email);
        INPUT("Password").sendKeys(password);
        login.click();
    }

    public void logout() {
        logout.click();
    }








}
