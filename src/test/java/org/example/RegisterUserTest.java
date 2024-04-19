package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.LoginPage.getWebDriver;

public class RegisterUserTest {

    MainPage mainPage = new MainPage();
    @Before
    public void open(){
        RegisterPage.goTo();
    }

    @Test
    public void checkTabsTest() throws Exception {

        String password = "1234Oleg";
        String email = RegisterPage.registerTestUser("Oleg", password);
        mainPage.logout();
        mainPage.loginAs(email, password);
        mainPage.logout();
    }

    @After
    public void close(){
        getWebDriver().close();
    }
}
