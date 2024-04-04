package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.LoginPage.getWebDriver;

public class GeoZonePage {

    private static final String ALL_COUNTRIES = "//tr[@class='row']//a[text()]";
    private static final String ALL_ZONES_SELECTS = "//tr/td[3]/select/option[@selected]";

    public static void goTo() {
        getWebDriver().get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    public static void checkTableSorting() throws Exception {
        ArrayList<String> zonesName = new ArrayList<>();
        getWebDriver().findElements(By.xpath(ALL_ZONES_SELECTS)).forEach(item -> zonesName.add(item.getText()));
        ArrayList<String> expectedZonesName = (ArrayList<String>) zonesName.clone();
        Collections.sort(expectedZonesName);
        if (zonesName.equals(expectedZonesName)) {
            return;
        } else {
            throw new Exception("Error in Alphabet sorting");
        }
    }

    public static void checkCountryZonesAlphabetSorting() throws Exception{
        int countryNum = getWebDriver().findElements(By.xpath(ALL_COUNTRIES)).size();
        for (int i = 1; i <= countryNum ; i++) {
            getWebDriver().findElement(By.xpath("(" + ALL_COUNTRIES +")" + "[" + i + "]")).click();
            checkTableSorting();
            goTo();
        }
    }

}
