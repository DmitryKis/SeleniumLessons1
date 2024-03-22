package org.example;

import org.junit.Test;
import java.util.List;

public class TabsCheckTest {

    private List<String> TABS = List.of( "Appearence","Logotype","Catalog","Product Groups","Option Groups","Manufacturers","Suppliers","Delivery Statuses",
            "Sold Out Statuses","Quantity Units","CSV Import/Export","Countries","Currencies","Customers","CSV Import/Export","Newsletter","Geo Zones","Languages","Storage Encoding",
            "Modules","Customer","Shipping","Payment","Order Total","Order Success","Order Action","Orders","Order Statuses","Pages","Reports","Most Sold Products","Most Shopping Customers",
            "Settings","Defaults","General","Listings","Images","Checkout","Advanced","Security","Slides","Tax","Tax Rates","Translations","Scan Files","CSV Import/Export","Users","vQmods");
    @Test
    public void checkTabsTest(){
        LoginPage.loginAsAdmin();
        TABS.forEach( tab -> {
            AdminPage.clickMenuItem(tab);
            AdminPage.checkHeader();
        });


    }
}
