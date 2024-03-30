package org.example;

import org.junit.Test;

public class TabsCheckTest {

    @Test
    public void checkTabsTest(){
        LoginPage.loginAsAdmin();
        AdminPage.checkHeaders();
    }
}
