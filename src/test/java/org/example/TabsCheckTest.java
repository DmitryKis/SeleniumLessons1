package org.example;

import org.junit.Test;
import java.util.List;

public class TabsCheckTest {

    @Test
    public void checkTabsTest(){
        LoginPage.loginAsAdmin();
        AdminPage.checkHeaders();
    }
}
