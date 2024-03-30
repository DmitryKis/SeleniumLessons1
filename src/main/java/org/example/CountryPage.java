package org.example;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.LoginPage.getWebDriver;

public class CountryPage {

    private static final String ALL_COUNTRIES_ROWS = "//tr[@class='row']";
    private static final String ALL_ZONES_NAME = "//table[@class='dataTable']//tr/td[text()][3]";

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
