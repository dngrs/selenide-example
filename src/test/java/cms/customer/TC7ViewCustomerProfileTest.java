package cms.customer;

import cms.pages.MyProfilePage;
import cms.pages.customer.CustomerHomePage;
import cms.core.DriverBase;
import cms.pages.LoginPage;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_EMAIL;
import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;

public class TC7ViewCustomerProfileTest extends DriverBase{

    @Test
    public void viewAuthorProfile() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        MyProfilePage myProfilePage = new MyProfilePage();

        loginPage.openPage()
                .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.profile().clickOn();
        customerHomePage.checkUserPopup(CUSTOMER_USER_NAME, CUSTOMER_EMAIL);
        customerHomePage.profile().pressViewProfileButton();
        myProfilePage.checkCustomerMyProfilePage()
                .logOut();

    }

}



