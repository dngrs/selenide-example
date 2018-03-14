package cms.customer;

import cms.core.DriverBase;
import cms.pages.customer.CustomerHomePage;
import cms.pages.LoginPage;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;
import static cms.pages.uielements.Language.RU;

public class TC2ChangeInterfaceLanguageTest extends DriverBase {

    @Test
    public void changeInterfaceLanguageTest() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();

        loginPage.openPage()
                 .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.profile()
                        .setLanguagePreference(RU);
        customerHomePage.checkInterfaceLanguage()
                        .logOut();

    }

}
