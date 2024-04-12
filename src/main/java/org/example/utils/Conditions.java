package org.example.utils;

import java.util.Set;

import static org.example.LoginPage.getWebDriver;

public class Conditions {

    public static String thereIsWindowOtherThan(Set<String> oldWindows){
        Set<String> openWindows = getWebDriver().getWindowHandles();
        for (String window : openWindows){
            if(!oldWindows.contains(window)){
                return window;
            }
        }
        return null;
    }
}
