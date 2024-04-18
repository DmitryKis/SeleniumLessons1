package org.example;

import org.openqa.selenium.By;

import java.io.File;

import static org.example.LoginPage.getWebDriver;
import static org.example.elements.TabsElement.TAB;
import static org.example.fields.Button.BUTTON;
import static org.example.fields.InputField.INPUT;
import static org.example.fields.SelectField.SELECT;

public class CatalogAdminPage {

    public static void goTo() {
        getWebDriver().get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
    }
    public static void validateProduct(String name) {
        getWebDriver().findElement(By.xpath("//td//a[text()='$name$']".replace("$name$", name)));
    }



    public static void addNewProduct(String name) {
        String imagePath = new File("src/main/resources/img.png").getAbsolutePath();
        getWebDriver().findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();
        INPUT("Name").sendKeys(name);
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
