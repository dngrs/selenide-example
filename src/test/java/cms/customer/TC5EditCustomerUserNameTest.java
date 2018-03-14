package cms.customer;

import cms.core.DriverBase;
import cms.pages.customer.CustomerHomePage;
import cms.pages.LoginPage;
import cms.pages.MyProfilePage;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME_TEST;

public class TC5EditCustomerUserNameTest extends DriverBase {

    @Test
    public void editCustomerUserName() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        MyProfilePage myProfilePage = new MyProfilePage();

        loginPage.openPage()
                .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.profile().clickOn();
        customerHomePage.profile().pressViewProfileButton();
        myProfilePage.clickOnEditUsernameLink()
                .enterUsername(CUSTOMER_USER_NAME_TEST, CUSTOMER_USER_NAME)
                .pressSaveUsernameButton()
                .checkUserNameIsCorrect(CUSTOMER_USER_NAME_TEST)
                .changeUsername(CUSTOMER_USER_NAME, CUSTOMER_USER_NAME_TEST)
                .logOut();

    }

}
