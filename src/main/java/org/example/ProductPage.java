package org.example;

import org.example.elements.CartNavElement;
import org.example.elements.ProductCardElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;
import static org.example.fields.Button.BUTTON;
import static org.example.fields.SelectField.SELECT;

public class ProductPage {

    private static String PRODUCT_BOX = "//div[@id='box-product']";
    private static String PRODUCT_TITLE = ".//h1";

    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);

    public static void checkCampaingsProductInfoWithCheckStyle(Map<String, String> productCardInfo) throws Exception {
        WebElement productCard = getWebDriver().findElement(By.xpath(PRODUCT_BOX));
        ProductCardElement.checkRegularPriceStyle(productCard);
        ProductCardElement.checkCampaingsPriceStyle(productCard);
        ProductCardElement.checkPricesFontSize(productCard);
        String name = productCard.findElement(By.xpath(PRODUCT_TITLE)).getText();
        String regularPrice = ProductCardElement.getRegularPrice(productCard).getText();
        String campaingsPrice = ProductCardElement.getCampaingsPrice(productCard).getText();
        // проверка заголовка
        if (!regularPrice.equals(productCardInfo.get("regular-price")) &&
                !campaingsPrice.equals(productCardInfo.get("campaings-price")) &&
                !name.equals(productCardInfo.get("name"))){
            throw new Exception("Data in product page not equals");
        }
    }

    public static void addToCart(){
        int initialCounter = Integer.parseInt(CartNavElement.getCartQuantity());
        try{
            SELECT("Size").sendKeys("Small");
        } catch (NoSuchElementException ignore){}
        BUTTON("Add To Cart").click();
        wait.until( t -> initialCounter < Integer.parseInt(CartNavElement.getCartQuantity()));

    }


}
