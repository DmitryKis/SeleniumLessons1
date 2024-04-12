package org.example;

import org.example.utils.Conditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.example.LoginPage.getWebDriver;

public class CountryPage {

    private static final String ALL_COUNTRIES_ROWS = "//tr[@class='row']";
    private static final String ALL_ZONES_NAME = "//table[@class='dataTable']//tr/td[text()][3]";
    private static final String EDIT_COUNTRY_LINK = "(//tr[@class='row' and contains(.,'$name$')]//a)[2]";
    private static final String EXTERNAL_LINKS = "//i[contains(@class,'fa-external-link')]";

    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);

    public static void goTo() {
        getWebDriver().get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    public static void checkTableSorting(String rowsPath) throws Exception {
        ArrayList<String> countriesName = new ArrayList<>();
        getWebDriver().findElements(By.xpath(rowsPath)).forEach(item -> countriesName.add(item.getText()));
        ArrayList<String> expectedCountriesName = (ArrayList<String>) countriesName.clone();
        Collections.sort(expectedCountriesName);
        if (countriesName.equals(expectedCountriesName)) {
            return;
        } else {
            throw new Exception("Error in Alphabet sorting");
        }
    }

    public static void goToEditCountry(String countryName){
        getWebDriver().findElement(By.xpath(EDIT_COUNTRY_LINK.replace("$name$", countryName))).click();
    }

    public static void checkExternalLinks(){
        getWebDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        int linksCount = getWebDriver().findElements(By.xpath(EXTERNAL_LINKS)).size();
        for (int i = 1; i <= linksCount ; i++) {
            String initialWindow = getWebDriver().getWindowHandle();
            Set<String> oldWindows = getWebDriver().getWindowHandles();
            getWebDriver().findElement(By.xpath("(" + EXTERNAL_LINKS + ")[" + i + "]")).click();
            String newWindow = wait.until( t-> Conditions.thereIsWindowOtherThan(oldWindows));
            getWebDriver().switchTo().window(newWindow);
            getWebDriver().close();
            getWebDriver().switchTo().window(initialWindow);
        }
    }

    public static void checkSort(String itemType) throws Exception {
        if (itemType.equals("Country")) {
            checkTableSorting(ALL_COUNTRIES_ROWS + "//a[text()]");
        } else if (itemType.equals("Zone")) {
            checkCountriesZone();
        }
    }

    public static void checkCountriesZone() throws Exception {
        ArrayList<Integer> countryRowsWithZones = new ArrayList<>();
        int tableSize = getWebDriver().findElements(By.xpath(ALL_COUNTRIES_ROWS)).size();
        for (int i = 1; i <= tableSize; i++) {
            Integer zonesCount = Integer.parseInt(getWebDriver().findElement(By.xpath(ALL_COUNTRIES_ROWS + "[" + i + "]" + "/td[6]")).getText());
            if (zonesCount > 0) {
                countryRowsWithZones.add(i);
            }
        }
        checkZoneAlphabetSort(countryRowsWithZones);
    }

    public static void checkZoneAlphabetSort(ArrayList<Integer> countryIDs) throws Exception {
        for (Integer countryID : countryIDs) {
            getWebDriver().findElement(By.xpath(ALL_COUNTRIES_ROWS + "[" + countryID + "]" + "//a[text()]")).click();
            checkTableSorting(ALL_ZONES_NAME);
            goTo();
        }
    }
}
