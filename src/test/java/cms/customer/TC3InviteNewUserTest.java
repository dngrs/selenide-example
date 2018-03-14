package cms.customer;

import cms.pages.uielements.Language;
import cms.core.DriverBase;
import cms.pages.customer.CustomerHomePage;
import cms.pages.customer.CustomerPeoplePage;
import cms.pages.LoginPage;
import cms.pages.TempMailPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.switchTo;
import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;
import static cms.core.TestData.General.CG_URL;
import static cms.core.TestData.Login.LOGIN_PAGE_TITLE;
import static cms.core.TestData.TempMail.TEMP_MAIL_URL;
import static cms.util.Helper.openInNewTab;

public class TC3InviteNewUserTest extends DriverBase {

    @Test(enabled = false)
    public void inviteNewUser() {

        TempMailPage tempMailPage = new TempMailPage();
        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        CustomerPeoplePage customerPeoplePage = new CustomerPeoplePage();

        open(TEMP_MAIL_URL);
        String EMAIL = tempMailPage.getTempEmail().val();
        openInNewTab(CG_URL);
        switchTo().window(LOGIN_PAGE_TITLE);
        loginPage.changeLanguage(Language.RU)
                .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.goToPeoplePage();
        customerPeoplePage.pressInviteToProjectButton()
                .enterEmail(EMAIL)
                .pressInviteButton();
        refresh();
        customerPeoplePage.checkInvitationExists(EMAIL)
                .logOut();

    }

}
