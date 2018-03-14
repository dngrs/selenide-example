package cms.customer;

import cms.core.DriverBase;
import cms.pages.customer.CustomerHomePage;
import cms.pages.LoginPage;
import cms.pages.MyProfilePage;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_EMAIL;
import static cms.core.TestData.Customer.CUSTOMER_EMAIL_TEST;
import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;

public class TC6EditCustomerEmailTest extends DriverBase {

    @Test
    public void editCustomerEmail() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        MyProfilePage myProfilePage = new MyProfilePage();

        loginPage.openPage()
                .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.profile().clickOn();
        customerHomePage.profile().pressViewProfileButton();
        myProfilePage.clickOnEditEmailLink()
                .enterEmail(CUSTOMER_EMAIL_TEST, CUSTOMER_EMAIL)
                .pressSaveEmailButton()
                .checkEmailIsCorrect(CUSTOMER_EMAIL_TEST)
                .changeEmail(CUSTOMER_EMAIL, CUSTOMER_EMAIL_TEST)
                .logOut();

    }

}
