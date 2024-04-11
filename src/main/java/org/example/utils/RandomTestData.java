package org.example.utils;

import java.util.Random;

public class RandomTestData {

    public static String getEmail(){
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        return "kiselev" + randomNumber + "@gmail.com";
    }
}
