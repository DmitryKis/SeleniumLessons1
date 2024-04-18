package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class RegisterUserTest {

    @Before
    public void open(){
        RegisterPage.goTo();
    }

    @Test
    public void registerUserTest(){
        String password = "1234Oleg";
        String email = RegisterPage.registerTestUser("Oleg", password);
        MainPage.logout();
        MainPage.loginAs(email, password);
        MainPage.logout();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
