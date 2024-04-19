package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.example.LoginPage.getWebDriver;
import static org.example.elements.TabsElement.TAB;
import static org.example.fields.Button.BUTTON;
import static org.example.fields.InputField.INPUT;
import static org.example.fields.SelectField.SELECT;

public class CatalogAdminPage {
    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);

    public static void goTo() {
        getWebDriver().get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }
    public static void validateProduct(String name) {
        getWebDriver().findElement(By.xpath("//td//a[text()='$name$']".replace("$name$", name)));
    }

    public static void validateProductsOpen(){
        int productsCount = getWebDriver().findElements(By.xpath(" //td[@id='content']//td//a[text() and contains(@href,'product')]")).size();
        for (int i = 1; i <= productsCount; i++) {
            getWebDriver().findElement(By.xpath(" (//td[@id='content']//td//a[text() and contains(@href,'product')])[" + i + "]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Edit Product:')]")));
            goTo();
        }

    }


    public static void addNewProduct() {
        String imagePath = new File("src/main/resources/img.png").getAbsolutePath();
        getWebDriver().findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();
        INPUT("Name").sendKeys("garage");
        INPUT("Code").sendKeys("123213");
        INPUT("Quantity").sendKeys("5");
        INPUT("Upload Images").sendKeys(imagePath);
        SELECT("Sold Out Status").sendKeys("Temporary sold out");
        INPUT("Date Valid From").sendKeys("01.04.2024");
        INPUT("Date Valid To").sendKeys("05.04.2024");

        TAB("Information").click();
        SELECT("Manufacturer").sendKeys("ACME Corp.");
        INPUT("Keywords").sendKeys("good garage");
        INPUT("Short Description").sendKeys("more good garage");
        INPUT("Description").sendKeys("I cried when put my garage up for sale");
        INPUT("Head Title").sendKeys("garage U dream");
        INPUT("Meta Description").sendKeys("a garage you couldn't imagine");

        TAB("Prices").click();
        INPUT("Purchase Price").sendKeys("1000");
        SELECT("Purchase Price").sendKeys("Euros");

        BUTTON("Save").click();

    }
}
