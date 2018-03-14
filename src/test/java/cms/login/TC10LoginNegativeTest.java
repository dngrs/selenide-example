package cms.login;

import cms.core.DriverBase;
import cms.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_EMAIL;
import static cms.core.TestData.Customer.CUSTOMER_EMAIL_UNREGISTERED;
import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_PASSWORD_INCORRECT;

public class TC10LoginNegativeTest extends DriverBase {

    @Test(dataProvider = "loginCredentials")
    public void loginNegative(String email, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .enterEmailAddress(email)
                .enterPassword(password)
                .pressSignInButton();
        loginPage.checkErrorMessageIsDisplayed();

    }

    @DataProvider
    public static Object[][] loginCredentials() {
        return new Object[][]{
                {CUSTOMER_EMAIL, CUSTOMER_PASSWORD_INCORRECT},
                {CUSTOMER_EMAIL_UNREGISTERED, CUSTOMER_PASSWORD}
        };
    }

}
