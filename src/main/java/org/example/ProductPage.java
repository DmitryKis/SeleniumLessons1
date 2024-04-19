package org.example;

import org.example.elements.CartNavElement;
import org.example.elements.ProductCardElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.example.LoginPage.getWebDriver;
import static org.example.fields.Button.BUTTON;
import static org.example.fields.SelectField.SELECT;

public class ProductPage {
    private static String PRODUCT_TITLE = ".//h1";

    @FindBy(xpath = "//div[@id='box-product']")
    ProductCardElement productBox;
    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);

    public void checkCampaingsProductInfoWithCheckStyle(Map<String, String> productCardInfo) throws Exception {
        productBox.checkCampaingsPriceStyle().checkRegularPriceStyle().checkPricesFontSize();
        String name = productBox.findElement(By.xpath(PRODUCT_TITLE)).getText();
        String regularPrice = productBox.regularPrice.getText();
        String campaingsPrice = productBox.campaingsPrice.getText();
        // проверка заголовка
        if (!regularPrice.equals(productCardInfo.get("regular-price")) &&
                !campaingsPrice.equals(productCardInfo.get("campaings-price")) &&
                !name.equals(productCardInfo.get("name"))){
            throw new Exception("Data in product page not equals");
        }
    }

    public ProductPage addToCart(){
        CartNavElement cartNavElement = new CartNavElement();
        int initialCounter = Integer.parseInt(cartNavElement.getCartQuantity());
        try{
            SELECT("Size").sendKeys("Small");
        } catch (NoSuchElementException ignore){}
        BUTTON("Add To Cart").click();
        wait.until( t -> initialCounter < Integer.parseInt(cartNavElement.getCartQuantity()));
        return this;
    }


}
